package com.web3jtest.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.web3jtest.BaseActivity;
import com.web3jtest.R;
import com.web3jtest.web3.Web3jManager;

/**
 * 万万没想到，啦啦啦啦啦
 *
 * @author xieyue5
 * @date 2018/9/1
 */
public class ProductDetailActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        findViewById(R.id.buy).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showLoading("购买中",false);
        Web3jManager.buy(Web3jManager.getContractList().get(0), Web3jManager.getAccount(1),
                Web3jManager.getPassword(), 200,new Web3jManager.ReqSellListener() {
                    @Override
                    public void onSuccess(String _goodAddr, String _buyer, String _blockAddr) {
                        startActivity(new Intent(ProductDetailActivity.this, OrderActivity.class));
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
