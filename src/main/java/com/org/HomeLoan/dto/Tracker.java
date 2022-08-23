package com.org.HomeLoan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tracker")
public class Tracker {
	@Id
	@Column(name="appid")
	private Integer appId;
	private Integer status;
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Tracker [appId=" + appId + ", status=" + status + "]";
	}
	
}
