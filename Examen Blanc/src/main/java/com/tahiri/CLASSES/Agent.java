package com.tahiri.CLASSES;

import com.tahiri.INTERFACES.Observateur;
import com.tahiri.INTERFACES.Sujet;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Sujet, Observateur {
    private String nom;
    private List<Observateur> observateurs; // Liste des observateurs souscrits
    private List<Transaction> transactions; // Liste des transactions de l'agent

    public Agent(String nom) {
        this.nom = nom;
        this.observateurs = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Implémentation de Sujet
    @Override
    public void souscrire(Observateur observateur) {
        observateurs.add(observateur);
        System.out.println(nom + " a ajouté un nouvel observateur.");
    }

    @Override
    public void seDesabonner(Observateur observateur) {
        observateurs.remove(observateur);
        System.out.println(nom + " a retiré un observateur.");
    }

    @Override
    public void notifierObservateurs(String message) {
        for (Observateur obs : observateurs) {
            obs.notifier(message);
        }
    }

    // Méthode supplémentaire pour notifier avec un événement
    public void notifierObservateurs(EvenementNotification evenement) {
        for (Observateur obs : observateurs) {
            obs.notifier(evenement.toString());
        }
    }

    // Implémentation de Observateur
    @Override
    public void notifier(String message) {
        System.out.println("Agent " + nom + " a reçu une notification : " + message);
    }

    // Ajout d'une transaction et notification
    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction); // Ajouter la transaction
        System.out.println(nom + " a ajouté une transaction : " + transaction);

        // Créer un événement et notifier les observateurs
        EvenementNotification evenement = new EvenementNotification(nom, transaction);
        notifierObservateurs(evenement);
    }

    public String getNom() {
        return nom;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
