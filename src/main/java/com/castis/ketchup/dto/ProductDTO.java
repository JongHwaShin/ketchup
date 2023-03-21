package com.castis.ketchup.dto;

import lombok.Getter;

@Getter
public class ProductDTO {

    //상품 코드
    private String product_id;
    //위치(본사:C, 태국:T, 베트남:V)
    private String location_id;
    //종류(의류:0, 식품:1, 가구:2, 전자제품:3)
    private String category_id;

    private String title;

    private String contents;
    //최종 거래 금액
    private int price;
    //사진 파일명
    private String photo;
    //사진 파일 경로
    private String photo_path;
    //등록자
    private String reg_user;
    //등록일
    private String reg_date;

}
