package com.baizhi.cmfz.entity;

import java.util.List;

/**
 * @description 对富文本框的图片返回处理
 * @author wch
 * @create 2018-07-09 0:32
 */
public class GetTextForResult {
    private Integer errno;
    private List<String> data;

    public GetTextForResult() {
    }

    public GetTextForResult(Integer errno, List<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetTextForResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }
}
