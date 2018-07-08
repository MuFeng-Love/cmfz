package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao md;

    @Override
    public Map<String, Object> queryAllMasters(Integer nowPage, Integer pageSize) {
        Integer rowsNumber = (nowPage-1)*pageSize;
        List<Master> masters = md.findAllMasters(rowsNumber,pageSize);

        int count = md.count();

        Map<String,Object> map =new HashMap<String, Object>();

        map.put("total",count);
        map.put("rows",masters);

        return map;
    }

    @Override
    public Map<String, Object> querySomeMaster(Integer nowPage, Integer pageSize, String name, String value) {
        System.out.println("service"+"---"+name+"---"+value+"---"+nowPage+"---"+pageSize);
        value = "%"+value+"%";
        Integer rowsNumber = (nowPage-1)*pageSize;
        List<Master> masters =md.findSomeMasters(value,name,rowsNumber,pageSize);
        System.out.println(masters);
        int count = md.count1(value,name);
        System.out.println(count);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("total",count);
        map.put("rows",masters);
        return map;
    }

    @Override
    public Master queryMasterById(String masterId) {
        Master master = new Master();
        master = md.findMasterById(masterId);
        if (master!=null){
            return master;
        }
        return null;
    }

    @Override
    public Integer addMasters(List<Master> masters) {
        Integer result = null;
        result = md.insertMasters(masters);
        if (result>0){
            return result;
        }
        return null;
    }

    @Override
    public Integer addMaster(Master master) {
        System.out.println("----ServiceImpl---"+master);
        Integer result = null;
        result = md.insertMaster(master);
        if (result>0){
            return result;
        }
        return null;
    }

    @Override
    public Integer removeMaster(String masterId) {
        Integer result = null;
        result = md.deleteMaster(masterId);
        if (result>0){
            return result;
        }
        return null;
    }

    @Override
    public Integer modifyMaster(Master master) {
        Integer result = null;
        result = md.updateMaster(master);
        if (result>0){
            return result;
        }
        return null;
    }

}
