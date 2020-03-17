package com.example.synop.config.scheduler;

import com.example.synop.domain.email.EmailSender;
import com.example.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledTasks {

    private static final SimpleDateFormat DATE_FORMAT =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SynopticFacade synopticFacade;
    private final EmailSender emailSender;

    @Scheduled(cron = "0 */30 * ? * *")
    public void addAllSynopticParameters(){
        synopticFacade.addMultiSynopticData();
        log.info("Data was provided at "+ DATE_FORMAT.format(new Date()));
    }
    @Scheduled(cron = "0 0 */3 ? * *")
    public void sendMail(){
        emailSender.sendEmailContent();
        log.info("Mail was send at " + DATE_FORMAT.format(new Date()));
    }
}
