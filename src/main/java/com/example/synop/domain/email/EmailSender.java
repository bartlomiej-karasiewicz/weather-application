package com.example.synop.domain.email;

import org.springframework.mail.SimpleMailMessage;

public interface EmailSender {

    void sendMail(SimpleMailMessage simpleMailMessage);
}
