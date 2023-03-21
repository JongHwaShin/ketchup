package com.castis.ketchup.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
    //아이디
    private String id;
    //이름
    private String name;
    //비밀번호
    private String password;
    //이메일
    private String email;
    //전화번호
    private String phone;
    //대표계좌 설정
    private String account;
    //사용자 삭제 여부(Y/N)
    private String use_YN;
    //등록일
    private String reg_date;
    //수정일
    private String edit_date;

}
