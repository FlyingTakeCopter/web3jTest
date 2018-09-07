package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.web3jtest.shopping.ProductDetailActivity;

/**
 * 商品列表页
 *
 * @author zhaoyu23
 */
public class GoodslistActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mSellerIv;
    private View mClickView;
    private ImageView mUserIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        initView();
    }

    private void initView() {
        mSellerIv = findViewById(R.id.seller_iv);
        mClickView = findViewById(R.id.click_view);
        mUserIv = findViewById(R.id.user_iv);

        mSellerIv.setOnClickListener(this);
        mClickView.setOnClickListener(this);
        mUserIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seller_iv:
                Intent intent = new Intent(this, GoodsRegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.user_iv:
                Intent intent_user = new Intent(this, UserCenterActivity.class);
                startActivity(intent_user);
                break;
            case R.id.click_view:
                startActivity(new Intent(this, ProductDetailActivity.class));
//                Intent intent_goods_detail = new Intent(this, GoodsDetailActivity.class);
//                startActivity(intent_goods_detail);
                break;
            default:
                break;
        }
    }
}
