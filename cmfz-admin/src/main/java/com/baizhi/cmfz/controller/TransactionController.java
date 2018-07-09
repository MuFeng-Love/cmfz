package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/log")
@Controller
public class TransactionController {

    @Autowired
    private TransactionService ts;

    @RequestMapping("/searchAll")
    @ResponseBody
    public Map<String , Object> searchAll(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        return ts.queryAll(nowPage,pageSize);
    }
}
