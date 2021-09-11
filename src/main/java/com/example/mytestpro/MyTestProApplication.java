package com.example.mytestpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 开启定时任务，取消springdatasource加载
 */
@EnableScheduling
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MyTestProApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTestProApplication.class, args);
    }

}
