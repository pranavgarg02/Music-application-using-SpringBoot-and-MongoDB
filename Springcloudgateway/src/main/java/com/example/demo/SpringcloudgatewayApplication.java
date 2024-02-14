package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudgatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){ 
        return routeLocatorBuilder.routes() 
                        .route("Microservice1",r->r.path("/server/**") 
                                .uri("http://localhost:8081/")) 
                        .route("Microservice2",r->r.path("/user/**") 
                                .uri("http://localhost:8082/"))
                        .route("Microservice3",r->r.path("/songs/**")
                        		.uri("http://localhost:8084/")).build();
    } 

}
