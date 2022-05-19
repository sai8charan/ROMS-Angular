package com.packaginganddelivery.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.packaginganddelivery.exception.InvalidInputDetailsException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PackageDeliveryCalculator {
	@Value("${packagecost.integral}")
	private double packagechargeintegral;
	@Value("${packagecost.accessory}")
	private double packagechargeaccessory;
	@Value("${deliverycharge.integral}")
	private double deliverychargeintegral;
	@Value("${deliverycharge.accessory}")
	private double deliverychargeaccessory;
	@Value("${sheatcost}")
	private double sheatcost;
	
	
	public double getPrice(String componentType, int quantity) throws Exception {
		
		double totalcharge;
		if(quantity<=0)
		{
			log.error("Ordered Quantity should be greater than 0");
			throw new InvalidInputDetailsException("Invalid input quantity "+quantity);
		}
		
		switch(componentType.toLowerCase()) {
		case "integral" : totalcharge= (packagechargeintegral+deliverychargeintegral+sheatcost)
				                        * quantity;
		break;
		case "accessory" : totalcharge= (packagechargeaccessory+deliverychargeaccessory+sheatcost)
                                        * quantity;
        break;
        default : {
        	log.error("Entered Component is not a valid type");
        	throw new InvalidInputDetailsException("Entered Invalid Component Type "+componentType);
        }
        }
		
		
		
		return totalcharge;
	}

}
