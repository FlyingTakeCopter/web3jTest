package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 商品列表页
 *
 * @author zhaoyu23
 */
public class GoodslistActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mSellerIv;
    private View mClickView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        initView();
    }

    private void initView() {
        mSellerIv = findViewById(R.id.seller_iv);
        mClickView = findViewById(R.id.click_view);

        mSellerIv.setOnClickListener(this);
        mClickView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seller_iv:
                Intent intent = new Intent(this, GoodsRegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.user_iv:

                break;
            case R.id.click_view:
                Intent intent_goods_detail = new Intent(this, GoodsDetailActivity.class);
                startActivity(intent_goods_detail);
                break;
            default:
                break;
        }
    }
}