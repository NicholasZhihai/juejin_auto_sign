package com.example.mytestpro.config.privacy;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = PrivacySerializer.class)
public @interface Privacy {
    /**
     * 前置长度
     */
    int preLen() default 0;
    /**
     * 后置长度
     */
    int sufLen() default 0;
    /**
     * 脱敏字符
     */
    String chara() default "*";
}
