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
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(generator = "sequence-generator-complaint")
	@GenericGenerator(name = "sequence-generator-complaint",
	                  strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	                  parameters = {
	                		  @Parameter(name= "sequence_name", value="complaint_seq"),
	                		  @Parameter(name = "initial_value", value="10"),
	                		  @Parameter(name = "increment_size", value = "1"),
	                  })
    @Column(name = "complaint_id")
	Long complaintId;
	
    @Column(name="complaint_desc")
	String complaintDesc;
	
    @Column(name = "complaint_reply")
	String complaintReply;
	
    @Column(name = "complaint_status")
	String complaintStatus;
	
    @Column(name = "created_by")
	String createdBy;
	
    @Column(name = "modified_by")
	String modifiedBy;
	
    @Column(name = "created_on")
	LocalDate createdOn;
	
    @Column(name = "modified_on")
	LocalDate modifiedOn;
    
    @Column(name = "username")
    String username;

	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getComplaintReply() {
		return complaintReply;
	}

	public void setComplaintReply(String complaintReply) {
		this.complaintReply = complaintReply;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
