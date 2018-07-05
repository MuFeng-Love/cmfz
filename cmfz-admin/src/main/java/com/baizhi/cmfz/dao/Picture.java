package com.baizhi.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Picture {
    public List<Picture> findAllPicture(@Param("rowsNumber") Integer rowsNumber, @Param("pageSzie") Integer pageSize);

    public Integer deletePicture(String pictureId);

    public Integer updatePicture(Picture picture);

    public Integer insertPicture(Picture picture);

    public Integer count();
}
