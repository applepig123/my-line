package com.yh.line.servicegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanghua on 2019/3/10.
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get").filters(f -> f.addRequestHeader("hello", "world")).uri(""))
//                .route("ws router", p -> p.path("lb://"))
                .build();
    }
}
