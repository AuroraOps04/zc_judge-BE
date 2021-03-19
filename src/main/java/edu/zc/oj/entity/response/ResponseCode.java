package edu.zc.oj.entity.response;

/**
 * @author coderPlus-tr
 */

public enum ResponseCode {
    /**
     *
     */

    SUCCESS(200, "ok"),
    PARAMS_ERROR(400, "Incorrect request parameter"),
    NOT_FOUND(404, "not found"),
    SERVER_ERROR(500, "server error"),
    INSERT_SUCCESS(201, "insert success"),
    METHOD_NOT_SUPPORTED(405 , "http request method not supported"),
    ;
    private final Integer code;
    private final String message;
    ResponseCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public  Integer getCode(){ return code; }
    public String getMessage(){ return message; }
}
