package com.example.demo.schedule;

import com.example.demo.service.AggregateService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AggregateJob {

    private AggregateService aggregateService;

    @Scheduled(cron = "${review-task.confirm-cron}")
    public void confirmReviewStatus() {
        try {
            aggregateService.aggregateTransaction();
        } catch (Exception e) {

        }
    }

}
