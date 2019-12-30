package com.enjoy.james.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnjoyRequestHeader {
    String value() default "";
}
