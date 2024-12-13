package com.tahiri.TESTS;

import com.tahiri.CLASSES.Transaction;
import com.tahiri.CLASSES.Type;

import java.util.Date;

public class TestTransaction {
    public static void main(String[] args) {
        Transaction transaction = new Transaction.Builder()
                .setId("TXN12345")
                .setDate(new Date())
                .setMontant(500.75)
                .setType(String.valueOf(Type.Vente))
                .build();

        System.out.println(transaction);

        try {
            Transaction transactionInvalide = new Transaction.Builder()
                    .setId("TXN67890")
                    .setDate(new Date())
                    .setMontant(300.50)
                    .setType("Echange") // Type invalide
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
