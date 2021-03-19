package edu.zc.oj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/19
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RoleAuthentication
public @interface TeacherUser {
    String value() default "teacher";
}
