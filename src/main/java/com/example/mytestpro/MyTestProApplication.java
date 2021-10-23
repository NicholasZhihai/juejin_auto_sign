package com.example.mytestpro;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lizhihai
 * @date 2021/09/11
 * 开启定时任务，取消springdatasource加载
 */
@EnableApolloConfig
@EnableScheduling
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MyTestProApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTestProApplication.class, args);
    }

}
