package com.componentprocessing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		log.error("Status code " + response.status() + ", methodKey = " + methodKey);
		String message = response.reason();

		switch (response.status()) {
		case 400: {
			log.error("Status code " + response.status() + ", methodKey = " + methodKey);
			if(methodKey.contains("completePayment"))
				message="Payment Failed";
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), message);
		}
		case 403: {
              if(methodKey.contains("validateToken"))
            	  message="Session Expired Please Login Back";
			log.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status()
					+ ", methodKey = " + methodKey);
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), message);
		}
		case 404: {

			log.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status()
					+ ", methodKey = " + methodKey);
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Page Not Found");
		}
		case 500: {
			log.error("Encountered problem using Feign Client Status code " + response.status() + ", method Key = "
					+ methodKey);
			throw new ResponseStatusException(HttpStatus.valueOf(response.status()), "Encountered Problem at FeignClient");

		}
		case 501:
		case 502:
		case 503:
		case 504: {
			log.error("Encountered problem using Feign Client Status code " + response.status() + ", method Key = "
					+ methodKey);
			throw new ResponseStatusException(HttpStatus.valueOf(response.status()), "Encountered Problem at FeignClient");

		}
		default:
			return new Exception(message);
		}
	}

}
