package com.www.community.model.entity.temp;

import lombok.Data;

import java.util.List;

@Data
public class ItemEntity {
    private Integer itemId;
    private String imgUrl;
    private String title;
    private String price;
    private String itemType;
    private Integer quantity;
    private List<ItemSkuEntity> itemSkuEntityList;

}
