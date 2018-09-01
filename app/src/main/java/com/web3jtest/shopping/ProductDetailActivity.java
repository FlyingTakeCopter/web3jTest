package com.web3jtest.shopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.web3jtest.R;
import com.web3jtest.base.BaseActivity;

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

    }
}
