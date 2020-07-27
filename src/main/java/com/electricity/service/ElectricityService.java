package com.electricity.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.bo.ElectricityBo;
import com.electricity.entity.BillingDetail;
import com.electricity.entity.BillingRateDetail;
import com.electricity.entity.Complaint;
import com.electricity.entity.Payment;
import com.electricity.entity.User;
import com.electricity.exception.ElectricityException;
import com.electricity.repository.ElectricityBillingRateRepository;
import com.electricity.repository.ElectricityBillingRepository;
import com.electricity.repository.ElectricityComplaintRepository;
import com.electricity.repository.ElectricityPaymentRepository;
import com.electricity.repository.ElectricityUserRepository;

@Service
public class ElectricityService {
	
	@Autowired
	ElectricityUserRepository userRepo;
	
	@Autowired
	ElectricityBo elecbo;
	
	@Autowired
	ElectricityBillingRateRepository raterepo;
	
	@Autowired
	ElectricityBillingRepository billRepo;
	
	@Autowired
	ElectricityComplaintRepository complaintRepo;
	
	@Autowired
	ElectricityPaymentRepository paymentRepo;
			
	public void saveUser(User newUser) throws ElectricityException   {
		   System.out.println(newUser.getUsername());
		   newUser.setUserId(elecbo.setUserId(userRepo.getMaxId()));
		   userRepo.saveAndFlush(newUser);			
	}
	
	
	public String existsUsername(String username) {
		return userRepo.exists(username);
	}
	
	public void updatePassword(String userId, String password, String modifiedBy, LocalDate ModifiedOn) {
		userRepo.updatePassword(userId, password, modifiedBy, ModifiedOn);
		userRepo.flush();
	}
	
	public String getPassword(String userId) {
		return userRepo.getPassword(userId);
	}
	
	public List<BillingRateDetail> fetchBillingRateDetails() {
		return raterepo.fetchBillingRateDetails();
	}
	
	public void saveBillingRateDetails(BillingRateDetail billingRateDetail) {
		List<Long> idList = new ArrayList<Long>();
		idList = raterepo.fetchLatestBillingRateDetailId();
		Long id = elecbo.fetchIdFromList(idList);
		System.out.println(id);
		System.out.println(billingRateDetail.getBillingRateDetailId());
		if(id == null) {
			raterepo.save(billingRateDetail);
		} else {
			raterepo.updateEffectiveEndDate(id, "N", billingRateDetail.getModifiedBy(),  
					                        billingRateDetail.getModifiedOn());
			raterepo.save(billingRateDetail);
		}
		
		
	}
	
	public void generateBilling(BillingDetail billDetail, String username) {
		int payresult = 0;
		int billchangeresult = 1;
		LocalDate localDate = LocalDate.now();
		LocalDate dueDate = LocalDate.now();
		Long previousReading, unitConsumed;
		double perUnitPrice, totalPrice;
		String calculateBillMonth = null;
		/*Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, Integer.parseInt(raterepo.fetchDueDays().toString()));
		System.out.println(c.getTime());*/
		
		calculateBillMonth = elecbo.calculateBillMonth(billDetail.getBillMonth());		
		dueDate = dueDate.plusDays(raterepo.fetchDueDays());
		previousReading = billRepo.fetchPreviousCorrectedReading(billDetail.getUsername(), calculateBillMonth);
		if(previousReading == null) {
			previousReading = billRepo.fetchPreviousOriginalReading(billDetail.getUsername(), calculateBillMonth);
			if(previousReading == null) {
				previousReading = 0l;
			}
		}
		unitConsumed = billDetail.getCurrentReading() - previousReading;
		perUnitPrice = raterepo.fetchPerUnitPrice();
		totalPrice = perUnitPrice*unitConsumed;
		
		billDetail.setDueDate(dueDate);
		billDetail.setPricePerUnit(perUnitPrice);
		billDetail.setTotalPrice(totalPrice);
		billDetail.setPreviousReading(previousReading);
		billDetail.setUnitConsumed(unitConsumed);
		billDetail.setCreatedOn(localDate);
		billDetail.setModifiedOn(localDate);
        billDetail.setCreatedBy(username);
        billDetail.setModifiedBy(username);
		billDetail.setBillingDate(localDate);
		billDetail.setPaymentInd("N");
		billDetail.setBillChangeInd("N");
		
		if(billDetail.getBillType().equals("Corrected")) {
			payresult =  billRepo.updatePaymentInd(billDetail.getUsername(), billDetail.getBillMonth(), "Y", username, localDate);
		}
		if(payresult == 1) {
			billchangeresult = billRepo.updateBillChangeInd(billDetail.getUsername(), billDetail.getBillMonth(), "Y",
					                     username, localDate);
		}
		
		if(billchangeresult == 1) {
			billRepo.saveAndFlush(billDetail);	 
		} else {
			throw new ElectricityException("Error in generating billing");
		}
		
		
	}
	
	public List<String> fetchAllUsername(){
		return userRepo.fetchAllUsername();
	}
	
	public List<BillingDetail> fetchElectricityBill(String username){
		return billRepo.fetchElectricityBill(username);
	}
	
	public Complaint registerComplaint(Complaint complaint) {
		return complaintRepo.saveAndFlush(complaint);
	}
	
	public List<Complaint> fetchAllRecord() {
		return complaintRepo.fetchAllRecord();
	}
	
	public int updateComplaintReply(Long complaintId, String complaintReply, String complaintStatus, String modifiedBy, LocalDate modifiedOn) {
		return complaintRepo.updateComplaintFromAdmin(complaintId, complaintReply, complaintStatus, modifiedBy, modifiedOn);
		
	}
	
	public List<Complaint> fetchResolvedRecord(String username){
		return complaintRepo.fetchResolvedRecord(username);
	}
	
	public int updateComplaintReplyFromUser(Long complaintId, String complaintDesc, String complaintStatus, String modifiedBy, LocalDate modifiedOn) {
		return complaintRepo.updateComplaintFromUser(complaintId, complaintDesc, complaintStatus, modifiedBy, modifiedOn);
		
	}
	
	public Payment applyPayment(Payment payment) {
		Payment pay = null;
		String transactionId = null;
		String transId = null;
		transactionId = elecbo.calculateTransactionId();
		transId = paymentRepo.checkTransactionId(transactionId);
		while(transId != null) {
			transactionId = elecbo.calculateTransactionId();
			transId = paymentRepo.checkTransactionId(transactionId);
		}
		payment.setTransactionId(transactionId);
		int result = billRepo.updatePaymentInd(payment.getUsername(), payment.getBillMonth(), "Y", 
				                               payment.getModifiedBy(), payment.getModifiedOn());
		
		if(result > 0) {
			pay = paymentRepo.saveAndFlush(payment);
		}
		return pay;
	}
	
	public List<String> fetchBillMonthPaymentPending(String username){
		return billRepo.fetchBillMonthPaymentPending(username);
	}
	
	public BillingDetail fetchBillingDetailForPayment(String billMonth, String username) {
		return billRepo.fetchBillingDetailForPayment(billMonth, username);
	}
	
	public List<BillingDetail> fetchReport(String reportType, String billMonth){
		List<BillingDetail> userpaylist = null;
		if(reportType.equals("PR")) {
			userpaylist = billRepo.fetchPaymentReceived(billMonth);
		} else if(reportType.equals("PP")) {
			userpaylist = billRepo.fetchPaymentNotReceived(billMonth);
		}
		return userpaylist;
	}

}
