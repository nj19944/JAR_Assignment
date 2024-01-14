package com.jar.Assignment.Service;

import com.jar.Assignment.DTO.Transaction;
import com.jar.Assignment.Repository.TransactionRepository;
import com.jar.Assignment.enums.CurrencyType;
import com.jar.Assignment.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    public List<Transaction> getTransaction()
    {
        List<Transaction> transactionList = transactionRepository.findByCreatedAt(new Date());
        List<Transaction> responseTransactionList=new ArrayList<>();

        //get INR TO USD conversion rate from Api
        double conversionRate = Utils.getINRConversionRate();

        transactionList.stream().forEach(res -> {
            if(res.getCurrencyType()!= CurrencyType.USD)
            {
                Double amountInUSD = res.getAmount()/conversionRate;
                Transaction newTransaction = Transaction.builder().transactionType(res.getTransactionType())
                        .currencyType(CurrencyType.USD).amount(amountInUSD).id(res.getId())
                        .createdAt(res.getCreatedAt()).build();
                responseTransactionList.add(newTransaction);
            }
            else
                responseTransactionList.add(res);
        }
         );

       return responseTransactionList;
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
