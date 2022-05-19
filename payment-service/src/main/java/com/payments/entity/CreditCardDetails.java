package com.payments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDetails {
	@Id
	@Column(nullable =false )
	private Long cardNumber;
	@Column(nullable =false )
	private int cvv;
	@Column(nullable =false )
	private double credit;

}
