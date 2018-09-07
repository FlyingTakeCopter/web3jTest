package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @author zhaoyu23
 * @date 2018/9/7
 */
public class UserCenterActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        layout = findViewById(R.id.da_ren_rl);
        layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.da_ren_rl:
                startActivity(new Intent(this, MySubscriptionActivity.class));
                break;
            default:
                break;
        }
    }
}
