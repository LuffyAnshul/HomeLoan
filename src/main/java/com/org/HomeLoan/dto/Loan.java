package com.org.HomeLoan.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue
	private Long loanId;

	@NotNull(message = "Maximum Loan Grant is mandatory.! ")
	@Column(name = "max_loan_grant")
	private Double maxLoanGrant;

	@Column(name = "interest_rate ")
	private Double interestRate = 12.0;

	@NotNull(message = "Tenure is mandatory.! ")
	@Min(3) @Max(72)
	@Column(name = "tenure")
	private Integer tenure;

	@NotNull(message = "Loan Amount is mandatory.! ")
	@Column(name = "loan_amount")
	private Long loanAmount;

	@ManyToOne()
	@JoinColumn(name="customer_id", nullable=false, insertable=false, updatable=false)
	@JsonBackReference
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="loan_id",nullable=false)
	@JsonManagedReference
	private List<PropertyAndIncome> propertyAndIncome = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="loan_id",nullable=false)
	@JsonManagedReference
	private List<LoanRepayment> loanRepayment = new ArrayList<>();
	
	public Loan() {
		
	}

	public Loan(Long loanId, Double maxLoanGrant, Double interestRate, Integer tenure, Long loanAmount) {
		super();
		this.loanId = loanId;
		this.maxLoanGrant = maxLoanGrant;
		this.interestRate = 12.0;
		this.tenure = tenure;
		this.loanAmount = loanAmount;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", maxLoanGrant=" + maxLoanGrant + ", interestRate=" + interestRate
				+ ", tenure=" + tenure + ", loanAmount=" + loanAmount + "]";
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Double getMaxLoanGrant() {
		return maxLoanGrant;
	}

	public void setMaxLoanGrant(Double maxLoanGrant) {
		this.maxLoanGrant = maxLoanGrant;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<PropertyAndIncome> getPropertyAndIncome() {
		return propertyAndIncome;
	}

	public void setPropertyAndIncome(List<PropertyAndIncome> propertyAndIncome) {
		this.propertyAndIncome = propertyAndIncome;
	}
	
	public List<LoanRepayment> getLoanRepayment() {
		return loanRepayment;
	}

	public void setLoanRepayment(List<LoanRepayment> loanRepayment) {
		this.loanRepayment = loanRepayment;
	}
}
