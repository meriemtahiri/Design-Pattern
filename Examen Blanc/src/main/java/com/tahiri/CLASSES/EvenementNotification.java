package com.tahiri.CLASSES;

import com.tahiri.CLASSES.Transaction;

public class EvenementNotification {
    private final String agentNom;   // Nom de l'agent émetteur
    private final Transaction transaction; // Transaction ajoutée

    public EvenementNotification(String agentNom, Transaction transaction) {
        this.agentNom = agentNom;
        this.transaction = transaction;
    }

    public String getAgentNom() {
        return agentNom;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public String toString() {
        return "EvenementNotification{" +
                "agentNom='" + agentNom + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
