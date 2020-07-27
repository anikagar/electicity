package com.electricity.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.electricity.entity.BillingDetail;

@Repository
public interface ElectricityBillingRepository extends JpaRepository<BillingDetail, Long> {

	@Query("select bd.currentReading from BillingDetail bd where username=?1 and billMonth=?2 and billType = 'Corrected' and rownum = 1 order by bd.billingDetailId desc")
	public Long fetchPreviousCorrectedReading(String username, String billMonth);
	
	@Query("select bd.currentReading from BillingDetail bd where username=?1 and billMonth=?2 and billType = 'Original' and rownum = 1 order by bd.billingDetailId desc")
	public Long fetchPreviousOriginalReading(String username, String billMonth);
	
	@Query("select bd from BillingDetail bd where username=?1 and paymentInd = 'N'")
	public List<BillingDetail> fetchElectricityBill(String username);

	
	@Transactional
	@Modifying
	@Query("update BillingDetail set paymentInd=?3, modifiedBy=?4, modifiedOn=?5 where username=?1 and billMonth=?2 and billChangeInd='N'")
	public int updatePaymentInd(String username, String billMonth, String paymentInd, String modifiedBy,LocalDate modifiedOn);
	
	@Query("select billMonth from BillingDetail  where username=?1 and paymentInd = 'N'")
	public List<String> fetchBillMonthPaymentPending(String username);
	
	@Query("select bd from BillingDetail bd where bd.billMonth=?1 and bd.paymentInd = 'N' and bd.username=?2")
	public BillingDetail fetchBillingDetailForPayment(String billMonth, String username);
	
	@Query("select bd from BillingDetail bd where bd.billMonth=?1 and bd.paymentInd = 'Y' and bd.billChangeInd = 'N'")
	public List<BillingDetail> fetchPaymentReceived(String billMonth);
	
	@Query("select bd from BillingDetail bd where bd.billMonth=?1 and bd.paymentInd = 'N'")
	public List<BillingDetail> fetchPaymentNotReceived(String billMonth);
	
	@Transactional
	@Modifying
	@Query("update BillingDetail set billChangeInd=?3, modifiedBy=?4, modifiedOn=?5 where username=?1 and billMonth=?2 and billChangeInd='N'")
	public int updateBillChangeInd(String username, String billMonth, String billChangeInd, String modifiedBy,
			                       LocalDate modifiedOn);
}
