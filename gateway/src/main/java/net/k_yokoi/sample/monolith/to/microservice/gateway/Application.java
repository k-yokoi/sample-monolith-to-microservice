package net.k_yokoi.sample.monolith.to.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.RewriteLocationResponseHeaderGatewayFilterFactory.StripVersion;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/**")
                        .filters(f -> f.rewriteLocationResponseHeader("AS_IN_REQUEST", "Location", "localhost:8080", "http"))
                        .uri("http://localhost:8081")
                )
                .build();

    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
