package com.www.community.model.entity.news;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // 不输出null字段
@Table(name = "news_category")
public class NewsCategoryEntity {

    /**
     *  资讯分类id  主键自增
     */
    private Integer categoryId;

    /**
     *  新闻编号
     */
    private String categoryName;


    private Integer sortId;


    private Integer parentId;

    /**
     * 分类编号
     */
    private Integer level;

    /**
     * 用户编号
     */
    private String userCode;


    /**
     * 修改时间     不需要填写
     */
    private Date updateTime;

    /**
     * 有效标志  、有效状态默认是1
     * 有效标志1  无效0
     */
    private String yxBz;

    /**
     * 分类编码
     */
    private String categoryCode;

    /**
     * 子级集合
     */
    private List<NewsCategoryEntity> subLevelList;

    @Override
    public String toString() {
        return "NewsCategoryEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", sortId=" + sortId +
                ", parentId=" + parentId +
                ", level=" + level +
                ", userCode='" + userCode + '\'' +
                ", updateTime=" + updateTime +
                ", yxBz='" + yxBz + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", subLevelList=" + subLevelList +
                '}';
    }
}
