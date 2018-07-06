package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.Map;

public interface MasterService {
    public Map<String,Object> queryAllMasters(Integer nowPage, Integer pageSize);

    public Master queryMasterById(String masterId);

    public Integer addMaster(Master master);

    public Integer removeMaster(String masterId);

    public Integer modifyMaster(Master master);

    public Map<String,Object> querySomeMaster(Integer nowPage, Integer pageSize, String name, String value);
}
