package com.demo.springDockerDemo.routers;

import com.demo.springDockerDemo.handlers.SpringDockerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;


@Slf4j
@Component
public class SpringDockerRouter {

    private SpringDockerHandler handler;

    @Autowired
    public SpringDockerRouter(SpringDockerHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<?> initCustomRoutes(){
        System.out.println("Inside ******************");
        return RouterFunctions
                .route(RequestPredicates.POST("/products/addProduct"),
                        handler::addProduct)
                .andRoute(RequestPredicates.GET("/products/getProducts"),
                        handler::getProducts);


    }
}
