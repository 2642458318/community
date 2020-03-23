package com.www.community.dao.mapper.news;

import com.www.community.model.entity.news.NewsEntity;
import org.apache.ibatis.annotations.Param;

public interface newsMapper {
    /**
     * 添加新闻
     * @param news 新闻对象
     * @return 返回插入条数
     */
    int insertNews(@Param("news") NewsEntity news);
}
