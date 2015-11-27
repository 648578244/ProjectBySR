package com.example.l.projectbysr.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.l.projectbysr.R;
import com.example.l.projectbysr.entity.InsuranceDivisionInfo;

public class ListLocationAdapter extends BaseAdapter {
    private static final String TAG = "ListAdapter";
    private LayoutInflater inflater;
    private List<InsuranceDivisionInfo> list = new ArrayList<InsuranceDivisionInfo>();
    private HashMap<String, Integer> alphaIndexer;// 存放存在的汉语拼音首字母和与之对应的列表位置
    private String[] sections;// 存放存在的汉语拼音首字母
    private Context mContext;
    private Resources mRes;
    private String locationText = "";



    public ListLocationAdapter(Context context) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = context;
        mRes = context.getResources();
        alphaIndexer =  new HashMap<String, Integer>();

    }

    public void setDatas(List<InsuranceDivisionInfo> datas){
        this.list.clear();
        this.list = datas;
        alphaIndexer.clear();
        sections = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // 当前汉语拼音首字母
            String currentStr = list.get(i).getFirstPy();
            // 上一个汉语拼音首字母，如果不存在为“ ”
            String previewStr = (i - 1) >= 0 ? list.get(i - 1).getFirstPy() : " ";
            if (!previewStr.equals(currentStr)) {
                String name = list.get(i).getFirstPy();
                alphaIndexer.put(name, i);
                sections[i] = name;
            }
        }
    }
    public List<InsuranceDivisionInfo> getDatas(){
        return list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderAZ holderAZ = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_a_z, null);
            holderAZ = new ViewHolderAZ();
            holderAZ.tvName = (TextView) convertView
                    .findViewById(R.id.tv_name);
            holderAZ.alpha = (TextView) convertView
                    .findViewById(R.id.alpha);
            holderAZ.tvBgColor = (TextView) convertView.findViewById(R.id.tv_bg_color);
            convertView.setTag(holderAZ);

        } else {
            holderAZ = (ViewHolderAZ) convertView.getTag();
        }
        InsuranceDivisionInfo cv = list.get(position);
        holderAZ.tvName.setText(cv.getName());
        holderAZ.tvBgColor.setText(cv.getName().substring(0, 1));
        holderAZ.tvBgColor.setBackgroundDrawable(mRes.getDrawable(cv.getImageColor()));
        String currentStr = list.get(position).getFirstPy();
        String previewStr = (position - 1) >= 0 ? list.get(position - 1).getFirstPy() : " ";
        if (!previewStr.equals(currentStr)) {
            holderAZ.alpha.setVisibility(View.VISIBLE);
            holderAZ.alpha.setText(currentStr);
        } else {
            holderAZ.alpha.setVisibility(View.GONE);
        }
        return convertView;
    }

    private class ViewHolderAZ {
        TextView tvName;
        TextView tvBgColor;
        TextView alpha;
    }


    public HashMap<String, Integer> getAlphaIndexer() {
        return alphaIndexer;
    }

    public void setAlphaIndexer(HashMap<String, Integer> alphaIndexer) {
        this.alphaIndexer = alphaIndexer;
    }

    public String[] getSections() {
        return sections;
    }

    public void setSections(String[] sections) {
        this.sections = sections;
    }

    public void setLocationText(String str) {
        this.locationText = str;
    }

}