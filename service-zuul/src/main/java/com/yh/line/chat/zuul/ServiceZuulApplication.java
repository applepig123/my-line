package com.yh.line.chat.zuul;

import com.yh.line.chat.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)",
				"$<version>/${name}"
		);
	}
}
