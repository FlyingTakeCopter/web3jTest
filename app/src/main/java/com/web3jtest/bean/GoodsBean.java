package com.web3jtest.bean;

/**
 * @author zhaoyu23
 */
public class GoodsBean {
    // 商品
    String addr;
    String name;
    int price;
    int commRatio;
    int shineRatio;
    int sumAgenter;
    int allweight;
    int allShine;
    int allComm;
    int singleval;

    // 代理人
    int _agentid;
    String _owner;
    int _weight;
    int _createtime;
    float _profit;

    public int get_agentid() {
        return _agentid;
    }

    public String get_owner() {
        return _owner;
    }

    public int get_weight() {
        return _weight;
    }

    public int get_createtime() {
        return _createtime;
    }

    public float get_profit() {
        return _profit;
    }
    public void set_agentid(int _agentid) {
        this._agentid = _agentid;
    }

    public void set_owner(String _owner) {
        this._owner = _owner;
    }

    public void set_weight(int _weight) {
        this._weight = _weight;
    }

    public void set_createtime(int _createtime) {
        this._createtime = _createtime;
    }

    public void set_profit(float _profit) {
        this._profit = _profit;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCommRatio() {
        return commRatio;
    }

    public void setCommRatio(int commRatio) {
        this.commRatio = commRatio;
    }

    public int getShineRatio() {
        return shineRatio;
    }

    public void setShineRatio(int shineRatio) {
        this.shineRatio = shineRatio;
    }

    public int getSumAgenter() {
        return sumAgenter;
    }

    public void setSumAgenter(int sumAgenter) {
        this.sumAgenter = sumAgenter;
    }

    public int getAllweight() {
        return allweight;
    }

    public void setAllweight(int allweight) {
        this.allweight = allweight;
    }

    public int getAllShine() {
        return allShine;
    }

    public void setAllShine(int allShine) {
        this.allShine = allShine;
    }

    public int getAllComm() {
        return allComm;
    }

    public void setAllComm(int allComm) {
        this.allComm = allComm;
    }

    public int getSingleval() {
        return singleval;
    }

    public void setSingleval(int singleval) {
        this.singleval = singleval;
    }
}
