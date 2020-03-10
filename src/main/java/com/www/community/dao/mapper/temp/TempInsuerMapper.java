package com.www.community.dao.mapper.temp;

import com.www.community.model.entity.temp.TempInsurEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempInsuerMapper {

    //添加
  //  Integer addTempInsuer(TempInsurEntity tempInsurEntity);

    int addTemp(TempInsurEntity tempInsurEntity);


    //根据id查询
    List<TempInsurEntity> selectTempInsuer(@Param("tempId") Integer tempId,@Param("insureCode") String insureCode,@Param("tempCode") String tempCode);
    //删除
    Integer deleteAppVersion(@Param("tempId") Integer tempId);

    //修改
    Integer updateAppVersion(TempInsurEntity tempInsurEntity);
}
