package com.example.l.projectbysr.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ldp on 2015/8/7.
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }

    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }
    public ViewHolder setText(int viewId,SpannableStringBuilder text){
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    public ViewHolder setImageResource(int viewId,int resId){
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
    public ViewHolder setImageURL(int viewId,String url){
        ImageView view = getView(viewId);

        return this;
    }
    public ViewHolder setInvisible(int viewId,int isVisible){
        View view = getView(viewId);
        view.setVisibility(isVisible);
        return this;
    }

    public ViewHolder setTextColor(int viewId,int color){
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    public LinearLayout getLinearLayout(int viewId){
        LinearLayout view = getView(viewId);
        return  view;
    }
    public void setButtonOnClick(int viewId, View.OnClickListener l){
      Button btn =  getView(viewId);
        btn.setOnClickListener(l);
    }
}
