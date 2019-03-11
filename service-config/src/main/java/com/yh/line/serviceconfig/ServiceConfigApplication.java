package com.yh.line.serviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by yanghua on 2019/3/10.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ServiceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigApplication.class, args);
    }
}
