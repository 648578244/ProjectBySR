package com.example.l.projectbysr.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

import com.example.l.projectbysr.R;
import com.example.l.projectbysr.entity.InsuranceItemInfo;
import com.example.l.projectbysr.utils.MyUtils;

/**
 * Created by l on 2015/11/17.
 */
public class ContentListAdapter extends CommonAdatper<InsuranceItemInfo>{
    private Resources mResources;
    public ContentListAdapter(Context context, int layoutId) {
        super(context, layoutId);
        mResources =  context.getResources();
    }

    @Override
    protected void convert(ViewHolder holder, InsuranceItemInfo info) {
        int color=0;
        if (info.getStrType().equals("已结算")){
            color = mResources.getColor(R.color.green);
        }else{
            color = mResources.getColor(R.color.orange);
        }
        holder.setText(R.id.tv_zhonghanrenshou, MyUtils.createNewString(info.getStrRenshou(),mResources.getColor(R.color.dark_gray) , mResources.getDimensionPixelSize(R.dimen.size_20), 7, info.getStrRenshou().length()))
                .setText(R.id.tv_insurance_type, MyUtils.createNewString(info.getStrType(),color, 0, 0, info.getStrType().length()))
                .setText(R.id.tv_baodanhao, MyUtils.createNewString(info.getStrBaodanhao(), mResources.getColor(R.color.orange) ,0, 4, info.getStrBaodanhao().length()))
                .setText(R.id.tv_toubaoren, MyUtils.createNewString(info.getStrToubaoren(),mResources.getColor(R.color.light_gray) ,0,0,info.getStrToubaoren().length()))
                .setText(R.id.tv_baofei, MyUtils.createNewString(info.getStrBaofei(),mResources.getColor(R.color.light_gray) ,0, 0, info.getStrBaofei().length()))
                .setText(R.id.tv_jiangli, MyUtils.createNewString(info.getStrJiangli(), mResources.getColor(R.color.green) , 0, 8, info.getStrJiangli().length() - 1));
    }
}
