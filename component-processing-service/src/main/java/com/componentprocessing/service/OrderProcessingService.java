package com.componentprocessing.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.componentprocessing.exception.InvalidRequestDetails;
import com.componentprocessing.feign.PandDFeignClient;
import com.componentprocessing.model.ProcessRequest;
import com.componentprocessing.model.ProcessResponse;
import com.componentprocessing.pojo.RepairProcessService;
import com.componentprocessing.pojo.ReplacementProcessService;
import com.componentprocessing.pojo.Service;
import com.componentprocessing.repository.ProcessRequestRepository;
import com.componentprocessing.repository.ProcessResponseRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
@Data
public class OrderProcessingService {

	@Autowired
	ProcessRequestRepository requestRepository;
	@Autowired
	ProcessResponseRepository responseRepository;
	@Autowired
	private RepairProcessService repairProcessService;
	@Autowired
	private ReplacementProcessService replacementProcessService;
	@Autowired
	private PandDFeignClient pdfeignClient;

	public ProcessResponse processOrder(ProcessRequest processRequest) {
		Service processService;
		Date deliveryDate = new Date();
		Calendar calender = Calendar.getInstance();
		if (processRequest.getQuantity() <= 0) {
			log.warn("Quantity should be greater than 0");
			throw new InvalidRequestDetails("Invalid Quantity");
		}
		switch (processRequest.getComponentType().toLowerCase()) {
		case "integral":
			processService = repairProcessService;
			break;
		case "accessory":
			processService = replacementProcessService;
			break;
		default:
			log.warn("Entered invalid Component type");
			throw new InvalidRequestDetails("Invalid Component");

		}

		
		calender.setTime(deliveryDate);
		calender.add(Calendar.DATE, processService.getProcessingDays());
		deliveryDate = calender.getTime();

		processRequest = requestRepository.save(processRequest);
		log.debug("order request is saved");
		log.info("Fetching package and shipping charges from PandD Feign Client");

		double panddcharges = pdfeignClient
				.getPackagingDeliveryCharges(processRequest.getComponentType(), processRequest.getQuantity()).getBody();
		log.info("Fetching package and shipping charges from PandD Feign Client");
		ProcessResponse processResponse = new ProcessResponse(processRequest.getRequestId(),
				processRequest.getQuantity() * processService.getProcessingAmount(), panddcharges, deliveryDate);

		responseRepository.save(processResponse);
		log.debug("Stored the order Response");

		return processResponse;

	}

}
