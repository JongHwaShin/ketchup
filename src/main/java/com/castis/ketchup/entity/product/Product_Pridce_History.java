package com.castis.ketchup.entity.product;

import lombok.Getter;

@Getter
public class Product_Pridce_History {

    //상품 코드
    private String product_id;
    //상품 가격
    private int price;
    //사용자 ID
    private String user;
    //등록일
    private String date;


}
