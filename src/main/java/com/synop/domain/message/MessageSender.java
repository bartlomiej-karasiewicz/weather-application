package com.synop.domain.message;

public interface MessageSender {

    Receiver sendToQueue(String mailAddress);
}
