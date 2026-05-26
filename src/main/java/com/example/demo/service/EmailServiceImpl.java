package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Email;
import com.example.demo.exception.EmailServiceException;
import com.example.demo.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	EmailRepository emailRepository;

	@Autowired
	JavaMailSender mailSender;

	@Override
	public void saveInfo(Email email) {
		if (emailRepository.existsByEmail(email.getEmail())) {
			throw new EmailServiceException(
					"Your alredy submitted request , so please wait for some time.... sorry for inconveus",
					HttpStatus.BAD_REQUEST);
		} else {
			Email saveContact = emailRepository.save(email);
			sendThankYouMessage(saveContact);
			

		}

	}

	public void sendThankYouMessage(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getEmail());
		message.setSubject("Thank You For Connecting");
		message.setText("Hello " + email.getName() + ",\n\n" + "Thank you for connecting with Abhishek.\n"
				+ "We received your enquiry regarding: " + email.getReason() + ".\n\n"
				+ "Abhishek will contact you shortly.\n\n" + "Best Regards,\n" + "Abhishek Jadhav");

		
		mailSender.send(message);
	}

}
