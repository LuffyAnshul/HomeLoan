package com.org.HomeLoan.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Double interestRate = 8.50;

	@NotNull(message = "Tenure is mandatory.! ")
	@Min(3) @Max(72)
	@Column(name = "tenure")
	private Integer tenure;

	@NotNull(message = "Loan Amount is mandatory.! ")
	@Column(name = "loan_amount")
	private Long loanAmount;

	@ManyToOne()
	@JoinColumn(name="customer_id", nullable=false, insertable=false, updatable=false)
    private Customer customer;
	
//	@OneToOne(mappedBy="loan", cascade = CascadeType.ALL)
//	@JoinColumn(name="loan_id",nullable=false, insertable = true, updatable = true)
//	private PropertyAndIncome propertyAndIncome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="loan_id",nullable=false)
	private List<PropertyAndIncome> propertyAndIncome = new ArrayList<>() ;
	
	public Loan() {
		
	}

	public Loan(Long loanId, Double maxLoanGrant, Double interestRate, Integer tenure, Long loanAmount) {
		super();
		this.loanId = loanId;
		this.maxLoanGrant = maxLoanGrant;
		this.interestRate = 8.50;
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
	
	

//	public PropertyAndIncome getPropertyAndIncome() {
//		return propertyAndIncome;
//	}
//
//	public void setPropertyAndIncome(PropertyAndIncome propertyAndIncome) {
//		this.propertyAndIncome = propertyAndIncome;
//	}
	
}
