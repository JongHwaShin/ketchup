package com.castis.ketchup.service;

import com.castis.ketchup.entity.User;
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


    //회원 전체 조회
    public List<User> getAllUser(){
        return userRepository.getAllUsers();
    }
}
