package com.tech.kridha.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public void test(String name, String to, String jobId, MultipartFile resume, String phone) {
		String[] recipients = { "vangarajesh6@gmail.com", "pravalikagaddameedi@gmail.com" };

		// Submit email tasks without waiting for their completion
		for (String recipient : recipients) {
			sendEmailAsyncFile(name, recipient, jobId + "Phone : " + phone, resume);
		}
	}

	@Async
	public CompletableFuture<Void> sendEmailAsyncFile(String name, String to, String jobId, MultipartFile resume) {
		return CompletableFuture.runAsync(() -> {
			sendConfirmationEmail(name, "vangarajesh6@gmail.com", jobId, resume);
			sendConfirmationEmail(name, "pravalikagaddameedi@gmail.com", jobId, resume);
		}, executorService);
	}

	void sendConfirmationEmail(String name, String to, String jobId, MultipartFile resume) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(to);
			helper.setSubject("Application Received for Job ID: " + jobId);
			helper.setText(
					String.format("Thank you for applying for the position. Our team will be in touch with you soon."));

			// Attach the resume file
			if (resume != null && !resume.isEmpty()) {
				InputStreamResource attachment = new InputStreamResource(resume.getInputStream());
				helper.addAttachment(resume.getOriginalFilename(), attachment, resume.getContentType());
			} else {
				System.out.println("Resume is empty");
			}

			javaMailSender.send(message);

		} catch (Exception e) {
			throw new RuntimeException("Failed to send email.", e);
		}
	}
}
