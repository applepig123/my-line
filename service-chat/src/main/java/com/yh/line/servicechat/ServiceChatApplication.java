package com.yh.line.servicechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceChatApplication.class, args);
	}
}
