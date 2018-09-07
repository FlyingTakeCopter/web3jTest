package com.web3jtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.web3jtest.web3.Web3jManager;

/**
 * @author zhaoyu23
 * @date 2018/9/7
 */
public class GoodsRegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText mGoodsPrice, mShineCoefficient, mCommissionCoefficient, mOnePrice;
    private TextView confirm;
    private String userAddr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        userAddr = Web3jManager.getAccount(0);
    }

    private void initView() {
        mGoodsPrice = findViewById(R.id.goods_price1);
        mShineCoefficient = findViewById(R.id.shine_coefficient);
        mCommissionCoefficient = findViewById(R.id.commission_coefficient);
        mOnePrice = findViewById(R.id.one_price);
        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showLoading("合约注册中...",false);
        Web3jManager.deploy(userAddr, Web3jManager.getPassword(),
                "黑鲨手机",
                Integer.parseInt(mGoodsPrice.getText().toString()),
                Integer.parseInt(mShineCoefficient.getText().toString()),
                Integer.parseInt(mCommissionCoefficient.getText().toString()),
                Integer.parseInt(mOnePrice.getText().toString()),
                new Web3jManager.ReqDepolyListener() {

                    @Override
                    public void onSuccess(String _goodsOwner, String _contractAddr) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"部署成功", Toast.LENGTH_LONG).show();
                            }
                        });
                        endLoading();
                        finish();
                    }

                    @Override
                    public void onError(Exception _e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"部署失败", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
    }
}
