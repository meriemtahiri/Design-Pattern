package com.tahiri.CLASSES;

import com.tahiri.INTERFACES.DefaultStrategy;
import com.tahiri.INTERFACES.NotificationStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent {
    private String nom;
    private List<Transaction> transactions;
    private List<Agent> observers;
    private NotificationStrategy strategy;

    public Agent(String nom) {
        this.nom = nom;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.strategy = new DefaultStrategy();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    public void subscribe(Agent observer) { // observer va devenir un observateur chez cette agent
        observers.add(observer);
    }

    private void notifyObservers(Transaction transaction) { // notifier tous les observateurs de cet agent
        Event event = new Event(this.nom, transaction);
        for (Agent observer : observers) {
            observer.update(event);
        }
    }

    public void update(Event event) {
        strategy.processNotification(event);
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public Transaction getMaxTransaction() {
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getMontant))
                .orElse(null);
    }

    public String getNom() { return nom; }
}
