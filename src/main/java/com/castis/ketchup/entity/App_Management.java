package com.castis.ketchup.entity;

import lombok.Getter;

@Getter
public class App_Management {

    //OS 구분(A:안드로이드 , I:IOS)
    private String os_type;
    //OS 버전 정보
    private String os_version;
    //update 일자
    private String update_date;

}
