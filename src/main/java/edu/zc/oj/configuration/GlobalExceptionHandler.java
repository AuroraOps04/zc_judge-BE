package edu.zc.oj.configuration;

import edu.zc.oj.entity.response.Response;
import edu.zc.oj.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author coderplus-tr
 * @date 2021/3/5 20:36:18
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private String getErrors(List<ObjectError> errors) {
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        return errorMsg.toString();
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class, BindException.class})
    public Response methodArgumentNotValidHandler(HttpServletRequest request,
                                                  Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            final String errors = getErrors(exception.getBindingResult().getAllErrors());
            log.error("---MethodArgumentNotValidException--- ERROR: {}", errors);
            return ResultUtils.paramsError(errors);
        }
        if (e instanceof BindException) {
            BindException exception = (BindException) e;
            final String errors = getErrors(exception.getAllErrors());
            System.out.println(exception.getAllErrors());
            log.error("---BindException--- ERROR: {}", errors);
            return ResultUtils.paramsError(errors);
        }
        log.error(e.getMessage());
        return ResultUtils.paramsError();
    }

    @ExceptionHandler(value = Exception.class)
    public Response unknownExceptionHandler(Exception e) {
        System.out.println(e.getClass());
        log.error("occurrence unknown exception cause: {} ", e.getMessage(), e);
        return ResultUtils.serverError();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Response httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException exception) {
        log.error(exception.getMessage());
        return ResultUtils.methodNotSupported();
    }

}
