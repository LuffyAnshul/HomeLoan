package com.org.HomeLoan.dto;

//import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String email;

	private String password;

	private String phoneNo;

	private String dob;

	private String gender;

	private String nationality;

	private String aadharNo;

	private String panNo;
	
//	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private PropertyAndIncome propertyAndIncome;

	/* @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) */
//	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Loan loan;
//	
//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//	private List<Document> docs;
	
	public Customer() {

	}

	public Customer(Integer customerId, String firstName, String middleName, String lastName, String email, String password,
			String confirmPwd, String phoneNo, String dob, String gender, String nationality, String aadharNo,
			String panNo) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

//	public PropertyAndIncome getPropertyAndIncome() {
//		return propertyAndIncome;
//	}
//
//	public void setPropertyAndIncome(PropertyAndIncome propertyAndIncome) {
//		this.propertyAndIncome = propertyAndIncome;
//	}
//
//	public Loan getLoan() {
//		return loan;
//	}
//
//	public void setLoan(Loan loan) {
//		this.loan = loan;
//	}
//
//	public List<Document> getDocs() {
//		return docs;
//	}
//
//	public void setDocs(List<Document> docs) {
//		this.docs = docs;
//	}
	
}
