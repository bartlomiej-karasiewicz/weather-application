package com.example.synop.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@Data
public class EmailConfig {

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String password;


    public void sendMail(SimpleMailMessage simpleMailMessage){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost(this.getHost());
        mailSender.setPort(Integer.valueOf(this.getPort()));
        mailSender.setUsername(this.getUserName());
        mailSender.setPassword(this.getPassword());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");

        mailSender.setJavaMailProperties(javaMailProperties);

        mailSender.send(simpleMailMessage);
    }
}
