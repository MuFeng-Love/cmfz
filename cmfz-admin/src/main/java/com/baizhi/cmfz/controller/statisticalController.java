package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Analyze;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistics")
public class statisticalController {

    @RequestMapping("/distribution_man")
    @ResponseBody
    public List<Analyze> distributionMan(){
        List<Analyze> analyzes = new ArrayList<Analyze>();
        analyzes.add(new Analyze("北京","100"));
        analyzes.add(new Analyze("天津","200"));
        analyzes.add(new Analyze("上海","300"));
        analyzes.add(new Analyze("河南","400"));
        analyzes.add(new Analyze("新疆","500"));
        analyzes.add(new Analyze("西藏","600"));
        return analyzes;
    }

    @RequestMapping("/distribution_woman")
    @ResponseBody
    public List<Analyze> distributionWoman(){
        List<Analyze> analyzes = new ArrayList<Analyze>();
        analyzes.add(new Analyze("北京","50"));
        analyzes.add(new Analyze("天津","50"));
        analyzes.add(new Analyze("上海","100"));
        analyzes.add(new Analyze("河南","200"));
        analyzes.add(new Analyze("新疆","100"));
        analyzes.add(new Analyze("西藏","100"));
        return analyzes;
    }

    @RequestMapping("/activeUser")
    @ResponseBody
    public Map<String ,Object> getActiveUser(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("intervals",new String[]{"7天","15天","30天","半年","一年"});
        map.put("counts",new int[]{20,5,10,30,40});
        return map;
    }

}
