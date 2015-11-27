package com.example.l.projectbysr.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.l.projectbysr.R;
import com.example.l.projectbysr.adapter.ContentListAdapter;
import com.example.l.projectbysr.entity.InsuranceItemInfo;
import com.example.l.projectbysr.utils.MyUtils;
import com.example.l.projectbysr.view.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l on 2015/11/17.
 */
public class PageFragment extends Fragment implements PullToRefreshView.OnFooterRefreshListener, PullToRefreshView.OnHeaderRefreshListener {
    private int blogType = 0;
    private ContentListAdapter mAdapter;
    private PullToRefreshView mPullToRefreshView;
    private ListView mListView;

    public PageFragment(int blogType) {
        this.blogType = blogType;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_listview, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initComponent();
        super.onActivityCreated(savedInstanceState);
    }

    private void initComponent() {
        mPullToRefreshView = (PullToRefreshView) getView().findViewById(R.id.pull_refresh_content_view);
        mPullToRefreshView.setOnHeaderRefreshListener(this);
        mPullToRefreshView.setOnFooterRefreshListener(this);
        mPullToRefreshView.setEnablePullTorefresh(true);
        mPullToRefreshView.setEnablePullLoadMoreDataStatus(true);
        mListView = (ListView) getView().findViewById(R.id.lv_content_list);
        mListView.setAdapter(mAdapter);
    }

    // 初始化
    private void init() {
        mAdapter = new ContentListAdapter(getActivity(), R.layout.content_listview_item);
        mAdapter.setDatas(createDatas());
//        page = new Page();
//        page.setPageStart();
    }

    private List<InsuranceItemInfo> createDatas() {
        List<InsuranceItemInfo> ret = new ArrayList<InsuranceItemInfo>();
        InsuranceItemInfo info1 = new InsuranceItemInfo();
        info1.setStrRenshou("【中韩人寿】 保驾护航两全保险");
        info1.setStrType("待结算");
        info1.setStrBaodanhao("12314141412");
        info1.setStrToubaoren("傻逼");
        info1.setStrBaofei("1,000.00元");
        info1.setStrJiangli("1,000.00元");
        ret.add(info1);
        InsuranceItemInfo info2 = new InsuranceItemInfo();
        info2.setStrRenshou("【中韩人寿】 保驾护航两全保险");
        info2.setStrType("已结算");
        info2.setStrBaodanhao("12314141412");
        info2.setStrToubaoren("傻逼");
        info2.setStrBaofei("1,000.00元");
        info2.setStrJiangli("1,000.00元");
        ret.add(info2);
        InsuranceItemInfo info3 = new InsuranceItemInfo();
        info3.setStrRenshou("【中韩人寿】 保驾护航两全保险");
        info3.setStrType("退保");
        info3.setStrBaodanhao("12314141412");
        info3.setStrToubaoren("傻逼");
        info3.setStrBaofei("1,000.00元");
        info3.setStrJiangli("1,000.00元");
        ret.add(info3);
        return ret;
    }

    @Override
    public void onFooterRefresh(PullToRefreshView view) {
        MyUtils.showToast(this.getActivity(),"上拉加载");
        mPullToRefreshView.onFooterRefreshComplete();
    }

    @Override
    public void onHeaderRefresh(PullToRefreshView view) {
        MyUtils.showToast(this.getActivity(), "下拉刷新");
        mPullToRefreshView.onHeaderRefreshComplete();
    }
}
