package framework;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;


/**
 * 没有debug信息的时候使用param注解
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({PARAMETER})
public @interface Param {
    public String value() default "";
}