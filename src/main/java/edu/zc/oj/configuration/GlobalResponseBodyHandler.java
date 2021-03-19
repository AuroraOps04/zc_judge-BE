package edu.zc.oj.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zc.oj.annotation.NoDecoration;
import edu.zc.oj.entity.response.Response;
import edu.zc.oj.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author coderplus-tr
 * @date 2021/3/5 20:52:36
 */

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if(returnType.hasMethodAnnotation(NoDecoration.class)){
            return false;
        }
        return !returnType.getGenericParameterType().equals(Response.class)
                && !returnType.getGenericParameterType().equals(String.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return ResultUtils.success(body);
    }
}
