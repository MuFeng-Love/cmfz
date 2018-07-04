package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao md;

    @Override
    public Manager queryManagerByName(String mgrName) {
        Manager manager = new Manager();
        manager = md.selectManagerByName(mgrName);
        System.out.println(manager+"----------ServiceImpl");
        if (manager!=null){
            return manager;
        }
        return null;
    }
}
