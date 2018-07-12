package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface ManagerService {
    public Manager queryManagerByName(String mgrName);

    public List<Role> queryRolesByName(String mgrName);

    public List<Permission> queryPermissionsByName(String mgrName);
}
