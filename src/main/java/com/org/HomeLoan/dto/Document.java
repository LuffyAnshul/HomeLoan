package com.org.HomeLoan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document {
	@Id
	@GeneratedValue
	private Integer docId;
	
	@Column(name="doc_Name")
	private String  docName;
	
	@Column(name="doc_Path")
	private String docPath;
	
	@ManyToOne()
	@JoinColumn(name="customer_id", nullable=false, insertable=false, updatable=false)
    private Customer customer;
	
	@Override
	public String toString() {
		return "Document [docId=" + docId + ", docName=" + docName + ", docPath=" + docPath + "]";
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
