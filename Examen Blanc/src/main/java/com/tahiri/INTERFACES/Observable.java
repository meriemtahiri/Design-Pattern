package com.tahiri.INTERFACES;

import com.tahiri.CLASSES.Agent;
import com.tahiri.CLASSES.Transaction;

public interface Observable {
    public void subscribe(Agent observer);
    public void removeObserver(Agent observer);
    public void notifyObservers(Transaction transaction);
}
