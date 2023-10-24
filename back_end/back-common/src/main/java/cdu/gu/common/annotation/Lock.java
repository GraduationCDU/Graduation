package cdu.gu.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lock {
    String key();
    long expire() default 10; //设置默认时间
    TimeUnit timeUnit() default TimeUnit.SECONDS; //设置时间单位为秒
}
