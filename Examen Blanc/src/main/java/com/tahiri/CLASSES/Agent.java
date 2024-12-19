package com.tahiri.CLASSES;

import com.tahiri.INTERFACES.DefaultStrategy;
import com.tahiri.INTERFACES.NotificationStrategy;
import com.tahiri.INTERFACES.Observable;
import com.tahiri.INTERFACES.Observer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements Observable, Observer {
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

    @Override
    public void subscribe(Agent observer) { // observer va devenir un observateur chez cette agent
        if (!observers.contains(observer)) { // pour vérifier si l'agent n'existe pas déja
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Agent observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) { // notifier tous les observateurs de cet agent
        Event event = new Event(this.nom, transaction);
        for (Agent observer : observers) {
            observer.update(event);
        }
    }

    @Override
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
