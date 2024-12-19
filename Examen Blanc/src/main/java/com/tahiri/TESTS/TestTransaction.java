package com.tahiri.TESTS;

import com.tahiri.CLASSES.Transaction;
import com.tahiri.CLASSES.Transaction.TypeTransaction;

import java.time.LocalDate;

public class TestTransaction {
    public static void main(String[] args) {
        // Création d'une transaction avec le Builder
        Transaction transaction = new Transaction.Builder()
                .id("T1")
                .date(LocalDate.now())
                .montant(500)
                .type(TypeTransaction.VENTE)
                .build();

        // Affichage des informations de la transaction
        System.out.println("Transaction créée :");
        System.out.println(transaction);

        // Test du getter
        System.out.println("ID de la transaction : " + transaction.getId());
        System.out.println("Date de la transaction : " + transaction.getDate());
        System.out.println("Montant de la transaction : " + transaction.getMontant());
        System.out.println("Type de la transaction : " + transaction.getType());

        // Test du setter pour le montant
        transaction.setMontant(700);  // Modification du montant
        System.out.println("Montant modifié de la transaction : " + transaction.getMontant());

        // Affichage final
        System.out.println("Transaction après modification :");
        System.out.println(transaction);
    }
}
