package com.tahiri.CLASSES;

public class Event {
    private String agentName;
    private Transaction transaction;

    public Event(String agentName, Transaction transaction) {
        this.agentName = agentName;
        this.transaction = transaction;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Event{" +
                "agentName='" + agentName + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}

