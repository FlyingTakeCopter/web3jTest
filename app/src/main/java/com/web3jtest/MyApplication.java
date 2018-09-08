package com.web3jtest;

import android.app.Application;

import com.web3jtest.web3.Web3jManager;

/**
 * @author xieyue5
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Web3jManager.init(this);
    }
}
