package com.example.demo.service;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.TransactionSummary;
import com.example.demo.repository.TransactionRepo;
import com.example.demo.repository.TransactionSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AggregateService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private TransactionSummaryRepo transactionSummaryRepo;

    public void aggregateTransaction() {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(1L);
        List<Transaction> transactionList = transactionRepo.getAllBetweenTimes(startTime, endTime);
        Long total = 0L;
        for (Transaction t : transactionList) {
            total += t.getAmount();
        }
        LocalDateTime now = LocalDateTime.now();
        TransactionSummary summary = new TransactionSummary();
        summary.setAmount(total);
        summary.setCreatedAt(now);
        summary.setUpdatedAt(now);
        transactionSummaryRepo.save(summary);
    }

}
