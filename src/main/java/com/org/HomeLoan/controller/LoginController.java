package com.org.HomeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.HomeLoan.dto.Login;
import com.org.HomeLoan.service.LoginService;

@RestController
@RequestMapping(value = "/auth")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		return loginService.login(login);
	}
	
	@PostMapping("/logout/{id}")
	public String logout(@PathVariable int id) {
		return loginService.logout(id);
	}
}
