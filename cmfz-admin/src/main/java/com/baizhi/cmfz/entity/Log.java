package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.UUID;

public class Log {
    private String logId;
    private String user;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date time;
    private String resource;
    private String action;
    private String message;
    private String result;

    public Log() {
        this.logId = UUID.randomUUID().toString().replace("-","");
    }

    public Log(String logId, String user, Date time, String resource, String action, String message, String result) {
        this.user = user;
        this.time = time;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }

    public String getLogId() {
        return logId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
