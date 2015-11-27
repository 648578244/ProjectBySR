package com.example.l.projectbysr.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;

/**
 * Created by l on 2015/11/17.
 */
public class MyUtils {
    private static Toast mToast;
    public static void showToast( Context context, String msg) {
        if (null != mToast) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    /**
     *
     * @param str 原始字符串
     * @param color 颜色
     * @param size 字体大小
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */
    public static SpannableStringBuilder  createNewString(String str,int color,int size,int start,int end){
        SpannableStringBuilder ss = new SpannableStringBuilder(str);
        if (color != 0){
            ss.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (size != 0){
           ss.setSpan(new AbsoluteSizeSpan(size), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return ss;
    }
}
