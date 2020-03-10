package com.www.community.service.local.temp.impl;

import com.www.community.dao.mapper.temp.TempInsuerMapper;
import com.www.community.exception.BizException;
import com.www.community.model.entity.temp.TempInsurEntity;
import com.www.community.service.local.temp.TempInsueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TempInsuerServiceImpl implements TempInsueService {

    @Resource
    private TempInsuerMapper tempInsuerMapper;

    @Override
    public Integer addTemp(TempInsurEntity tempInsurEntity,String userCode){
        Date date = new Date();
        tempInsurEntity.setAddTime(date);
        tempInsurEntity.setUserCode(userCode);
        //投保信息咱村类型
        tempInsurEntity.setTempType("1");
        tempInsurEntity.setStatus("1");
        tempInsurEntity.setTempCode("YL"+System.currentTimeMillis());
        System.out.println("K快捷键"+00);
        Integer integer = tempInsuerMapper.addTemp(tempInsurEntity);
        return integer;
    }

    @Override
    public List<TempInsurEntity> selectTempInsuer(Integer tempId, String insuerCode, String userCode) {
        if (tempId ==null  && insuerCode == null && userCode==null) {
            throw new BizException("无条件");
        }
        List<TempInsurEntity> tempInsurEntities = tempInsuerMapper.selectTempInsuer(tempId, insuerCode, userCode);
        if(tempInsurEntities==null || "".equals(tempInsurEntities)){
throw new BizException("无预存数据");
        }
        return tempInsurEntities;
    }

    @Override
    public Integer deleteAppVersion(Integer tempId) {
        Integer integer = tempInsuerMapper.deleteAppVersion(tempId);
        return integer;
    }

    @Override
    public Integer updateAppVersion(TempInsurEntity tempInsurEntity, Integer userCode) {
        tempInsurEntity.setTempId(userCode);
        Integer integer = tempInsuerMapper.updateAppVersion(tempInsurEntity
        );
        return integer;
    }
}
