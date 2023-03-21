package com.castis.ketchup.entity;

import com.castis.ketchup.global.error.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    private StatusCode res_code;

    private String res_msg;

    private JSONObject result;

    public Response(StatusCode res_code, String res_msg, JSONObject result) {
        this.res_code = res_code;
        this.res_msg = res_msg;
        this.result = result;
    }

    public Response(StatusCode res_code, String res_msg) {
        this.res_code = res_code;
        this.res_msg = res_msg;
    }

}
