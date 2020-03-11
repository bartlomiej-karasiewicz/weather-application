package com.example.synop.config;

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

    private static final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SynopticFacade synopticFacade;

    @Scheduled(cron = "0 0 * * * *")
    public void report(){
        synopticFacade.createMultiSynoptic();
        log.info(dateFormat.format(new Date()));
    }
}
