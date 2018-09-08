package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.web3jtest.web3.Web3jManager;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * 认购页面
 */
public class SubscriptionDetailActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView topTitle, topValue1, topValue2, topValue3;
    private TextView line1, line2, line3, line4, line5, line6, line7, line8, line9;
    private TextView btnLeft, btnRight, btnShare;

    private String goodsAddr;//商品地址
    private String userAddr;//用户地址
    private String agentid;

    private int curfen = 0;
    private int singleval = 0;
    private float sumWeight = 0;
    private float shineRatio = 0;
    private float commRatio = 0;
    private float goodsPrice = 0;

    private float rengounum = 0;
    private float fenhongnum = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_detail);
        userAddr = Web3jManager.getAccount(1);
        goodsAddr = Web3jManager.getContractList().get(0);
        rengounum = getIntent().getIntExtra("rengounum",0);
        fenhongnum = getIntent().getFloatExtra("fenhongnum",0.0f);
        initView();
        reqGeth();
    }

    private void initView() {
        topTitle = findViewById(R.id.detail_top_title);
        topValue1 = findViewById(R.id.detail_top_value1);
        topValue2 = findViewById(R.id.detail_top_value2);
        line1 = findViewById(R.id.detail_content_line1);
        line2 = findViewById(R.id.detail_content_line2);
        line3 = findViewById(R.id.detail_content_line3);
        line4 = findViewById(R.id.detail_content_line4);
        line5 = findViewById(R.id.detail_content_line5);
        line6 = findViewById(R.id.detail_content_line6);
        line7 = findViewById(R.id.detail_content_line7);
        line8 = findViewById(R.id.detail_content_line8);
        line9 = findViewById(R.id.detail_content_line9);
        btnLeft = findViewById(R.id.detail_bottom_left);
        btnRight = findViewById(R.id.detail_bottom_right);
        btnShare = findViewById(R.id.detail_top_share);

        btnShare.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
    }

    private void reqGeth(){
        Web3jManager.getGoodsInfo(goodsAddr, userAddr, new Web3jManager.ReqGetGoodsInfoListener() {

            @Override
            public void onSuccess(String _addr, String _name, int _price, int _commRatio, int _shineRatio, int _sumAgenter, int _allweight, int _allShine, int _allComm, int _singleval) {
                sumWeight = _allweight;
                shineRatio = _shineRatio;
                commRatio = _commRatio;
                goodsPrice = _price;

                topValue1.setText(String.format(Locale.getDefault(), "%.02f", rengounum));
                topValue2.setText(String.format(Locale.getDefault(), "%.02f", fenhongnum));
                line1.setText(_addr);
                line2.setText(_shineRatio + "%");
                line3.setText(_price * _shineRatio / 100.0 + "");
                line4.setText(_commRatio + "%");
                line5.setText(_price * _commRatio / 100.0 + "");
                line6.setText(_sumAgenter + "");
                line7.setText(_singleval + "");
                line8.setText( _allweight == 0 ? "100%" : ( 100.0 * rengounum / _allweight + "%"));
                line9.setText(String.format(Locale.getDefault(), "%.02f",
                        _price * _shineRatio / 100.0 * (rengounum / _allweight)));

                curfen = 1;
                singleval = _singleval;
//                rengounum.setText(1 + "");
//                rengousum.setText(_singleval + "");
            }

            @Override
            public void onError(Exception _e) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_bottom_left:   //撤资

                break;
            case R.id.detail_bottom_right:  //转让

                break;
            case R.id.detail_top_share:  //分享
                Intent i = new Intent(this, ShareActivity.class);
                i.putExtra("userAddr", userAddr);
                i.putExtra("goodsAddress", goodsAddr);
                i.putExtra("agentid", agentid);
                startActivity(i);
                break;
        }
    }

}
