package com.castis.ketchup.controller;

import com.castis.ketchup.entity.App_Management;
import com.castis.ketchup.entity.Response;
import com.castis.ketchup.global.error.StatusCode;
import com.castis.ketchup.service.SplashService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/app")
public class SplashController {

    private Logger logger = LoggerFactory.getLogger(SplashController.class);

    @Autowired
    private SplashService splashService;

    @GetMapping(value = "/{APP_TYPE}/info/getVersionCheck")
    public Response getVersionCheck(@RequestParam String os_type, @PathVariable("APP_TYPE") String app_type){
        Response result = null;
       try {
           String tmp_Version = splashService.getVersionCheck(os_type);
           Boolean test = false;

           String resStr =  String.format("{\"res_version\" : \"%s\"}",test);
           JSONParser parser = new JSONParser();
           JSONObject jsonObject = (JSONObject) parser.parse(resStr);

           logger.info("version ==" + tmp_Version);
           HttpHeaders headers = new HttpHeaders();
           headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

           result = new Response(StatusCode.OK,"성공" , jsonObject);
       }catch (Exception e){
           logger.error(String.valueOf(e));
           result = new Response(StatusCode.INTERNAL_SERVER_ERROR,"에러");
           return result;
       }
       return result;
    }




}
