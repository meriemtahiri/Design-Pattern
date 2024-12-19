package com.tahiri.INTERFACES;

public class HDMIStandardDisplay implements HDMI {
    @Override
    public void display(String data) {
        System.out.println("Affichage via HDMI : " + data);
    }
}
