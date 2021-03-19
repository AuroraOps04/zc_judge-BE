package edu.zc.oj.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coderplus-tr
 * @date 2021/3/5 20:33:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Integer code;
    private String message;
    private Object data;

    public Response(ResponseCode responseCode){
        this(responseCode.getCode(), responseCode.getMessage());
    }
    public Response(ResponseCode responseCode, Object data){
       this(responseCode.getCode(), responseCode.getMessage(), data);
    }

    public Response(Integer code, String message){
        this(code, message, null);
    }
}
