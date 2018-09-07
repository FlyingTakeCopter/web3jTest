package com.web3jtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * @author zhaoyu23
 * @date 2018/9/7
 */
public class GoodsRegisterActivity extends AppCompatActivity {

    private EditText mGoodsPrice, mShineCoefficient, mCommissionCoefficient, mOnePrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mGoodsPrice = findViewById(R.id.goods_price);
        mShineCoefficient = findViewById(R.id.shine_coefficient);
        mCommissionCoefficient = findViewById(R.id.commission_coefficient);
        mOnePrice = findViewById(R.id.one_price);
    }
}
