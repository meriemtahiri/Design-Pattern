package com.tahiri.TESTS;

import com.tahiri.CLASSES.Transaction;

import java.time.LocalDate;

public class TestTransaction {
    public static void main(String[] args) {
        Transaction transaction = new Transaction.Builder()
                .id("T1")
                .date(LocalDate.now())
                .montant(500)
                .type(Transaction.TypeTransaction.VENTE)
                .build();

        System.out.println(transaction);
    }
}

