package com.example.mytestpro.config.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MyAnnotationValidator.class})
public @interface MyAnnotation {
    boolean required() default true;

    String message() default "请输入正确的格式";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


