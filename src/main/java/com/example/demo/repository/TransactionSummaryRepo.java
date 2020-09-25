package com.example.demo.repository;

import com.example.demo.entity.TransactionSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionSummaryRepo extends JpaRepository<TransactionSummary, Long> {
}
