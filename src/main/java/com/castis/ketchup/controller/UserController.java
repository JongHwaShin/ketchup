package com.castis.ketchup.controller;

import com.castis.ketchup.entity.UserEntity;
import com.castis.ketchup.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers")
    public String index(Model model){

        List<UserEntity> allUser = userService.getAllUser();

        allUser.forEach(user -> System.out.println("user = " + user.getName()));
        logger.info("DB Connect Success!!!");

        model.addAttribute("userList",allUser);

        return "index";

    }





}
