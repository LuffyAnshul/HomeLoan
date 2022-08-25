package com.org.HomeLoan.service;

import com.org.HomeLoan.dto.Email;

public interface EmailService {
	 // Method
    // To send a simple email
    String sendSimpleMail(Email details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(Email details);
}
