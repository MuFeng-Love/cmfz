package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description picture的service实现类
 * @Time 2018-07-05 9:50
 * @Author wch
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pd;

    /**
     * @Description 更新图片信息
     * @Author wch
     * @param nowPage(当前页)
     * @param pageSize(页面的大小)
     * @Time 2018-07-05 9:48
     */
    @Override
    public Map<String, Object> queryPicture(Integer nowPage, Integer pageSize) {

        Integer rowsNumber = (nowPage-1)*pageSize;
        List<Picture> pictures = pd.findAllPicture(rowsNumber,pageSize);

        int count = pd.count();

        Map<String,Object> map =new HashMap<String, Object>();

        map.put("total",count);
        map.put("rows",pictures);

        return map;
    }

    @Override
    public Picture queryPictureById(String pictureId) {
        Picture pic = new Picture();
        pic = pd.findPictureById(pictureId);
        if (pic!=null){
            return pic;
        }
        return null;
    }

    /**
     * @Description 增加图片
     * @Author wch
     * @param picture
     * @Time 2018-07-05 9:47
     */
    @Override
    public Integer addPicture(Picture picture) {
        Integer result = null;
        result = pd.insertPicture(picture);
        if (result>0){
            return result;
        }
        return null;
    }

    /**
     * @Description 删除图片
     * @Author wch
     * @param pictureId
     * @Time 2018-07-05 9:47
     */
    @Override
    public Integer removePicture(String pictureId) {
        Integer result = null;
        result = pd.deletePicture(pictureId);
        if (result>0){
            return result;
        }
        return null;
    }

    /**
     * @Description 更新图片信息
     * @Author wch
     * @param picture
     * @Time 2018-07-05 9:47
     */
    @Override
    public Integer modifyPicture(Picture picture) {
        Integer result = null;
        result = pd.updatePicture(picture);
        if (result>0){
            return result;
        }
        return null;
    }
}
