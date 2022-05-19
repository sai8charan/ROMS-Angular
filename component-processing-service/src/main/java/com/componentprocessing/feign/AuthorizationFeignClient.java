package com.componentprocessing.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
@Component
@FeignClient(name="AUTHORIZATION-SERVER")
public interface AuthorizationFeignClient {


	@GetMapping("/validate")
	 public boolean validateToken(@RequestHeader(value="Authorization") String token);
	
}
