package com.web3jtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.web3jtest.web3.Web3jManager;

/**
 * 认购页面
 */
public class SubscriptionActivity extends BaseActivity implements View.OnClickListener {

    TextView today;//申请日期
    TextView allweight;//全部权重
    TextView allfenhong;//全部分红
    TextView allyongjin;//全部佣金
    ImageView goodsinfo;// 商品图片
    TextView goodsno;// 合约地址
    TextView fenhongzhanbi;// 分红占比
    TextView danbifenhong;// 单笔分红
    TextView yongjinzhanbi;//佣金占比
    TextView curyongjin;//当前佣金
    TextView curAgentSum;//认购人数量
    TextView rengouvalue;//单份认购金额
    TextView rengouzhanbi;//认购额占比
    TextView rengoufenhong;//认购后每笔分红
    Button down;//减
    Button up;//加
    EditText rengounum;//当前认购份数
    TextView rengousum;//认购总额
    TextView confirm;//认购

    String goodsAddr;//商品地址
    String userAddr;//用户地址

    int curfen = 0;
    int singleval = 0;
    float sumWeight = 0;
    float shineRatio = 0;
    float commRatio = 0;
    float goodsPrice = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        init();

        goodsAddr = getIntent().getStringExtra("goodsAddr");
        userAddr = getIntent().getStringExtra("userAddr");


        reqGeth();
    }

    private void init(){
        today = (TextView) findViewById(R.id.today);
        allweight = (TextView) findViewById(R.id.allweight);
        allfenhong = (TextView)findViewById(R.id.allfenhong);
        allyongjin = (TextView)findViewById(R.id.allyongjin);
        goodsinfo = (ImageView) findViewById(R.id.goodsinfo);
        goodsno = (TextView)findViewById(R.id.goodsno);
        fenhongzhanbi = (TextView)findViewById(R.id.fenhongzhanbi);
        danbifenhong = (TextView)findViewById(R.id.danbifenhong);
        yongjinzhanbi = (TextView)findViewById(R.id.yongjinzhanbi);
        curyongjin = (TextView)findViewById(R.id.curyongjin);
        curAgentSum = (TextView)findViewById(R.id.rengourensum);
        rengouvalue = (TextView)findViewById(R.id.rengouvalue);
        rengouzhanbi = (TextView)findViewById(R.id.rengouzhanbi);
        rengoufenhong = (TextView)findViewById(R.id.rengoufenhong);
        rengousum = (TextView)findViewById(R.id.rengousum);
        confirm = (TextView)findViewById(R.id.confirm);
        down = (Button)findViewById(R.id.down);
        up = (Button)findViewById(R.id.up);
        rengounum = (EditText) findViewById(R.id.rengounum);

        down.setOnClickListener(this);
        up.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    private void reqGeth(){
        Web3jManager.getGoodsInfo(goodsAddr, userAddr, new Web3jManager.ReqGetGoodsInfoListener() {

            @Override
            public void onSuccess(String _addr, String _name, int _price, int _commRatio,
                                  int _shineRatio, int _sumAgenter, int _allweight, int _allShine,
                                  int _allComm, int _singleval) {
                sumWeight = _allweight;
                shineRatio = _shineRatio;
                commRatio = _commRatio;
                goodsPrice = _price;

                goodsno.setText(_addr);
                allweight.setText(_allweight + "");
                allfenhong.setText(_allShine + "");
                allyongjin.setText(_allComm + "");
                fenhongzhanbi.setText(_shineRatio + "%");
                yongjinzhanbi.setText(_commRatio + "%");
                curAgentSum.setText(_sumAgenter + "");
                rengouvalue.setText(_singleval + "");

                danbifenhong.setText(_price * _shineRatio / 100.0 + "");
                curyongjin.setText(_price * _commRatio / 100.0 + "");

                rengouzhanbi.setText( _allweight == 0 ? "100%" : ( 100.0 * _singleval / (_allweight + _singleval) + "%"));
                rengoufenhong.setText(_price * _shineRatio / 100.0 * (_singleval / (_allweight + _singleval)) + "");

                curfen = 1;
                singleval = _singleval;
                rengounum.setText(1 + "");
                rengousum.setText(_singleval + "");
            }

            @Override
            public void onError(Exception _e) {

            }
        });
    }

    private void noticeInfoChange(){
        rengouzhanbi.setText(  100.0 * singleval / (sumWeight + singleval) + "%");
        float usercurval = curfen * singleval;
        rengoufenhong.setText(goodsPrice * shineRatio / 100.0 * (usercurval / (sumWeight + usercurval)) + "");

        rengounum.setText(curfen);
        rengousum.setText(usercurval + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.down:{
                if (curfen > 1){
                    --curfen;
                    noticeInfoChange();
                }
                break;
            }
            case R.id.up:{
                ++curfen;
                noticeInfoChange();
                break;
            }
            case R.id.confirm:{
                showLoading("认购合约中。。。", false);
                Web3jManager.createAgent(goodsAddr, userAddr, "123", (singleval * curfen), new Web3jManager.ReqSignUpListener() {
                    @Override
                    public void onSuccess(String _goodAddr, String _buyer, int _agentCount) {
                        finish();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "认购成功！", Toast.LENGTH_LONG).show();
                            }
                        });
                        endLoading();
                    }

                    @Override
                    public void onError(Exception _e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "认购失败！", Toast.LENGTH_LONG).show();
                            }
                        });
                        endLoading();
                    }
                });

                break;
            }
        }
    }
}
