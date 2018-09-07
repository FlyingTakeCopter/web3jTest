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
 * @date 2018/9/1
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
        showProgress();
        Web3jManager.deploy(Web3jManager.getAccount(0), Web3jManager.getPassword(), "黑鲨手机", 3199,
                20, 20, 10, new Web3jManager.ReqDepolyListener(){

                    @Override
                    public void onSuccess(String _goodsOwner, String _contractAddr) {
                        dismissProgress();
                        Intent intent = new Intent(OrderActivity.this, SubscriptionActivity.class);
                        intent.putExtra("goodsAddr", _contractAddr);
                        intent.putExtra("userAddr", _goodsOwner);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(final Exception _e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dismissProgress();
                                Toast.makeText(OrderActivity.this, _e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
    }
}
