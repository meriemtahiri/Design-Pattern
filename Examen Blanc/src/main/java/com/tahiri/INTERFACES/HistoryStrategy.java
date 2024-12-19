package com.tahiri.INTERFACES;

import com.tahiri.CLASSES.Event;
import com.tahiri.CLASSES.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements NotificationStrategy {
    private List<Transaction> historique = new ArrayList<>();

    @Override
    public void processNotification(Event event) {
        historique.add(event.getTransaction());
        System.out.println("Historique mis à jour : " + historique);
    }

    public List<Transaction> getHistorique() {
        return historique;
    }
}
