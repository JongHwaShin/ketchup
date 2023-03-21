package com.castis.ketchup.global.error;

import lombok.Getter;

@Getter
public enum StatusCode {
    OK(200,"성공"),
    NO_CONTENT(204,"No Content"),
    BAD_REQUEST(400,"Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403,"Forbidden"),
    NOT_FOUND(404,"NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
    SERVICE_UNAVAILABLE(503,"Servie Unavailable");



    private final String message;
    private final int statusCode;

    StatusCode(int statusCode, String message) {

        this.message = message;
        this.statusCode = statusCode;
    }
}
