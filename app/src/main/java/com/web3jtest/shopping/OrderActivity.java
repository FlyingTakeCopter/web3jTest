package com.web3jtest.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.web3jtest.R;
import com.web3jtest.SubscriptionActivity;
import com.web3jtest.base.BaseActivity;
import com.web3jtest.web3.Web3jManager;

/**
 * @author xieyue5
 */
public class OrderActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        findViewById(R.id.go).setOnClickListener(this);
        dialog.setFragmentView(R.layout.fragment_dialog);
        dialog.setCancelable(false);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, SubscriptionActivity.class));
    }
}
