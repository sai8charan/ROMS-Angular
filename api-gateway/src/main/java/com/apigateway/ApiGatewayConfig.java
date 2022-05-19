package com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		//${remaining}
//
//http://localhost:9005/COMPONENT-PROCESSING-MICROSERVICE/processdetail
//http://localhost:9005/COMPONENT-PROCESSING-MICROSERVICE/completeprocessing
		return builder.routes()
				      .route(p->p.path("/validate/**")
				    		  .filters(f->f.rewritePath("/validate/(?<remaining>.*)", "/AUTHORIZATION-SERVER/${remaining}"))
				                  .uri("lb://AUTHORIZATION-SERVER"))
				      .route(p->p.path("/authenticate/**")
				    		  .filters(f->f.rewritePath("/authenticate/(?<remaining>.*)", "/AUTHORIZATION-SERVER/${remaining}"))
				                  .uri("lb://AUTHORIZATION-SERVER"))
				      .route(p->p.path("/processdetail/**")
				    		  .filters(f->f.rewritePath("/processdetail/(?<remaining>.*)", "/COMPONENT-PROCESSING-MICROSERVICE/${remaining}"))
				                  .uri("lb://COMPONENT-PROCESSING-MICROSERVICE"))
				      .route(p->p.path("/completeprocessing/**")
				    		  .filters(f->f.rewritePath("/completeprocessing/(?<remaining>.*)", "/COMPONENT-PROCESSING-MICROSERVICE/${remaining}"))
				                  .uri("lb://COMPONENT-PROCESSING-MICROSERVICE")).build();
		
	}

}
