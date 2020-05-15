package com.ecut.dao;

import com.ecut.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    User findByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

}
