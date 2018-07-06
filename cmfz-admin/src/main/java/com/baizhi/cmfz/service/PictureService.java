package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

public interface PictureService {
    public Map<String,Object> queryPicture(Integer nowPage, Integer pageSize);

    public Picture queryPictureById(String pictureId);

    public Integer addPicture(Picture picture);

    public Integer removePicture(String pictureId);

    public Integer modifyPicture(Picture picture);
}
