package com.spring.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.mail.model.User;

/**
 * @author Rahul
 *
 */
@Service
public class MailServices {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailServices(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(User user) {
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(user.getEmailAddress());
			mail.setSubject("Testing mail api");
			mail.setText("Brawo! I have done it.");
			javaMailSender.send(mail);
		} catch (MailException e) {
			System.err.println("Exception occured : " + e.getMessage());
		}

	}

	public void sendEmailWithAttachment(User user) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(user.getEmailAddress());
			helper.setSubject("Testing mail api with the attachment");
			helper.setText("Please find the attachment below");

			ClassPathResource classPathResource = new ClassPathResource("RAHULSONI.pdf");
			helper.addAttachment(classPathResource.getFilename(), classPathResource);

			javaMailSender.send(message);

		} catch (MessagingException | MailException e) {

			System.err.println("Exception occured : " + e.getMessage());
		}
	}

}
