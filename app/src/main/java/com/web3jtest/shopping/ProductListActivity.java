package com.web3jtest.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.web3jtest.R;
import com.web3jtest.base.BaseActivity;

/**
 * @author xieyue5
 */
public class ProductListActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        View view = findViewById(R.id.background);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ProductDetailActivity.class));
        overridePendingTransition(0, 0);
    }
}
