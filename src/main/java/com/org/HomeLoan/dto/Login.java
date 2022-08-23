package com.org.HomeLoan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(name = "LOGIN_GEN", sequenceName = "login_id_seq")
	private Integer userId;
	
	@NotNull(message="Username required")
	@Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message="Invalid Email format")
	private String username;
	
	@NotNull(message="Password required")
	private String password;
	
	@NotNull(message="Role required")
	private String role;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
