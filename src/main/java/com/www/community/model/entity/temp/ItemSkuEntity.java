package com.www.community.model.entity.temp;

import lombok.Data;

@Data
public class ItemSkuEntity {
    private Integer skuId;
    private int itemId;
    private String skuPrice;
    private String skuUniqueCode;
    private Integer quantity;
}
