package com.web3jtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * 认购页面
 */
public class SubscriptionDetailActivity extends AppCompatActivity {
    private TextView topTitle, topValue1, topValue2, topValue3;
    private TextView line1, line2, line3, line4, line5, line6, line7, line8, line9;
    private TextView btnLeft, btnRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_detail);
        initView();
    }

    private void initView() {
        topTitle = findViewById(R.id.detail_top_title);
        topValue1 = findViewById(R.id.detail_top_value1);
        topValue2 = findViewById(R.id.detail_top_value2);
        topValue3 = findViewById(R.id.detail_top_value3);
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
    }


}
