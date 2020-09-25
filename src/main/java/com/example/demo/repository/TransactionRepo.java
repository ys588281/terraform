package com.example.demo.repository;

import com.example.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transactions WHERE createdAt BETWEEN :startTime AND :endTime", nativeQuery = true)
    public List<Transaction> getAllBetweenTimes(@Param("startTime") LocalDateTime startDate, @Param("endTime")LocalDateTime endDate);
}
