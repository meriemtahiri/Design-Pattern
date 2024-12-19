package com.tahiri.CLASSES;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private Map<String, Agent> agents;

    private Container() {
        agents = new HashMap<>();
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
}

