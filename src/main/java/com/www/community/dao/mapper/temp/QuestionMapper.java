package com.www.community.dao.mapper.temp;

import com.www.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    void create(Question question);

    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    Integer count();
}
