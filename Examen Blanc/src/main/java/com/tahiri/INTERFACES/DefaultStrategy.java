package com.tahiri.INTERFACES;


import com.tahiri.CLASSES.Event;

public class DefaultStrategy implements NotificationStrategy {
    @Override
    public void processNotification(Event event) {
        System.out.println("Notification reçue par défaut :");
        System.out.println("Agent : " + event.getAgentName() + ", Transaction : " + event.getTransaction());
    }
}

