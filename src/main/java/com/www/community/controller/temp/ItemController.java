package com.www.community.controller.temp;

import com.github.pagehelper.PageInfo;
import com.www.community.model.entity.temp.ItemEntity;
import com.www.community.service.local.temp.impl.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemService itemService;
    @ApiOperation(value = "shuju", notes = "", httpMethod = "POST")
    @PostMapping(value = "/selectItem", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<ItemEntity> findCountryList(String item, Integer itemId, int pc, int ps) {
        PageInfo<ItemEntity> itemEntityPageInfo = itemService.selectItemAndSku(item, itemId, pc, ps);
        return itemEntityPageInfo.getList();
    }
}
