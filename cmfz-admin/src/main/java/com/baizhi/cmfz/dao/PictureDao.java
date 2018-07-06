package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureDao {
    public List<Picture> findAllPicture(@Param("rowsNumber") Integer rowsNumber, @Param("pageSize") Integer pageSize);

    public Integer deletePicture(String pictureId);

    public Integer updatePicture(Picture picture);

    public Integer insertPicture(Picture picture);

    public Integer count();

    public Picture findPictureById(String pictureId);
}
