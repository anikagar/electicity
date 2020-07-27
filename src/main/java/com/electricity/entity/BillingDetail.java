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
@Table(name = "billing_detail")
public class BillingDetail {
  
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator",
	                  strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	                  parameters = {
	                		  @Parameter(name= "sequence_name", value="billing_detail_seq"),
	                		  @Parameter(name = "initial_value", value="1"),
	                		  @Parameter(name = "increment_size", value = "1"),
	                  })
	@Column(name = "billing_detail_id")
	Long billingDetailId;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "previous_reading")
	Long previousReading;
	
	@Column(name = "current_reading")
	Long currentReading;
	
	@Column(name = "unit_consumed")
	Long unitConsumed;
	
	@Column(name = "price_per_unit")
	double pricePerUnit;
	
	@Column(name = "total_price")
	double totalPrice;
	
	@Column(name = "billing_date")
	LocalDate billingDate;
	
	@Column(name = "due_date")
	LocalDate dueDate;
	
	@Column(name = "bill_month")
	String billMonth;
	
	@Column(name = "bill_type")
	String billType;
	
	@Column(name = "created_by")
	String createdBy;
	
	@Column(name = "modified_by")
	String modifiedBy;
	
	@Column(name = "created_on")
	LocalDate createdOn;
	
	@Column(name = "modified_on")
	LocalDate modifiedOn;
	
	@Column(name = "payment_ind")
	String paymentInd;
	
	@Column(name = "bill_change_ind")
	String billChangeInd;

	public Long getBillingDetailId() {
		return billingDetailId;
	}

	public void setBillingDetailId(Long billingDetailId) {
		this.billingDetailId = billingDetailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getPreviousReading() {
		return previousReading;
	}

	public void setPreviousReading(Long previousReading) {
		this.previousReading = previousReading;
	}

	public Long getCurrentReading() {
		return currentReading;
	}

	public void setCurrentReading(Long currentReading) {
		this.currentReading = currentReading;
	}

	public Long getUnitConsumed() {
		return unitConsumed;
	}

	public void setUnitConsumed(Long unitConsumed) {
		this.unitConsumed = unitConsumed;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
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

	public String getPaymentInd() {
		return paymentInd;
	}

	public void setPaymentInd(String paymentInd) {
		this.paymentInd = paymentInd;
	}

	public String getBillChangeInd() {
		return billChangeInd;
	}

	public void setBillChangeInd(String billChangeInd) {
		this.billChangeInd = billChangeInd;
	}
	
	
}
