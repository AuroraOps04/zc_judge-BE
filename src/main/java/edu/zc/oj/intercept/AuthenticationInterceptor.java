package edu.zc.oj.intercept;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zc.oj.annotation.AdminUser;
import edu.zc.oj.annotation.PassToken;
import edu.zc.oj.annotation.TeacherUser;
import edu.zc.oj.entity.Role;
import edu.zc.oj.utils.JWTUtils;
import edu.zc.oj.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/19
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final ObjectMapper objectMapper;

    private boolean hasAnnotation(Method method, Class<? extends Annotation> clzz) {
        if (method.isAnnotationPresent(clzz)) {
            return true;
        }
        return method.getDeclaringClass().isAnnotationPresent(clzz);
    }

    private void returnJson(HttpServletResponse response, Object data) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(objectMapper.writeValueAsString(data));
        } catch (IOException e) {
            log.error("response error", e);
        }
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否需要跳过Token验证
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            if (method.hasMethodAnnotation(PassToken.class)) {
                return true;
            }
            // 验证token
            final String token = request.getHeader("X-Authentication-Token");
            if (StringUtils.isEmpty(token) || !JWTUtils.verify(token)) {
                returnJson(response, ResultUtils.unauthorized());
                return false;
            }
            // 判断用户是否有权限.
            final Role role = JWTUtils.getUserFormToken(token).getRole();
            Method mtd = method.getMethod();
            if (hasAnnotation(mtd, TeacherUser.class)) {
                if (null == role || !"teacher".equals(role.getName()) && !"admin".equals(role.getName())) {
                    returnJson(response, ResultUtils.unauthorized());
                    return false;
                }
            }
            if (hasAnnotation(mtd, AdminUser.class)) {
                if (null == role || !"admin".equals(role.getName())) {
                    returnJson(response, ResultUtils.unauthorized());
                    return false;
                }
            }
        }

        return true;
    }

}
