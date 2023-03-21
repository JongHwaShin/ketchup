package com.castis.ketchup.repository;

import com.castis.ketchup.entity.App_Management;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SplashRepository {

    App_Management getVersionCheckAOS();

    String getVersionCheck(String os_type);
}
