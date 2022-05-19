package com.payments.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.entity.CreditCardDetails;
@Repository
public interface CreditRepo extends JpaRepository<CreditCardDetails, Long> {
	

}
