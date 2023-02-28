package com.castis.ketchup.dto;

import com.castis.ketchup.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<UserEntity> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    UserEntity findByUserId(@Param("id") int id);


}
