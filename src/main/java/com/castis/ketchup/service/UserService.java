package com.castis.ketchup.service;

import com.castis.ketchup.dto.UserMapper;
import com.castis.ketchup.entity.UserEntity;
import com.castis.ketchup.repository.UserRepository;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    //회원 전체 조회
    public List<UserEntity> getAllUser(){
        return userRepository.getAllUsers();
    }
}
