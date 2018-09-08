package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.web3jtest.shopping.OrderActivity;
import com.web3jtest.shopping.ProductDetailActivity;
import com.web3jtest.web3.Web3jManager;

/**
 * @author xieyue5
 * @date 2018/9/7
 */
public class ShareActivity extends BaseActivity implements View.OnClickListener {
    private String userAddr;
    private String goodsAddr;
    private int agentid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        findViewById(R.id.goShopping).setOnClickListener(this);
        handleIntent();
    }

    private void handleIntent() {
        userAddr = getIntent().getStringExtra("userAddr");
        goodsAddr = getIntent().getStringExtra("goodsAddr");
        agentid = getIntent().getIntExtra("agentid", 0);
    }

    @Override
    public void onClick(View v) {
        showLoading("购买中",false);
        Web3jManager.buyByAgent(goodsAddr, Web3jManager.getAccount(0),
                Web3jManager.getPassword(), agentid, 200, new Web3jManager.ReqSellByAgentListener() {
                    @Override
                    public void onSuccess(String _goodAddr, String _buyer, String _blockAddr) {
                        Intent intent = getIntent();
                        intent.setClass(ShareActivity.this, OrderActivity.class);
                        startActivity(intent);
                        endLoading();
                    }

                    @Override
                    public void onError(Exception _e) {
                        endLoading();
                    }
                });
        overridePendingTransition(0, 0);

    }
}
