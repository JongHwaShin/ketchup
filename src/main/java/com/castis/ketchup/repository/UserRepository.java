package com.castis.ketchup.repository;

import com.castis.ketchup.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<User> getAllUsers();


}

