package com.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.entity.CreditCardDetails;
import com.payments.repo.CreditRepo;

@Service
public class CreditCardsPaymentService {

	@Autowired
	private CreditRepo creditRepo;

	public boolean validateCredentialandLimit(Long cardNumber, int cvv, double amount) {

		Optional<CreditCardDetails> optccd = creditRepo.findById(cardNumber);
		if (optccd.isPresent()) {
			CreditCardDetails ccd = optccd.get();
			if (ccd.getCvv() == cvv && ccd.getCredit() > amount) {
				ccd.setCredit(ccd.getCredit() - amount);
				creditRepo.save(ccd);
				return true;
			}
		}
		return false;

	}

}
