package com.componentprocessing.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.componentprocessing.model.PaymentRequest;
@Component
@FeignClient(name="PAYMENTS-MICROSERVICE")
public interface PaymentServiceFeignClient {

	@PostMapping("/completepayment")
	public ResponseEntity<String> completePayment(@RequestBody PaymentRequest paymentRequest);

}
