package edu.zc.oj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailTo:5239604@qq.com">coderPlus-tr</a>
 * @date 2021/3/19
 */

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAuthentication {
}
