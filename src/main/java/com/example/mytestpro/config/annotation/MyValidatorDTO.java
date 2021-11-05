package com.example.mytestpro.config.annotation;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MyValidatorDTO {
    @MyAnnotation(message = "name wrong",groups = {InsertGroup.class,UpdateGroup.class})
    private String name;
    @NotBlank
    private String englishName;
}
