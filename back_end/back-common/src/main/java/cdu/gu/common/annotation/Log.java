package cdu.gu.common.annotation;

import cdu.gu.common.constant.BusinessTypeConstant;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    public String title() default "";
    public BusinessTypeConstant businessType() default BusinessTypeConstant.OTHER;
}
