package com.web3jtest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.web3jtest.widget.CustomDialogFragment;

/**
 * @author xieyue5
 */
public class BaseActivity extends AppCompatActivity {
    protected CustomDialogFragment dialog = new CustomDialogFragment();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void setDialogView() {

    }

    protected boolean showProgress() {
        dialog.show(getSupportFragmentManager(), "Loading");
        return true;
    }

    protected boolean dismissProgress() {
        dialog.dismissAllowingStateLoss();
        return true;
    }
}
