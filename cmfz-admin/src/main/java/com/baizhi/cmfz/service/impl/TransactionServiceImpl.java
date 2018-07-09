package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private LogDao ld;

    @Override
    public Map<String, Object> queryAll(Integer nowPage, Integer pageSize) {
        Integer rowsNumber = (nowPage-1)*pageSize;
        List<Log> logs = ld.selectAll(rowsNumber,pageSize);

        int count = ld.count();

        Map<String,Object> map =new HashMap<String, Object>();

        map.put("total",count);
        map.put("rows",logs);

        return map;
    }

}
