package com.example.synop.infrastructure.email;

import com.example.synop.domain.email.EmailSender;
import com.example.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    private final SynopticFacade synopticFacade;
    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmailContent() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("harry4over@googlemail.com");
        simpleMailMessage.setSubject("Weather report");

        simpleMailMessage.setText(report().toString());
        javaMailSender.send(simpleMailMessage);
    }

    private StringBuilder report() {
        Double maxTemperature = synopticFacade.stationWithMaxTemperature().values().stream().findFirst().get();
        String stationWithMax = synopticFacade.stationWithMaxTemperature().keySet().stream().findFirst().get();

        Double minTemperature = synopticFacade.stationWithMinTemperature().values().stream().findFirst().get();
        String stationWithMin = synopticFacade.stationWithMinTemperature().keySet().stream().findFirst().get();

        StringBuilder message = new StringBuilder(String.valueOf(LocalDate.now()) + "\n")
                .append("Maximum temperature was: " + maxTemperature + " in station " + stationWithMax + ".\n")
                .append("Minimum temperature was: " + minTemperature + " in station " + stationWithMin + ".\n")
                .append("Pressure average was: " + synopticFacade.pressureAverage() + ".\n")
                .append("Wind speed was: " + synopticFacade.windSpeedAverage() + ".\n");

        return message;
    }
}
