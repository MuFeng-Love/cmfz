package com.baizhi.cmfz.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;
    private String name;
    private String code;
    private String icon;
    private String url;
    private String level;
    private String parentId;

    //用来记录二级标签（通过一次查询直接进行二级标签的归类整合）
    private List<Menu> childMenus = new ArrayList<Menu>();

    public Menu() {
    }

    public Menu(Integer id, String name, String code, String icon, String url, String level, String parentId, List<Menu> childMenus) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.icon = icon;
        this.url = url;
        this.level = level;
        this.parentId = parentId;
        this.childMenus = childMenus;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", level='" + level + '\'' +
                ", parentId='" + parentId + '\'' +
                ", childMenus=" + childMenus +
                '}';
    }
}
