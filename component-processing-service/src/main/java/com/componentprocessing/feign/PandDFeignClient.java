package com.componentprocessing.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Component
@FeignClient(name="PACKAGE-AND-DELIVERY-MICROSERVICE")
public interface PandDFeignClient {

	@GetMapping("/GetPackagingDeliveryCharge")
	public ResponseEntity<Double> getPackagingDeliveryCharges(@RequestParam String componentType , @RequestParam int quantity);
}
