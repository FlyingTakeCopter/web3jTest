package com.web3jtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.web3jtest.bean.GoodsBean;
import com.web3jtest.web3.Web3jManager;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyu23
 */
public class MySubscriptionActivity extends BaseActivity implements View.OnClickListener, ListView.OnItemClickListener {

    private ListView mGoodsListView;
    private GoodsAdapter mGoodsAdapter;
    private List<GoodsBean> mGoodsBeanList = new ArrayList<>();
    private GoodsBean goodsBean = new GoodsBean();
    private ImageView mCancelBtn;
    private String goodsAddress;
    private String userAddr;
    private TextView zongjine;
    private TextView zongfenhong;
    int allmoney;
    int allfenhong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_list);
        initView();

        goodsAddress = Web3jManager.getContractList().get(0);
        userAddr = Web3jManager.getAccount(1);

        requestAgentInfo();
    }

    private void initView() {
        mCancelBtn = findViewById(R.id.cancel_btn);
        mGoodsListView = findViewById(R.id.goods_list);
        mGoodsListView.setOnItemClickListener(this);
        mCancelBtn.setOnClickListener(this);
        zongjine = findViewById(R.id.zongjine);
        zongfenhong = findViewById(R.id.zongshouyi);
    }

    private void requestAgentInfo(){

        Web3jManager.getGoodsInfo(goodsAddress, userAddr, new Web3jManager.ReqGetGoodsInfoListener(){

            @Override
            public void onSuccess(String _addr, final String _name,
                                  final int _price, final int _commRatio, final int _shineRatio, final int _sumAgenter,
                                  final int _allweight, final int _allShine, final int _allComm, final int _singleval) {

                Web3jManager.getOwnerAgentCount(goodsAddress, userAddr, new Web3jManager.ReqOwnerAgentCountListener(){
                    @Override
                    public void onSuccess(String _addr, int _count) {
                        for (int i = 0; i < _count; i++){
                            Web3jManager.getAgentInfoByIdx(goodsAddress, userAddr, i, new Web3jManager.ReqAgentInfoByIdxListener() {
                                @Override
                                public void onSuccess(String _addr, int _agentid, String _owner,
                                                      final int _weight, int _createtime, final int _profit) {
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
                                    goodsBean.set_agentid(_agentid);
                                    goodsBean.set_owner(_owner);
                                    goodsBean.set_weight(_weight);
                                    goodsBean.set_createtime(_createtime);
                                    goodsBean.set_profit(_profit);
                                    mGoodsBeanList.add(goodsBean);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            mGoodsAdapter.notifyDataSetChanged();
                                            allmoney += _weight;
                                            allfenhong += _profit;
                                            zongjine.setText(allmoney + "");
                                            zongfenhong.setText(allfenhong + "");
                                        }
                                    });
                                }

                                @Override
                                public void onError(Exception _e) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Exception _e) {

                    }
                });
            }

            @Override
            public void onError(Exception _e) {

            }
        });
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, SubscriptionDetailActivity.class);
        i.putExtra("userAddr", userAddr);
        i.putExtra("goodsAddress", goodsAddress);
        i.putExtra("agentid",  goodsBean.get_agentid());
        startActivity(i);
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
                viewHolder.agentWeight = (TextView) convertView.findViewById(R.id.agent_benjin);
                viewHolder.agentProfit = (TextView) convertView.findViewById(R.id.agent_shouyi);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.mGoodsName.setText(goodsBeanList.get(position).getName() + "");
            viewHolder.mGoodsPrice.setText(goodsBeanList.get(position).getPrice() + "元");
            viewHolder.mGoodsfenhong.setText(goodsBeanList.get(position).getShineRatio() + "%");
            viewHolder.mGoodsyongjin.setText(goodsBeanList.get(position).getCommRatio() + "%");
            int userweight = goodsBeanList.get(position).get_weight();
            int allweight = goodsBeanList.get(position).getAllweight();
            viewHolder.mGoodsallweight.setText(allweight + "");
            viewHolder.mrengounum.setText((100.0 * userweight / allweight) + "%");
            viewHolder.agentWeight.setText(userweight + "元");
            viewHolder.agentProfit.setText(goodsBeanList.get(position).get_profit() + "");



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
        TextView agentWeight;
        TextView agentProfit;
    }
}
