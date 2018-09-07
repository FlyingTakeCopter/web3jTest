pragma solidity ^0.4.24;

import './Ownable.sol';
import './AgentOwnerShip.sol';

contract Copyright is Ownable, AgentOwnerShip{
    uint8 private shineRatio;
    uint private goodval;
    uint private agentCommission;
    string private name;
    uint private allShineval;
    uint private allCommval;
    uint private singleval;

    constructor(string _name, uint _value,uint8 _ratio, uint _commission, uint _singleval) public {
        name = _name;
        goodval = _value;
        shineRatio = _ratio;
        agentCommission = _commission;
        allShineval = 0;
        allCommval = 0;
        singleval = _singleval;
    }

    function sell() public payable{
        require(msg.value >= goodval);

        uint shineval = 0;

        uint allweight = getAllAgentsWeight();
        if(allweight != 0){
            shineval = msg.value * shineRatio / 100;
            allShineval += shineval;

            for(uint i = 0; i < getAllAgentsCount(); i++){
                if(getAgentValid(i)){
                    uint val = shineval * getAgentWeight(i) / allweight;
                    getAgentAddress(i).transfer(val);
                    addAgentProfit(i,val);
                }
            }
        }

        owner.transfer(msg.value - shineval);
    }

    function sellByAgent(uint _agentid) public payable {
        require(msg.value >= goodval);

        uint commission = 0;
        if(checkAgentExist(_agentid) && checkAgentValid(_agentid)){
            commission = msg.value * agentCommission / 100;
            allCommval += commission;
            getAgentAddress(_agentid).transfer(commission);
            addAgentProfit(_agentid,commission);
        }

        uint allweight = getAllAgentsWeight();
        uint shineval = 0;
        if(allweight != 0){
            shineval = (msg.value - commission) * shineRatio / 100;
            allShineval += shineval;
            for(uint i = 0; i < getAllAgentsCount(); i++){
                if(getAgentValid(i)){
                    uint val = shineval * getAgentWeight(i) / allweight;
                    getAgentAddress(i).transfer(val);
                    addAgentProfit(i,val);
                }
            }
        }

        owner.transfer(msg.value - commission - shineval);
    }

    function setGoodsValue(uint _val) public onlyCreater {
        goodval = _val;
    }

    function getGoodsValue() public view returns (uint) {
        return goodval;
    }

    function getCommissionRatio() public view returns (uint) {
        return agentCommission;
    }

    function getShineRatio() public view returns (uint) {
        return shineRatio;
    }

    function getCurShineValue(uint _agentid) public view returns(uint) {
        uint val = goodval * (shineRatio / 100);
        val = val * getAgentWeight(_agentid) / getAllAgentsWeight();
        return val;
    }

    function getGoodsInfo() public view returns (string, uint, uint, uint, uint, uint, uint, uint, uint){
        return (name,goodval,shineRatio,agentCommission,getAllAgentsWeight(),getAllAgentsCount(),allShineval,allCommval,singleval);
    }

    function getAgentListInfo(uint _agentid) public view returns (string, uint, uint, uint, uint, uint, uint) {
        return (name,goodval,shineRatio,agentCommission,getAllAgentsWeight(),getAgentWeight(_agentid),getAgentProfit(_agentid));
    }
}
