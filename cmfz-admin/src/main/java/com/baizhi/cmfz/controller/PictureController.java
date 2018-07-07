package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("/searchAll")
    @ResponseBody
    public Map<String,Object> searchAll(@RequestParam("page")Integer nowPage,@RequestParam("rows")Integer pageSize){
        return ps.queryPicture(nowPage,pageSize);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Integer create(MultipartFile myFile, HttpSession session, @RequestParam("pictureDescription") String pictureDescription, @RequestParam("pictureStatus")String pictureStatus) throws IOException {

        //文件的上传
        String realPath = session.getServletContext().getRealPath("/");
        int lastIndex = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndex);
        lastIndex = substring.lastIndexOf("\\");
        String substring1 = substring.substring(0, lastIndex);
        String uploadPath = substring1+"\\upload\\";

        String picturePath = myFile.getOriginalFilename();

        myFile.transferTo(new File(uploadPath+"/"+picturePath));

        Picture pic = new Picture();
        String pictureId = UUID.randomUUID().toString().replace("-","");
        pic.setPictureId(pictureId);
        pic.setPicturePath(picturePath);
        pic.setPictureDescription(pictureDescription);
        pic.setPictureStatus(pictureStatus);


        return ps.addPicture(pic);
    }

    @RequestMapping("/drop")
    @ResponseBody
    public Integer drop(@RequestParam("pictureId")String pictureId){
        return ps.removePicture(pictureId);
    }

    @RequestMapping("/change")
    @ResponseBody
    public Integer change(@RequestParam("pictureId")String pictureId,@RequestParam("picturePath")String picturePath,@RequestParam("pictureDescription") String pictureDescription,@RequestParam("pictureStatus")String pictureStatus){
        Picture pic = new Picture();
        pic = ps.queryPictureById(pictureId);
        if (pic!=null) {
            pic.setPictureStatus(pictureStatus);
            pic.setPictureDescription(pictureDescription);
            pic.setPicturePath(picturePath);
            return ps.modifyPicture(pic);
        }
        throw new RuntimeException("没有找到该图片");
    }

}
