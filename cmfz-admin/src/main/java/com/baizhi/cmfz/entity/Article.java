package com.baizhi.cmfz.entity;

import java.util.Date;

public class Article {
    private String articleId;
    private String articleName;
    private String masterName;
    private String introduction;
    private Date date;
    private String mainPic;

    public Article() {
    }

    public Article(String articleId, String articleName, String masterName, String introduction, Date date, String mainPic) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.masterName = masterName;
        this.introduction = introduction;
        this.date = date;
        this.mainPic = mainPic;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", masterName='" + masterName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", date=" + date +
                ", mainPic='" + mainPic + '\'' +
                '}';
    }
}
