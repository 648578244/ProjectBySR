package com.example.l.projectbysr.entity;

import com.example.l.projectbysr.R;

import org.litepal.crud.DataSupport;

/**
 * Created by l on 2015/11/26.
 */
public class InsuranceDivisionInfo extends DataSupport {

    private String name;
    private String phoneNum;
    private String firstPy;
    private int imageColor;

    public int getImageColor() {
        return imageColor;
    }

    public void setImageColor(int imageColor) {
        this.imageColor = imageColor;
    }

    public String getFirstPy() {
        return firstPy;
    }

    public void setFirstPy(String firstPy) {
        this.firstPy = firstPy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
