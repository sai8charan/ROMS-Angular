package com.componentprocessing.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProcessRequest {
	@Id
	@GeneratedValue()	
	private UUID requestId;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String contactNumber;
	@Column(nullable = false)
	private String componentType;
	@Column(nullable = false)
	private String componentName;
	@Column(nullable = false)
	private int quantity;
	public ProcessRequest(String userName, String contactNumber, String componentType, String componentName,
			int quantity) {
		super();
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.componentType = componentType;
		this.componentName = componentName;
		this.quantity = quantity;
	}


}
