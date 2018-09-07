package com.web3jtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.web3jtest.web3.Web3jManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyu23
 * @date 2018/9/7
 */
public class UserCenterActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout layout;
    Spinner mAccountSwitch;
    TextView mNicknameTv;
    private ArrayAdapter<String> adapter;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        layout = findViewById(R.id.da_ren_rl);
        layout.setOnClickListener(this);
        mNicknameTv = findViewById(R.id.nickname_tv);
        mAccountSwitch = findViewById(R.id.account_switch);
        list = new ArrayList<>();
        list.add("用户编号111111111");
        list.add("用户编号222222222");
        list.add("用户编号333333333");

        /*新建适配器*/
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);

        /*adapter设置一个下拉列表样式，参数为系统子布局*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        /*spDown加载适配器*/
        mAccountSwitch.setAdapter(adapter);

        /*soDown的监听器*/
        mAccountSwitch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String userName = adapter.getItem(position);   //获取选中的那一项
                mNicknameTv.setText(userName);
                Web3jManager.setCurUserAddr(userName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
