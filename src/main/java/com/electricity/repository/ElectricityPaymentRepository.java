package com.electricity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.electricity.entity.Payment;

@Repository
public interface ElectricityPaymentRepository extends JpaRepository<Payment, Long> {

	@Query("select transactionId from Payment where transactionId=?1")
	public String checkTransactionId(String transactionId);
}
