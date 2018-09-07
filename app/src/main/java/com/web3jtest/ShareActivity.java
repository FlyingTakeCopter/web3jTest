package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.web3jtest.base.BaseActivity;
import com.web3jtest.shopping.ProductDetailActivity;

/**
 * @author xieyue5
 * @date 2018/9/7
 */
public class ShareActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        findViewById(R.id.goShopping).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        intent.setClass(this, ProductDetailActivity.class);
        startActivity(intent);
    }
}
