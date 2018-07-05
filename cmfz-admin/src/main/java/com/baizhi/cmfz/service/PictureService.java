package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.Picture;

import java.util.Map;

public interface PictureService {
    public Map<String,Object> queryPicture(Integer rowsNumber,Integer pageSize);

    public Integer addPicture(Picture picture);

    public Integer removePicture(String pictureId);

    public Integer modifyPicture(Picture picture);
}
