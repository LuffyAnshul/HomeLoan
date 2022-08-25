package com.org.HomeLoan.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	private String email;
	
	private String password;
	
	@ManyToOne()
	@JoinColumn(name="customer_id", nullable=false, insertable=false, updatable=false)
	@JsonBackReference
	private Customer customer;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}
	
}
