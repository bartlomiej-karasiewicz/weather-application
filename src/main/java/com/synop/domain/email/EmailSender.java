package com.synop.domain.email;

public interface EmailSender {

    void sendEmailContent(String receiver);
    Receiver sendToQueque(String mailAddress);
}
