package com.org.HomeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.HomeLoan.dto.Email;
import com.org.HomeLoan.service.EmailService;

@RestController
public class EmailController {
	@Autowired private EmailService emailService;
	 
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody Email details) {
        String status = emailService.sendSimpleMail(details);
 
        return status;
    }
 
    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody Email details)
    {
        String status = emailService.sendMailWithAttachment(details);
 
        return status;
    }
}
