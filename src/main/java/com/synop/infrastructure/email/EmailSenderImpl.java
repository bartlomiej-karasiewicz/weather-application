package com.synop.infrastructure.email;

import com.synop.domain.email.EmailSender;
import com.synop.domain.email.Receiver;
import com.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    @Value("${queue.name}")
    private String queueName;
    private final SynopticFacade synopticFacade;
    private final JavaMailSender javaMailSender;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendEmailContent(String receiver) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject("Weather report");

        simpleMailMessage.setText(report());
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public Receiver sendToQueque(String mailAddress) {
        Receiver receiver=new Receiver(mailAddress,report());
        rabbitTemplate.convertAndSend(queueName,receiver);
        return receiver;
    }

    private String report() {
        Double maxTemperature = synopticFacade.stationWithMaxTemperature().values().stream().findFirst().get();
        String stationWithMax = synopticFacade.stationWithMaxTemperature().keySet().stream().findFirst().get();

        Double minTemperature = synopticFacade.stationWithMinTemperature().values().stream().findFirst().get();
        String stationWithMin = synopticFacade.stationWithMinTemperature().keySet().stream().findFirst().get();

        StringBuilder message = new StringBuilder(LocalDate.now() + "\n")
                .append("Maximum temperature was: " + maxTemperature + " in station " + stationWithMax + ".\n")
                .append("Minimum temperature was: " + minTemperature + " in station " + stationWithMin + ".\n")
                .append("Pressure average was: " + synopticFacade.pressureAverage() + ".\n")
                .append("Wind speed was: " + synopticFacade.windSpeedAverage() + ".\n");

        return message.toString();
    }
}
