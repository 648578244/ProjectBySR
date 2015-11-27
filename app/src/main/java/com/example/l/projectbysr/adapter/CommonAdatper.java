package com.example.l.projectbysr.adapter;

/**
 * Created by ldp on 2015/8/7.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdatper<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas = new ArrayList<T>();
    protected LayoutInflater mInflater;
    private int mLayoutId;
    protected  int mPosotion;
    public CommonAdatper(Context context, int layoutId) {
        this.mContext = context;

        mInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
    }

    public CommonAdatper(Context context, List<T> mDatas, int layoutId) {
        this.mContext = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
    }

    public void setDatas(List<T> mDatas) {
        if (mDatas != null) {
            this.mDatas.addAll(mDatas);
        }

    }

    public List<T> getDatas() {

        return this.mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.mPosotion = position;
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mLayoutId, position);
        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    protected abstract void convert(ViewHolder holder, T t);
}
