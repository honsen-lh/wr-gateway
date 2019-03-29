package leaderment.com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//spring-boot 启动注解
public class GatewayApplication {
	
	
	/*@Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/wr/**")
                        .filters(f -> f.stripPrefix(2)
                                .filter(new AuthorizationFilter())
                                .addResponseHeader("hello", "world"))
                        .uri("lb://warranty-service")
                        .order(0)
                        .id("warranty-service")
                )
                .build();
    }*/
	
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
   
}