package com.tech.kridha.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	private final JavaMailSender javaMailSender;
	private final ExecutorService executorService;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		this.executorService = Executors.newFixedThreadPool(5); // Adjust thread pool size as needed
	}

	public void sendEmailForm(String name, String email, String phone) {
		String subject = "An Inquiry was received by Kridha Technologies from " + name;

		// Define email recipients
		String[] recipients = { "vangarajesh6@gmail.com", "pravalikagaddameedi@gmail.com" };

		// Submit email tasks without waiting for their completion
		for (String recipient : recipients) {
			sendEmailAsync(recipient, subject, name, email, phone);
		}
	}

	@Async
	public CompletableFuture<Void> sendEmailAsync(String to, String subject, String name, String email, String phone) {
		return CompletableFuture.runAsync(() -> {
			try {
				sendHtmlEmail(to, subject, name, email, phone);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}, executorService);
	}

	private void sendHtmlEmail(String to, String subject, String name, String email, String phone)
			throws MessagingException {
		String htmlContent = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Contact Details</title>\n" + "    <style>\n" + "        body {\n"
				+ "            font-family: Arial, sans-serif;\n" + "            line-height: 1.6;\n"
				+ "            color: #333;\n" + "            padding: 20px;\n" + "        }\n"
				+ "        .container {\n" + "            max-width: 600px;\n" + "            margin: auto;\n"
				+ "            border: 1px solid #ddd;\n" + "            padding: 20px;\n"
				+ "            border-radius: 8px;\n" + "        }\n" + "        h1 {\n"
				+ "            color: #007bff;\n" + "        }\n" + "        .details {\n"
				+ "            margin-top: 20px;\n" + "        }\n" + "        .details p {\n"
				+ "            margin: 8px 0;\n" + "        }\n" + "    </style>\n" + "</head>\n" + "<body>\n"
				+ "    <div class=\"container\">\n" + "        <h1>Contact Details Received</h1>\n"
				+ "        <div class=\"details\">\n" + "            <p><strong>Name:</strong> " + name + "</p>\n"
				+ "            <p><strong>Email:</strong> " + email + "</p>\n"
				+ "            <p><strong>Phone:</strong> " + phone + "</p>\n" + "        </div>\n"
				+ "        <p>Reach out to them for a better future. Remember, hard work is the key to unlocking your full potential and creating the future you desire.</p>\n"
				+ "    </div>\n" + "</body>\n" + "</html>";

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		messageHelper.setTo(to);
		messageHelper.setSubject(subject);
		messageHelper.setText(htmlContent, true); // Set to true to send as HTML

		javaMailSender.send(mimeMessage);
	}

	public void sendEmailForm(String name, String email, String phone, String subject, String message) {
		String[] recipients = { "vangarajesh6@gmail.com", "pravalikagaddameedi@gmail.com" };
		subject = "New Contact Query: " + subject;

		// Submit email tasks without waiting for their completion
		for (String recipient : recipients) {
			sendEmailAsync(recipient, subject, name, email, phone);
		}
	}
}
