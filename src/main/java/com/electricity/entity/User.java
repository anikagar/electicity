package com.electricity.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;

@Entity
@Scope("session")
@Table(name = "user_detail")
public class User {
	
	@Id
	@Column(name = "user_id")
	String userId;
	
	@Column(name = "first_name")
	@Size(min=2, max=50)
	String firstName;
	
	@Column(name = "last_name")
	@Size(min=2, max=50)
	String lastName;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "address")
	@Size(min=2)
	String address;
	
	@Column(name = "phone_number")
	@Digits(fraction = 0, integer = 10)
	String phoneNumber;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "created_by")
	String createdBy;
	
	@Column(name = "created_on")
	LocalDate createdOn;
	
	@Column(name = "modified_by")
	String modifiedBy;
	
	@Column(name = "modified_on")
	LocalDate modifiedOn;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
