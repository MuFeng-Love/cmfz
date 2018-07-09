package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.GetTextForResult;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService as;

    @Autowired
    private MasterService ms;

    @RequestMapping("/author")
    @ResponseBody
    public List<Master> getAuthor() {
        System.out.println("------"+ms.queryMasters());
       return ms.queryMasters();
    }

    @RequestMapping("/create")
    @ResponseBody
    public String createArticle(Article art){
        int result = as.addArticle(art);
        if (result > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/upload")
    @ResponseBody
    public GetTextForResult uploadFiles(@RequestParam("files")MultipartFile[] files, HttpServletRequest request) throws IOException {
        GetTextForResult result = new GetTextForResult();
        if(files != null && files.length != 0) {
            List<String> strings = new ArrayList<String>();
            String realPath = request.getSession().getServletContext().getRealPath("/");
            int lastIndexOf = realPath.lastIndexOf("\\admin");
            String Newpath = realPath.substring(0,lastIndexOf) + "\\upload\\article";
            String fileName = UUID.randomUUID().toString().replace("-","");
            for (MultipartFile file : files) {
                String oldName = file.getOriginalFilename();
                String suffix = oldName.substring(oldName.lastIndexOf("."));
                file.transferTo(new File(Newpath + "/" + fileName + suffix));
                strings.add(request.getContextPath()+"/upload/article/" + fileName + suffix);
            }
            result.setErrno(0);
            result.setData(strings);
        } else {
            result.setErrno(1);
        }
        return result;
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String, Object> showAll(Integer page, Integer rows){
        System.out.println(as.queryArts(page,rows));
        return as.queryArts(page,rows);
    }

    @RequestMapping("/getIntroduction")
    @ResponseBody
    public String getIntroduction(String articleId){
        Article art = as.queryArt(articleId);
        return art.getIntroduction();
    }
}
