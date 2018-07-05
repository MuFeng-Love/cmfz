package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @description Menu的数据库操作名
 * @author wch
 * @create 2018-07-05 13:05
 */
public interface MenuDao {
    /**
     * @Description 查询所有的Menu标签
     * @Author wch
     * @return java.util.list
     */
    public List<Menu> findListMenus();
}
