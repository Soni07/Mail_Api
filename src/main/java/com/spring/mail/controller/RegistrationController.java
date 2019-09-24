package com.spring.mail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mail.model.User;
import com.spring.mail.service.MailServices;

@RestController

public class RegistrationController {

	@Autowired
	private MailServices services;

	@Autowired
	private User user;

	public MailServices getServices() {
		return services;
	}

	public void setServices(MailServices services) {
		this.services = services;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@RequestMapping("send-mail")
	public String sendMain() {
		user.setEmailAddress("rahul.soni07071990@gmail.com");
		try {
			services.sendEmail(user);

		} catch (MailException e) {

			System.err.println("Error occured : " + e.getMessage() + "\t:\t" + e);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

		/*
		 * Creating a User with the help of User class that we have declared and setting
		 * Email address of the sender.
		 */
		user.setEmailAddress("rahul.soni07071990@gmail.com"); // Receiver's email address

		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
		 * that contains a attachment.
		 */
		try {
			services.sendEmailWithAttachment(user);
		} catch (MailException e) {
			System.out.println(e);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

}
