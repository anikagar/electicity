package com.electricity.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "billing_rate_detail")
public class BillingRateDetail {
	
	@Id
	@SequenceGenerator(name = "billing-rate-sequence-generator", sequenceName = "billing_rate_detail_seq",
	                   initialValue = 10, allocationSize = 1)
	@GeneratedValue(generator = "billing-rate-sequence-generator")
	@Column(name = "billing_rate_detail_id")
	Long billingRateDetailId;
	
	@Column(name = "price_per_unit")
	double pricePerUnit;
	
	@Column(name = "due_days")
	Long dueDays;
	
	@Column(name = "current_ind")
	String currentInd;
	
	@Column(name = "created_by")
	String createdBy;
	
	@Column(name = "created_on")
	LocalDate createdOn;
	
	@Column(name = "modified_by")
	String modifiedBy;
	
	@Column(name = "modified_on")
	LocalDate modifiedOn;

	public Long getBillingRateDetailId() {
		return billingRateDetailId;
	}

	public void setBillingRateDetailId(Long billingRateDetailId) {
		this.billingRateDetailId = billingRateDetailId;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Long getDueDays() {
		return dueDays;
	}

	public void setDueDays(Long dueDays) {
		this.dueDays = dueDays;
	}

	
	public String getCurrentInd() {
		return currentInd;
	}

	public void setCurrentInd(String currentInd) {
		this.currentInd = currentInd;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
