package com.example.mytestpro.annotation;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MyValidatorDTO {
    @MyAnnotation(message = "name wrong",groups = {InsertGroup.class,UpdateGroup.class})
    private String name;
    @NotBlank
    private String englishName;
}
