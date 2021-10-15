package com.example.mytestpro.annotation;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@Log4j2
public class MyAnnotationValidator implements ConstraintValidator<MyAnnotation, String> {
    private boolean isRequired = false;
    private Class<?>[] groups=null;

    @Override
    public void initialize(MyAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        isRequired = constraintAnnotation.required();
        groups= constraintAnnotation.groups();//获取分组
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (Class<?> item:groups){
            if(item.getSimpleName().equals("InsertGroup")){
                if (s.isEmpty()) {//新增时name不能为空
                    return false;
                }
            }
            if(item.getSimpleName().equals("UpdateGroup")){
                if (s.equals("Nicholas")) {//修改时不能修改为已经存在的名字（假装是这个意思）
                    return false;
                }
            }
        }
        return true;
    }
}
