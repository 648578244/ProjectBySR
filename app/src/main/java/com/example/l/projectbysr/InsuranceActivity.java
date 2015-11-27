package com.example.l.projectbysr;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.l.projectbysr.adapter.ListLocationAdapter;
import com.example.l.projectbysr.entity.InsuranceDivisionInfo;
import com.example.l.projectbysr.utils.MatchSearch;
import com.example.l.projectbysr.view.MyLetterListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by l on 2015/11/26.
 */
public class InsuranceActivity extends Activity implements TextWatcher {
    private WindowManager mWindowManager;
    private MyLetterListView letterListView;
    private Handler mHander;
    private TextView overlay;
    private ArrayList<InsuranceDivisionInfo> datas;
    private OverlayThread overlayThread;
    private ListView mListView;
    private ListLocationAdapter mAdapter;
    private TextView tvJieritixing, tvJieriType;
    public int[] bgImage = {R.drawable.green_ring,R.drawable.pink_ring,R.drawable.red_ring,R.drawable.yellow_ring};
    private EditText etSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_city);
        initData();
        initView();
        initOverlay();
    }

    // 初始化汉语拼音首字母弹出提示框
    private void initOverlay() {
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(this);
        overlay = (TextView) inflater.inflate(R.layout.overly, null);
        overlay.setVisibility(View.INVISIBLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        mWindowManager.addView(overlay, lp);
    }

    private void initView() {

        mListView = (ListView) findViewById(R.id.list_view_city);
        tvJieritixing = (TextView) findViewById(R.id.tv_jieritixing);//节日提醒
        tvJieriType = (TextView) findViewById(R.id.tv_jieri_type);
        etSearch = (EditText) findViewById(R.id.et_search);
        createJieritixingView();
        mListView.setAdapter(mAdapter);
        etSearch.addTextChangedListener(this);
        letterListView = (MyLetterListView) findViewById(R.id.MyLetterListView01);
        letterListView
                .setOnTouchingLetterChangedListener(new MyLetterListView.OnTouchingLetterChangedListener() {

                    @Override
                    public void onTouchingLetterChanged(String s) {
                        if (mAdapter.getAlphaIndexer().get(s) != null) {
                            int position = mAdapter.getAlphaIndexer().get(s);
                            mListView.setSelection(position);
                            overlay.setText(mAdapter.getSections()[position]);
                            overlay.setVisibility(View.VISIBLE);
                            mHander.removeCallbacks(overlayThread);
                            // 延迟一秒后执行，让overlay为不可见
                            mHander.postDelayed(overlayThread, 1500);
                        }

                    }
                });

        mHander = new Handler();
        overlayThread = new OverlayThread();
    }

    private void createJieritixingView() {
        String str = "节日提醒";
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        ssb.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置粗体斜体
        tvJieritixing.setText(ssb);

        String str1 = "生日";
        SpannableStringBuilder ssb1 = new SpannableStringBuilder(str1);
        ssb1.setSpan(new StyleSpan(Typeface.BOLD), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置粗体
        tvJieriType.setText(ssb1);
    }

    private void initData() {
        ///////////////////////////////////
        datas = new ArrayList<InsuranceDivisionInfo>();
        InsuranceDivisionInfo info1 = new InsuranceDivisionInfo();
        InsuranceDivisionInfo info2 = new InsuranceDivisionInfo();
        InsuranceDivisionInfo info3 = new InsuranceDivisionInfo();
        InsuranceDivisionInfo info4 = new InsuranceDivisionInfo();
        InsuranceDivisionInfo info5 = new InsuranceDivisionInfo();
        InsuranceDivisionInfo info6 = new InsuranceDivisionInfo();

        info1.setName("啊aaa");
        info2.setName("孙bbbb");
        info3.setName("哈ccc");
        info4.setName("张ddd");
        info5.setName("孙睿");
        info6.setName("李eeee");

        info1.setPhoneNum("13634253083");
        info2.setPhoneNum("13634253084");
        info3.setPhoneNum("13634253085");
        info4.setPhoneNum("13634253086");
        info5.setPhoneNum("13634253087");
        info6.setPhoneNum("13634253088");


        datas.add(info1);
        datas.add(info2);
        datas.add(info3);
        datas.add(info4);
        datas.add(info5);
        datas.add(info6);

        ////////////////////////////////////上面这些数据是从接口获取的。
        lists = new ArrayList<InsuranceDivisionInfo>();
        for (InsuranceDivisionInfo info : datas) {//取首字拼音
            info.setFirstPy(MatchSearch.getFirstCode(info.getName()));
            info.setImageColor(bgImage[getSuiji()]);
            lists.add(info);
        }
        DataSupport.saveAll(lists);//不要数据而定时候把这个注释掉 测试用的
        lists = DataSupport.select("firstPy", "phoneNum", "name","imageColor").order("firstPy asc").find(InsuranceDivisionInfo.class);
        mAdapter = new ListLocationAdapter(this);
        mAdapter.setDatas(lists);
        mAdapter.notifyDataSetChanged();
    }
    private int getSuiji(){
        return new Random().nextInt(4);
    }
    List<InsuranceDivisionInfo> lists;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        lists = DataSupport.select("firstPy", "name", "phoneNum","imageColor").where("name like ? OR phoneNum like ?", "%" + s + "%", "%" + s + "%").order("firstPy asc").find(InsuranceDivisionInfo.class);
        mAdapter.setDatas(lists);
        mAdapter.notifyDataSetChanged();
    }

    // 设置overlay不可见
    private class OverlayThread implements Runnable {

        @Override
        public void run() {
            overlay.setVisibility(View.GONE);
        }

    }
}
