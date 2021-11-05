package com.example.mytestpro.config.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/validator")
public class MyValidatorController {
    @Autowired
    private MyValidatorService myValidatorService;
    @RequestMapping("/insert")
    public String test(@RequestBody @Validated({InsertGroup.class}) MyValidatorDTO myValidatorDTO){
        myValidatorService.test(myValidatorDTO);
        return "OK";
    }
    @RequestMapping("/update")
    public String test2(@RequestBody @Validated({UpdateGroup.class}) MyValidatorDTO myValidatorDTO){
        myValidatorService.test(myValidatorDTO);
        return "OK";
    }
}
