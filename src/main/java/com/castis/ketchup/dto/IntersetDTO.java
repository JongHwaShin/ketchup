package com.castis.ketchup.dto;

import com.castis.ketchup.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class IntersetDTO {

    private User user;
    private String product_id;
    private String reg_date;
}
