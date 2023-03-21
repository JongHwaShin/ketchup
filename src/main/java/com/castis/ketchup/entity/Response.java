package com.castis.ketchup.entity;

import com.castis.ketchup.global.error.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    private StatusCode statusCode;

    private String res_msg;
    private String result;

    public Response(StatusCode statusCode, String res_msg, String result) {
        this.statusCode = statusCode;
        this.res_msg = res_msg;
        this.result = result;
    }

    public Response(StatusCode statusCode, String res_msg) {
        this.statusCode = statusCode;
        this.res_msg = res_msg;
    }
}
