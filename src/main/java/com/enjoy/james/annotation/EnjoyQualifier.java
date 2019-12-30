package com.enjoy.james.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnjoyQualifier {
    String value() default "";
}
