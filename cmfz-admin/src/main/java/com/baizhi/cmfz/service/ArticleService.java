package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

public interface ArticleService {
    public Map<String, Object> queryArts(Integer nowPage, Integer pageSize);

    public Article queryArt(String articleId);

    public Integer addArticle(Article art);

    public Integer modifyArticle(Article art);
}
