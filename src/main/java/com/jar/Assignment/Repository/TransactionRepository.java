package com.jar.Assignment.Repository;

import com.jar.Assignment.DTO.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findByCreatedAt(Date createdAt);
}
