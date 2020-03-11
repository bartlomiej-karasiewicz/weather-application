package com.example.synop.api;

import com.example.synop.config.EmailConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final EmailConfig emailConfig;

    @PostMapping
    public void sendFeedback() {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo("harry4over@googlemail.com");
        mailMessage.setSubject("Awesomeeeeeeeeee!");
        mailMessage.setText("Pozdrawiam!");

        emailConfig.sendMail(mailMessage);
    }

}
