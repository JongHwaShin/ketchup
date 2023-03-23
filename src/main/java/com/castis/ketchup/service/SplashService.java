package com.castis.ketchup.service;

import com.castis.ketchup.entity.App_Management;
import com.castis.ketchup.repository.SplashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SplashService {

    @Autowired
    private  SplashRepository splashRepository;

    public App_Management getVersionCheckAOS(){
        return splashRepository.getVersionCheckAOS();
    }
    @Transactional
    public String getVersionCheck(String os_type){
        return splashRepository.getVersionCheck(os_type);
    }
}
