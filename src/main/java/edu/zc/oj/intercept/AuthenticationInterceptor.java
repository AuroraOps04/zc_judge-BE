package edu.zc.oj.intercept;

import com.auth0.jwt.JWT;
import edu.zc.oj.annotation.AdminUser;
import edu.zc.oj.annotation.PassToken;
import edu.zc.oj.annotation.RoleAuthentication;
import edu.zc.oj.annotation.TeacherUser;
import edu.zc.oj.entity.Role;
import edu.zc.oj.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/19
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private boolean hasAnnotation(Method method, Class<? extends Annotation> clzz){
        if(method.isAnnotationPresent(clzz)){
            return true;
        }
        return method.getDeclaringClass().isAnnotationPresent(clzz);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否需要跳过Token验证
        HandlerMethod method = (HandlerMethod) handler;
        if(method.hasMethodAnnotation(PassToken.class)){
            return true;
        }
        // 验证token
        final String token = request.getHeader("X-Authentication-Token");
        if(StringUtils.isEmpty(token) || !JWTUtils.verify(token)){
            return false;
        }
        // 判断用户是否有权限.
        final Role role = JWTUtils.getUserFormToken(token).getRole();
        Method mtd = method.getMethod();
        if(hasAnnotation(mtd, TeacherUser.class)){
            if(null == role || !"teacher".equals(role.getName()) && !"admin".equals(role.getName())){
                return false;
            }
        }
        if(hasAnnotation(mtd, AdminUser.class)){
            return null != role && "admin".equals(role.getName());
        }


        return true;
    }
}
