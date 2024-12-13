package com.tahiri.TESTS;

import com.tahiri.CLASSES.Agent;

public class TestObserver {
    public static void main(String[] args) {
        // Création des agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");
        Agent agent3 = new Agent("Agent3");

        // Agent1 souscrit Agent2 et Agent3 comme observateurs
        agent1.souscrire(agent2);
        agent1.souscrire(agent3);

        // Agent1 envoie une notification à ses observateurs
        agent1.notifierObservateurs("Mise à jour importante.");

        // Agent3 souscrit Agent1 comme observateur
        agent3.souscrire(agent1);

        // Agent3 envoie une notification
        agent3.notifierObservateurs("Nouvelle transaction enregistrée.");

        // Agent2 se désabonne de Agent1
        agent1.seDesabonner(agent2);

        // Agent1 envoie une autre notification
        agent1.notifierObservateurs("Deuxième mise à jour.");
    }
}
