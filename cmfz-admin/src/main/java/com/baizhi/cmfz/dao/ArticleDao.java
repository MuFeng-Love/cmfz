package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    public List<Article> findArts(@Param("rowsNumber")Integer rowsNumber, @Param("pageSize") Integer pageSize);

    public Integer count();

    public Article findArt(String articleId);

    public Integer updateArt(Article art);

    public Integer insertArt(Article art);
}
