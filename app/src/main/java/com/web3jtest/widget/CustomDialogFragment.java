package com.web3jtest.widget;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author xieyue5
 */
public class CustomDialogFragment extends DialogFragment {

    @LayoutRes
    private int layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layout, container);
    }

    public void setFragmentView(@LayoutRes int res) {
        this.layout = res;
    }
}
