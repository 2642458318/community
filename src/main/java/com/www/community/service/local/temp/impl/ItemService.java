package com.www.community.service.local.temp.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.www.community.dao.mapper.temp.ItemMapper;
import com.www.community.model.entity.temp.ItemEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Test
    public PageInfo<ItemEntity> selectItemAndSku(String title, Integer itemId,int pc ,int ps){

        PageHelper.startPage(pc,ps);
        List<ItemEntity> itemEntities = itemMapper.selectItemAndSku(title,itemId);
        for (ItemEntity itemss:itemEntities){
            System.out.println(itemss);
        }
        System.out.println("打印"+JSONObject.toJSON(itemEntities));
        PageInfo<ItemEntity> pageInfos = new PageInfo<>(itemEntities); //通用写法

        return pageInfos;
    }
    @Test
     public void main(String[] args) {
        selectItemAndSku("", null,1,2);
     }
}
