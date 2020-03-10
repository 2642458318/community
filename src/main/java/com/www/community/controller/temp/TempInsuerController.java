package com.www.community.controller.temp;

import com.www.community.model.GenericListResponse;
import com.www.community.model.GenericResponse;
import com.www.community.model.entity.temp.TempInsurEntity;
import com.www.community.service.local.temp.TempInsueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("temp")
@Api(value = "临时数据管理", tags = {"Temp-API"}, description = "临时管理接口")
public class TempInsuerController {

    @Resource
    private TempInsueService tempInsueService;

    @ApiOperation(value = "添加临时数据", notes = "临时数据管理", httpMethod = "POST")
    @PostMapping(value = "/addTempInsuer", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericResponse> addTempInsuer(@RequestBody TempInsurEntity tempInsurEntity,
                                                         @RequestHeader(value = "userId") @ApiParam(value = "操作人ID", required = true) String userId) {
        tempInsueService.addTemp(tempInsurEntity, userId);
        return GenericResponse.ok();
    }

    @ApiOperation(value = "查询临时数据", notes = "临时数据管理", httpMethod = "POST")
    @PostMapping(value = "/selectTempInsuer", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericListResponse<TempInsurEntity>> selectAppVersion(Integer tempId, String insuerCode, String tempCode) {
        List<TempInsurEntity> tempInsurEntities = tempInsueService.selectTempInsuer(tempId, insuerCode, tempCode);
        return GenericListResponse.listNoCount(tempInsurEntities);
    }

    @ApiOperation(value = "删除临时数据", notes = "临时数据管理", httpMethod = "POST")
    @PostMapping(value = "/deleteTempInsuer", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericResponse> deleteAppVersion(Integer id) {
        Integer integer = tempInsueService.deleteAppVersion(id);
        return GenericResponse.ok();
    }
    @ApiOperation(value = "修改临时数据", notes = "临时数据管理",httpMethod = "POST")
    @PostMapping(value = "/updateTempInsuer",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericResponse> updateAppVersion(
            @ApiParam(name = "修改临时数据",value = "删除临时数据，修改json",required = true)@RequestBody TempInsurEntity tempInsurEntity,
            @RequestHeader(value = "userId")@ApiParam(value = "用户Id", required = true)Integer userId
    ){
        Integer integer = tempInsueService.updateAppVersion(tempInsurEntity, userId);
        return GenericResponse.ok();
    }
}
