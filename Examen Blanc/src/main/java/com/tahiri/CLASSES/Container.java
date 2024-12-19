package com.tahiri.CLASSES;

import com.tahiri.INTERFACES.HDMI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private static Container instance;
    private Map<String, Agent> agents;
    private List<HDMI> displays;  // Liste pour les afficheurs HDMI

    private Container() {
        agents = new HashMap<>();
        displays = new ArrayList<>();
    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void addAgent(Agent agent) {
        agents.put(agent.getNom(), agent);
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    // Méthode pour ajouter un afficheur à la liste des afficheurs HDMI
    public void addDisplay(HDMI display) {
        displays.add(display);
    }

    // Méthode pour afficher l'état sur tous les afficheurs connectés
    public void displayState(String data) {
        for (HDMI display : displays) {
            display.display(data);  // Appel de la méthode display() sur chaque afficheur
        }
    }
}

