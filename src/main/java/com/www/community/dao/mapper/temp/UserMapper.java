package com.www.community.dao.mapper.temp;

import com.www.community.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void addUser(User user);

    User findByToken(@Param("token") String token);

    User findById(@Param("id") Integer id);
}
