package com.www.community.service.local.temp;

import com.www.community.model.entity.temp.TempInsurEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TempInsueService {


    //添加
    Integer addTemp(TempInsurEntity tempInsurEntity,String UserCode);
    //根据用户id或用户code查询
    List<TempInsurEntity> selectTempInsuer(Integer tempId,String insuerCode,String userCode);

    //删除
    Integer deleteAppVersion(@Param("tempId") Integer tempId);

    //修改
    Integer updateAppVersion(TempInsurEntity tempInsurEntity,Integer userCode);
}
