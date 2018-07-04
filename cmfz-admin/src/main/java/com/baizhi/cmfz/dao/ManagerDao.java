package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;

public interface ManagerDao {
    public Manager selectManagerByName(String mgrName);
}
