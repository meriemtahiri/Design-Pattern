package com.tahiri.TESTS;

import com.tahiri.CLASSES.Agent;
import com.tahiri.CLASSES.Transaction;
import com.tahiri.CLASSES.Transaction.TypeTransaction;
import com.tahiri.INTERFACES.NotificationStrategy;
import com.tahiri.INTERFACES.DefaultStrategy;

import java.time.LocalDate;

public class TestAgent {
    public static void main(String[] args) {
        // Création de quelques agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        Agent agent3 = new Agent("Agent3");

        // Inscription des agents comme observateurs
        agent1.subscribe(agent2);  // Agent2 observe Agent1
        agent1.subscribe(agent3);  // Agent3 observe Agent1

        // Création de transactions
        Transaction transaction1 = new Transaction.Builder()
                .id("T1")
                .date(LocalDate.now())
                .montant(1000)
                .type(TypeTransaction.VENTE)
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .id("T2")
                .date(LocalDate.now())
                .montant(500)
                .type(TypeTransaction.ACHAT)
                .build();

        // Ajouter une transaction à agent1
        agent1.addTransaction(transaction1);

        // Ajouter une autre transaction à agent1
        agent1.addTransaction(transaction2);

        // Changer la stratégie de traitement des notifications de agent2
        NotificationStrategy newStrategy = new DefaultStrategy();
        agent2.setStrategy(newStrategy);  // Agent2 aura désormais la stratégie définie

        // Ajouter une nouvelle transaction et vérifier que les observateurs sont notifiés
        Transaction transaction3 = new Transaction.Builder()
                .id("T3")
                .date(LocalDate.now())
                .montant(2000)
                .type(TypeTransaction.VENTE)
                .build();

        agent1.addTransaction(transaction3);

        // Tester la méthode getMaxTransaction pour récupérer la transaction avec le montant le plus élevé
        Transaction maxTransaction = agent1.getMaxTransaction();
        System.out.println("Transaction maximale de " + agent1.getNom() + " : " + maxTransaction);
    }
}
