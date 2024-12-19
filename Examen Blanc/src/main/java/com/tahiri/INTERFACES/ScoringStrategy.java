package com.tahiri.INTERFACES;

import com.tahiri.CLASSES.Event;
import com.tahiri.CLASSES.Transaction;

public class ScoringStrategy implements NotificationStrategy {
    private double solde = 0;

    @Override
    public void processNotification(Event event) {
        double montant = event.getTransaction().getMontant();
        if (event.getTransaction().getType() == Transaction.TypeTransaction.VENTE) {
            solde += montant;
        } else {
            solde -= montant;
        }
        System.out.println("Mise à jour du solde : " + solde);
    }

    public double getSolde() {
        return solde;
    }
}
