package com.www.community.controller.system.basic;

import com.www.community.model.entity.hr.Position;
import com.www.community.service.local.system.basic.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "基础信息设置",tags = {"Position API"})
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @ApiOperation(value = "职员职位查询",httpMethod = "GET")
    @GetMapping(value = "/",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }
}
