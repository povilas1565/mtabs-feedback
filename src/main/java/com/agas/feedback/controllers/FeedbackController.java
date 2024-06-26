package com.agas.feedback.controllers;

import com.agas.feedback.models.Feedback;
import com.agas.feedback.services.EmailConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@Slf4j
@RequestMapping("/")
@Api
@CrossOrigin
public class FeedbackController {

    @Autowired
    private EmailConfig emailConfig;

    @PostMapping(value = "/feedback", produces = "application/json;charset=UTF-8")
    @ApiOperation("Создание и отправка формы обратной связи на админскую почту")
    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Feedback is not valid");
        }

        // Create mail sender

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        // Create mailform instance

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("agoramas.office@gmail.com");
        mailMessage.setSubject("New feedback from " + feedback.getName() + feedback.getTel());

        // Send mail
        mailSender.send(mailMessage);
    }
}
