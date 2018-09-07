package com.web3jtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.web3jtest.bean.GoodsBean;
import com.web3jtest.web3.Web3jManager;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyu23
 * @date 2018/9/1
 */
public class MySubscriptionActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mGoodsListView;
    private GoodsAdapter mGoodsAdapter;
    private List<GoodsBean> mGoodsBeanList = new ArrayList<>();
    private GoodsBean goodsBean;
    private ImageView mCancelBtn;
    private List<String> mGoodsAddress;
    private String userAddr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_list);
        initView();

        mGoodsAddress = Web3jManager.getContractList();
        userAddr = getIntent().getStringExtra("userAddress");

        requestAgentInfo();
    }

    private void initView() {
        mCancelBtn = findViewById(R.id.cancel_btn);
        mGoodsListView = findViewById(R.id.goods_list);
        mCancelBtn.setOnClickListener(this);
    }

    private void requestAgentInfo(){

        for (String s : mGoodsAddress){
            Web3jManager.getGoodsInfo(s, userAddr, new Web3jManager.ReqGetGoodsInfoListener(){

                @Override
                public void onSuccess(String _addr, String _name,
                                      int _price, int _commRatio, int _shineRatio, int _sumAgenter,
                                      int _allweight, int _allShine, int _allComm, int _singleval) {
                    goodsBean.setAddr(_addr);
                    goodsBean.setName(_name);
                    goodsBean.setPrice(_price);
                    goodsBean.setCommRatio(_commRatio);
                    goodsBean.setShineRatio(_shineRatio);
                    goodsBean.setSumAgenter(_sumAgenter);
                    goodsBean.setAllweight(_allweight);
                    goodsBean.setAllShine(_allShine);
                    goodsBean.setAllComm(_allComm);
                    goodsBean.setSingleval(_singleval);
                    mGoodsBeanList.add(goodsBean);
                }

                @Override
                public void onError(Exception _e) {

                }
            });
        }
        mGoodsAdapter = new GoodsAdapter(this, mGoodsBeanList);
        mGoodsListView.setAdapter(mGoodsAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_btn:
                finish();
                break;
            default:
                break;
        }
    }

    private class GoodsAdapter extends BaseAdapter {

        /**
         * 上下文
         */
        private final Context mContext;
        /**
         * 抽奖活动列表
         */
        private List<GoodsBean> goodsBeanList;

        public GoodsAdapter(Context context, List<GoodsBean> list) {
            this.mContext = context;
            this.goodsBeanList = list;
        }

        @Override
        public int getCount() {
            return goodsBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return goodsBeanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.item_goods, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.mGoodsName = (TextView) convertView.findViewById(R.id.goods_name);
                viewHolder.mGoodsPrice = (TextView) convertView.findViewById(R.id.goods_price);
                viewHolder.mGoodsfenhong = (TextView) convertView.findViewById(R.id.goods_fenhong);
                viewHolder.mGoodsyongjin = (TextView) convertView.findViewById(R.id.goods_yongjin);
                viewHolder.mGoodsallweight = (TextView) convertView.findViewById(R.id.goods_allweight);
                viewHolder.mrengounum = (TextView) convertView.findViewById(R.id.rengou_num);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.mGoodsName.setText(goodsBeanList.get(position).getName());
            viewHolder.mGoodsPrice.setText(goodsBeanList.get(position).getPrice());


            return convertView;
        }
    }

    private class ViewHolder {
        TextView mGoodsName;
        TextView mGoodsPrice;
        TextView mGoodsfenhong;
        TextView mGoodsyongjin;
        TextView mGoodsallweight;
        TextView mrengounum;
    }
}
