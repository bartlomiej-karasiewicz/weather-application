package com.synop.config.scheduler;

import com.synop.domain.message.MessageSender;
import com.synop.domain.synoptic.SynopticFacade;
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
    private final MessageSender messageSender;

    @Scheduled(cron = "0 0 */4 ? * *")
    public void addAllSynopticParameters(){
        synopticFacade.addMultiSynopticData();
        log.info("Data was provided at "+ DATE_FORMAT.format(new Date()));
    }
    @Scheduled(cron = "0 0 */12 ? * *")
    public void sendMail(){
        messageSender.sendToQueue("harry4over@gmail.com");
        log.info("Mail was send at " + DATE_FORMAT.format(new Date()));
    }
}
