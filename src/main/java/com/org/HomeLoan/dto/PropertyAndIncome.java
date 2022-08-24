package com.org.HomeLoan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "property")
public class PropertyAndIncome {

	@Id
	@GeneratedValue
	private Long piId;

	@Column(name = "property_loc")
	private String propertyLoc;

	@Column(name = "property_name")
	private String propertyName;

	@Column(name = "estimated_amt")
	private Long propertyEstimatedAmount;

	@Column(name = "type_of_emp")
	private String typeOfEmployment;

	@Column(name = "ret_age")
	private Integer retirementAge;

	@Column(name = "org_type")
	private String orgType;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "income")
	private Long income;
	
//	@OneToOne(mappedBy="loan_id")
//    private Loan loan;
	
	@ManyToOne()
	@JoinColumn(name="loan_id", nullable=false, insertable=false, updatable=false)
    private Loan loan;
	
	public PropertyAndIncome() {
		
	}

	public PropertyAndIncome(Long piId, String propertyLoc, String propertyName, Long propertyEstimatedAmount,
			String typeOfEmployment, Integer retirementAge, String orgType, String employerName, Long income) {
		super();
		this.piId = piId;
		this.propertyLoc = propertyLoc;
		this.propertyName = propertyName;
		this.propertyEstimatedAmount = propertyEstimatedAmount;
		this.typeOfEmployment = typeOfEmployment;
		this.retirementAge = retirementAge;
		this.orgType = orgType;
		this.employerName = employerName;
		this.income = income;
	}

	public Long getPiId() {
		return piId;
	}

	public void setPiId(Long piId) {
		this.piId = piId;
	}

	public String getPropertyLoc() {
		return propertyLoc;
	}

	public void setPropertyLoc(String propertyLoc) {
		this.propertyLoc = propertyLoc;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Long getPropertyEstimatedAmount() {
		return propertyEstimatedAmount;
	}

	public void setPropertyEstimatedAmount(Long propertyEstimatedAmount) {
		this.propertyEstimatedAmount = propertyEstimatedAmount;
	}

	public String getTypeOfEmployment() {
		return typeOfEmployment;
	}

	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}

	public Integer getRetirementAge() {
		return retirementAge;
	}

	public void setRetirementAge(Integer retirementAge) {
		this.retirementAge = retirementAge;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}
