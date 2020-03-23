package com.www.community.service.local.news;

import com.github.pagehelper.PageInfo;
import com.www.community.model.entity.news.NewsCategoryEntity;
import com.www.community.model.param.news.AddNewsCategoryParam;
import com.www.community.model.param.news.AlterNewsCategoryParam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsCategoryService {
    /**
     * 添加资讯分类
     */
    int addCategory(AddNewsCategoryParam addNewsCategoryParam);

    /**
     * 咨询分类删除
     */
    void deleteCategory(Integer[] categoryId);

    /**
     * 资讯分类修改
     */
    void updateNewsItemCategory(AlterNewsCategoryParam alterNewsCategoryParam);

    /**
     * 咨询分类查询 - 分类列表使用
     */
    PageInfo<NewsCategoryEntity> categoryList(Integer integer, String categoryName, Integer pn, Integer ps);
    /**
     * 根据父级查询子级-层级查询
     */
    List<NewsCategoryEntity> findAllRecursion();
    /**
     * 资讯分类查询 - 下拉框使用,无分页
     * update this method by fx
     * date:2019/05/31
     *
     * @return 分类对象
     */
    List<NewsCategoryEntity> categoryListNoPage();

}
