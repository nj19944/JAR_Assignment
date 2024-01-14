package com.jar.Assignment.Controller;

import com.jar.Assignment.DTO.Transaction;
import com.jar.Assignment.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transaction")
    public List<Transaction> getTransaction()
    {
      return transactionService.getTransaction();
    }

    @PostMapping(value = "/transaction")
    public Transaction saveTransaction (@RequestBody Transaction transaction)
    {
        transaction.setCreatedAt(new Date());
        return transactionService.saveTransaction(transaction);
    }


}
