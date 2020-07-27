package com.electricity.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "payment")
public class Payment {
    
	@Id
	@GeneratedValue(generator = "payment-sequence-generator")
	@GenericGenerator(name = "payment-sequence-generator",
	                  strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	                  parameters = {
	                		  @Parameter(name= "sequence_name", value="payment_seq"),
	                		  @Parameter(name = "initial_value", value="10"),
	                		  @Parameter(name = "increment_size", value = "1"),
	                  })
	@Column(name = "payment_id")
	Long paymentId;
	
	@Column(name = "transaction_id")
	String transactionId;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "total_price")
	double totalPrice;
	
	@Column(name = "payment_amount")
	double paymentAmount;
	
	@Column(name = "payment_date")
	LocalDate paymentDate;
	
	@Column(name = "bill_month")
	String billMonth;
	
	@Column(name = "created_by")
	String createdBy;
	
	@Column(name = "modified_by")
	String modifiedBy;
	
	@Column(name = "created_on")
	LocalDate createdOn;
	
	@Column(name = "modified_on")
	LocalDate modifiedOn;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
