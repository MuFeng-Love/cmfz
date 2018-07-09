package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao ad;

    @Override
    public Map<String, Object> queryArts(Integer nowPage, Integer pageSize) {
        Integer rowsNumber = (nowPage-1)*pageSize;
        List<Article> arts= ad.findArts(rowsNumber,pageSize);

        int count = ad.count();

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("total",count);
        map.put("rows",arts);

        return map;
    }

    @Override
    public Article queryArt(String articleId) {
        Article art = new Article();
        art = ad.findArt(articleId);
        if (art!=null){
            return art;
        }
        return null;
    }

    @Override
    public Integer addArticle(Article art) {
        String artId = UUID.randomUUID().toString().replace("-", "");
        art.setArticleId(artId);
        Integer result = null;
        result = ad.insertArt(art);
        if (result>0){
            return result;
        }
        return null;
    }

    @Override
    public Integer modifyArticle(Article art) {
        Integer result = null;
        result = ad.updateArt(art);
        if (result>0){
            return result;
        }
        return null;
    }
}
