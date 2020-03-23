package com.www.community.dao.mapper.news;

import com.www.community.model.entity.news.NewsCategoryEntity;
import com.www.community.model.param.news.AddNewsCategoryParam;
import com.www.community.model.param.news.AlterNewsCategoryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsCategoryMapper {
    /**
     * 查询分类编码是否存在
     */
    String selectIsCategoryCode(@Param("categoryCode") String categoryCode);

    /**
     * 添加咨询分类
     */
    int addCategory(@Param("addNewsCategoryParam") AddNewsCategoryParam addNewsCategoryParam);

    /**
     * 查询资讯分类
     */
    List<NewsCategoryEntity> selectNewsCategoryByCondition(@Param("parentId") Integer parentId, @Param("categoryName") String categoryName);

    /**
     * 删除资讯分类
     */
    int deleteCategory(@Param("categoryId") Integer category);

    /**
     * 咨询分类修改
     */
    int updateNewsCategory(@Param("alterNewsCategoryParam") AlterNewsCategoryParam alterNewsCategoryParam);
    /**
     * 查询资讯（分级，根据父级查子级）
     */
    List<NewsCategoryEntity> findAllRecursion();
}
