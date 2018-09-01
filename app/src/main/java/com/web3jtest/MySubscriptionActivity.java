package com.web3jtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.web3jtest.bean.GoodsBean;


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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        initView();
    }

    private void initView() {
        mGoodsListView = findViewById(R.id.goods_list);
        for (int i=0; i<5; i++) {
            mGoodsBeanList.add(goodsBean);
        }
        mGoodsAdapter = new GoodsAdapter(this, mGoodsBeanList);
        mGoodsListView.setAdapter(mGoodsAdapter);
    }

    @Override
    public void onClick(View v) {

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
                viewHolder.mGoodsAddress = (TextView) convertView.findViewById(R.id.goods_address);
                viewHolder.mGoodsPrice = (TextView) convertView.findViewById(R.id.goods_price);
                viewHolder.mGoodsCoefficient = (TextView) convertView.findViewById(R.id.goods_coefficient);
                viewHolder.mGoodsCommission = (TextView) convertView.findViewById(R.id.goods_commission);
                viewHolder.mGoodsSubscribePeopleNum = (TextView) convertView.findViewById(R.id.goods_subscribe_people_num);
                viewHolder.mGoodsSubscribePrice = (TextView) convertView.findViewById(R.id.goods_subscribe_price);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            return convertView;
        }
    }

    private class ViewHolder {
        TextView mGoodsName;
        TextView mGoodsAddress;
        TextView mGoodsPrice;
        TextView mGoodsCoefficient;
        TextView mGoodsCommission;
        TextView mGoodsSubscribePeopleNum;
        TextView mGoodsSubscribePrice;
    }
}
