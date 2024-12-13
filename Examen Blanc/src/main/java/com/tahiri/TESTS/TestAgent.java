package com.tahiri.TESTS;

import com.tahiri.CLASSES.Agent;
import com.tahiri.CLASSES.Transaction;

import java.util.Date;

public class TestAgent {
    public static void main(String[] args) {
        // Création des agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        Agent agent3 = new Agent("Agent3");

        // Agent2 et Agent3 s'abonnent à Agent1
        agent1.souscrire(agent2);
        agent1.souscrire(agent3);

        // Création de transactions
        Transaction transaction1 = new Transaction.Builder()
                .setId("TXN001")
                .setDate(new Date())
                .setMontant(1000.50)
                .setType("Vente")
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .setId("TXN002")
                .setDate(new Date())
                .setMontant(500.75)
                .setType("Achat")
                .build();

        // Ajout des transactions à Agent1
        agent1.ajouterTransaction(transaction1);
        agent1.ajouterTransaction(transaction2);

        // Agent3 s'abonne à Agent2
        agent2.souscrire(agent3);

        // Agent2 ajoute une transaction
        Transaction transaction3 = new Transaction.Builder()
                .setId("TXN003")
                .setDate(new Date())
                .setMontant(250.00)
                .setType("Vente")
                .build();

        agent2.ajouterTransaction(transaction3);
    }
}
