package com.baizhi.cmfz.service;

import java.util.Map;

public interface TransactionService {
    public Map<String,Object> queryAll(Integer nowPage, Integer pageSize);
}
