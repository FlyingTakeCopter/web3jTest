pragma solidity ^0.4.20;

import "./SafeMath.sol";

contract AgentBase{
    using SafeMath for uint256;

    uint private sum = 0;

    struct Agent {
        address addr;
        uint weight;
        uint createTime;
        bool isvalid;
        uint profit;
    }

    Agent[] private agents;

    mapping (uint => address) public agentToOwner;
    mapping (address => uint) public ownerAgentCount;

    function createAgent(uint _weight) public {
        uint id = agents.push(Agent(msg.sender, _weight, now, true, 0)) - 1;
        agentToOwner[id] = msg.sender;
        ownerAgentCount[msg.sender]++;
        sum += _weight;
    }

    function deleteAgent(uint256 _agentId) public {
        require(
                checkAgentExist(_agentId) &&
                checkAgentValid(_agentId) &&
                checkAgentOwnerOf(_agentId)
            );
        Agent storage agent = agents[_agentId];
        require(agent.isvalid && agent.weight != 0);

        sum -= agent.weight;
        agents[_agentId].isvalid = false;
        ownerAgentCount[msg.sender]--;
    }

    function addAgentProfit(uint _agentid, uint _val) public {
        agents[_agentid].profit += _val;
    }

    function checkAgentExist(uint _agentId) public view returns (bool){
        return (_agentId >= 0 && _agentId < agents.length);
    }

    function checkAgentValid(uint _agentId) public view returns (bool){
        if(!checkAgentExist(_agentId)){
            return false;
        }
        return agents[_agentId].isvalid;
    }

    function checkAgentOwnerOf(uint _agentId) public view returns (bool){
        if(!checkAgentExist(_agentId)){
            return false;
        }
        return msg.sender == agentToOwner[_agentId];
    }

    function getAllAgentsWeight() public view returns (uint) {
        return sum;
    }

    function getAllAgentsCount() public view returns (uint){
        return agents.length;
    }

    function getOwnerAgentCount() public view returns (uint){
        return ownerAgentCount[msg.sender];
    }

    function getOwnerAgent(uint _agentIdx) public view returns (uint){
        require(_agentIdx < getOwnerAgentCount());
        Agent memory agent;
        uint idx = 0;
        uint id;
        for(uint i = 0; i < agents.length; i++){
            agent = agents[i];
            if(agent.addr == msg.sender && agent.isvalid){
                id = i;
                if(_agentIdx == idx){
                    break;
                }
                idx++;
            }
        }
        return id;
    }

    function getOwnerAgentInfo(uint _agentIdx) public view returns (uint,address, uint, uint, uint){
        require(_agentIdx < getOwnerAgentCount());
        Agent memory agent;
        uint idx = 0;
        uint id;
        for(uint i = 0; i < agents.length; i++){
            agent = agents[i];
            if(agent.addr == msg.sender && agent.isvalid){
                id = i;
                if(_agentIdx == idx){
                    break;
                }
                idx++;
            }
        }
        return (id,agent.addr,agent.weight,agent.createTime,agent.profit);
    }

    function getAgentInfo(uint _agentid) public view returns (address, uint, uint, uint){
        Agent memory agent = agents[_agentid];
        return (agent.addr,agent.weight,agent.createTime,agent.profit);
    }

    function getAgentAddress(uint _agentid) public view returns (address) {
        return agents[_agentid].addr;
    }

    function getAgentWeight(uint _agentid) public view returns (uint) {
        return agents[_agentid].weight;
    }

    function getAgentCreateTime(uint _agentid) public view returns (uint) {
        return agents[_agentid].createTime;
    }

    function getAgentValid(uint _agentid) public view returns (bool) {
        return agents[_agentid].isvalid;
    }

    function getAgentProfit(uint _agentid)public view returns (uint) {
        return agents[_agentid].profit;
    }
}
