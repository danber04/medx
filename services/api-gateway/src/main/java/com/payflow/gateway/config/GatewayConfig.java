package com.payflow.gateway.config;

import com.payflow.gateway.constant.GatewayConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private static final Logger log = LoggerFactory.getLogger(GatewayConfig.class);

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()

            /*
             * user-service
             * Public:  POST /api/v1/users/register
             *          POST /api/v1/users/login
             *          and so on.
             * Private: everything else under /api/v1/users/**
             */
            .route(GatewayConstant.ROUTE_USER_SERVICE, r -> r
                .path(GatewayConstant.USER_PATH)
                .filters(f -> f
                    //.filters()
                    .addRequestHeader(GatewayConstant.GATEWAY_SOURCE_HEADER, GatewayConstant.GATEWAY_SOURCE_VALUE)
                    // .circuitBreaker()
                    // .retry()
                    // .requestRateLimiter()
                ).uri(GatewayConstant.SVC_USER)
            )
            .build();
    }
}
