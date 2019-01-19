package cj.aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MethodLog {
	String remark() default "";
//	String operType() default "0";
	String desc() default "身份和安全验证开始...";
}