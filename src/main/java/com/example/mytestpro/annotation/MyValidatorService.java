package com.example.mytestpro.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyValidatorService {

    public void test(MyValidatorDTO myValidatorDTO){
        log.info("entry service");
    }
}
