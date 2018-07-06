package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService ms;

    @RequestMapping("/searchAll")
    @ResponseBody
    public Map<String , Object> searchAll(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        return ms.queryAllMasters(nowPage,pageSize);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Integer create(@RequestParam("masterName")String masterName,@RequestParam("masterPhoto")String masterPhoto,@RequestParam("masterSummary")String masterSummary){
        Master master = new Master();
        master.setMasterName(masterName);
        master.setMasterPhoto(masterPhoto);
        master.setMasterSummary(masterSummary);

        return ms.addMaster(master);
    }

    @RequestMapping("/drop")
    @ResponseBody
    public Integer drop(@RequestParam("masterId")String masterId){
        return ms.removeMaster(masterId);
    }

    @RequestMapping("/change")
    @ResponseBody
    public Integer change(@RequestParam("masterId")String masterId,@RequestParam("masterName")String masterName,@RequestParam("masterPhoto")String masterPhoto,@RequestParam("masterSummary")String masterSummary){
        Master master = ms.queryMasterById(masterId);
        if (master!=null){
            master.setMasterName(masterName);
            master.setMasterPhoto(masterPhoto);
            master.setMasterSummary(masterSummary);
            return ms.modifyMaster(master);
        }
        throw new RuntimeException("没有该上师");
    }

    @RequestMapping("/searchSome")
    @ResponseBody
    public Map<String , Object> searchSome(@RequestParam("name")String name,@RequestParam("value")String value,@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize ){
        System.out.println(nowPage+"---"+pageSize);
        System.out.println(name+"----"+value);
        return ms.querySomeMaster(nowPage,pageSize,name,value);
    }
}
