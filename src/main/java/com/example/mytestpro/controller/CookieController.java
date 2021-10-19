package com.example.mytestpro.controller;

import com.example.mytestpro.enums.Cookies;
import com.example.mytestpro.request.CookieRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cookie")
public class CookieController {
    private final static Logger logger = LoggerFactory.getLogger(CookieController.class);
    @RequestMapping("/query")
    public String getCookie(@RequestBody CookieRequest request){
        return Cookies.HAI1.getValue();
    }
}
