package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.Pattern;
import java.util.UUID;

public class Master {
    @Excel(name="id")
    private String masterId;

    @Excel(name="上师法号")
    @Pattern(regexp =  "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
    private String masterName;

    private String masterPhoto;

    @Excel(name="上师简介")
    private String masterSummary;

    public Master() {
        this.masterId = UUID.randomUUID().toString().replace("-","");
    }

    public Master(String masterName, String masterPhoto, String masterSummary) {
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterSummary = masterSummary;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummary() {
        return masterSummary;
    }

    public void setMasterSummary(String masterSummary) {
        this.masterSummary = masterSummary;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummary='" + masterSummary + '\'' +
                '}';
    }
}

