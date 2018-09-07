pragma solidity ^0.4.20;

import "./AgentBase.sol";
import "./ERC721.sol";

contract AgentOwnerShip is AgentBase,ERC721{
    mapping (uint => address) agentApprovals;

    constructor() public {
    }

    function balanceOf(address _owner) public view returns (uint256 _balance) {
        return ownerAgentCount[_owner];
    }

    function ownerOf(uint256 _tokenId) public view returns (address _owner) {
        return agentToOwner[_tokenId];
    }

    function _transfer(address _from, address _to, uint256 _tokenId) private {
        ownerAgentCount[_to] = ownerAgentCount[_to].add(1);
        ownerAgentCount[msg.sender] = ownerAgentCount[msg.sender].sub(1);
        agentToOwner[_tokenId] = _to;
        emit Transfer(_from, _to, _tokenId);
    }

    function transfer(address _to, uint256 _tokenId) public {
        require(checkAgentOwnerOf(_tokenId));
        _transfer(msg.sender, _to, _tokenId);
    }

    function approve(address _to, uint256 _tokenId) public {
        require(checkAgentOwnerOf(_tokenId));
        agentApprovals[_tokenId] = _to;
        emit Approval(msg.sender, _to, _tokenId);
    }

    function takeOwnership(uint256 _tokenId) public {
        require(agentApprovals[_tokenId] == msg.sender);
        address owner = ownerOf(_tokenId);
        _transfer(owner, msg.sender, _tokenId);
    }
}
