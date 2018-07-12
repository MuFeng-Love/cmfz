package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface ManagerDao {
    public Manager selectManagerByName(String mgrName);

    public List<Role> selectRolesByName(String mgrName);

    public List<Permission> selectPermissionByName(String mgrName);
}
