package com.www.community.dao.mapper.temp;

import com.www.community.model.entity.temp.ItemEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ItemMapper {
    List<ItemEntity> selectItemAndSku(@Param("title") String title ,@Param("itemId") Integer itemId);
}
