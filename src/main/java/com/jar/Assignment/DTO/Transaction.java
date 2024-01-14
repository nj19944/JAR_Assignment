package com.jar.Assignment.DTO;

import com.jar.Assignment.enums.CurrencyType;
import com.jar.Assignment.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @NonNull
    @Column(name="amount")
    private Double amount;


    @NonNull
    @Column(name="createdAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;


    @NonNull
    @Column(name="transactionType")
    private TransactionType transactionType;


    @NonNull
    @Column(name="currencyType")
    private CurrencyType currencyType;

}
