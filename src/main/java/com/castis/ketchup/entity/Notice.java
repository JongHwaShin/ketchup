package com.castis.ketchup.entity;

import lombok.Getter;

@Getter
public class Notice {
    //번호
    private int id;
    //제목
    private String title;
    //내용
    private String contents;
    //등록일
    private String date;
    //작성자
    private String user;

}
