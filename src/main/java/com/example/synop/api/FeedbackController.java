package com.example.synop.api;

import com.example.synop.domain.email.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final EmailSender emailSender;

    @PostMapping
    public void sendFeedback() {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo("harry4over@googlemail.com");
        mailMessage.setSubject("Awesomeeeeeeeeee!");
        mailMessage.setText("Pozdrawiam!");
        emailSender.sendMail(mailMessage);
    }

}
