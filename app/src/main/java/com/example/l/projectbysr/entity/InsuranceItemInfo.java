package com.example.l.projectbysr.entity;

/**
 * Created by l on 2015/11/17.
 */

public class InsuranceItemInfo {
    private String strRenshou;//中韩人寿
    private String strType;//状态
    private String strBaodanhao;//保单号
    private String strToubaoren;//投保人
    private String strBaofei;//保费
    private String strJiangli;//奖励

    public String getStrRenshou() {
        return strRenshou;
    }

    public void setStrRenshou(String strRenshou) {
        this.strRenshou = strRenshou;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public String getStrBaodanhao() {
        return strBaodanhao;
    }

    public void setStrBaodanhao(String strBaodanhao) {
        this.strBaodanhao = "保单号:  "+strBaodanhao;
    }

    public String getStrToubaoren() {
        return strToubaoren;
    }

    public void setStrToubaoren(String strToubaoren) {
        this.strToubaoren = "投保人:  "+strToubaoren;
    }

    public String getStrBaofei() {
        return strBaofei;
    }

    public void setStrBaofei(String strBaofei) {
        this.strBaofei ="保    费:  "+strBaofei;
    }

    public String getStrJiangli() {
        return strJiangli;
    }

    public void setStrJiangli(String strJiangli) {
        this.strJiangli ="奖    励:  "+strJiangli;
    }
}


