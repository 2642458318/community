package com.www.community.model.entity.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewsEntity {
    //主键，新闻id
    private Integer newsId;
    //新闻标题
    private String newsTitle;
    //新闻内容
    private String newsContent;
    //图片（路径）
    private String img;
    //状态：0未发布 1已发布
    private String status;
    //发布日期
    @DateTimeFormat(pattern = "yyyy-mm-dd hh-mm-ss")
    @JsonFormat(pattern = "yyyy-mm-dd hh-mm-ss", timezone = "GMT+8")
    private Date publishDate;
    //作者
    private String author;
    //阅览量
    private Integer browseNum;
    //点赞量
    private Integer praiseNum;
    //发布省份
    private String provinceName;
    //省份编号
    private Integer provinceNo;
    //用户编号
    private String userCode;
    //修改时间
    private Date updateTime;
    //有效标志：0无效 1有效
    private String yxBz;
    //分类编号
    private Integer categoryId;
    //分类名称
    private String categoryName;
    //标签编号
    private Integer tagId;
    //标签名称
    private String tagName;
    //简短摘要
    private String newsBrief;
    //短标题
    private String shortTitle;
    //pc 0   app 1
    private String client;
}
