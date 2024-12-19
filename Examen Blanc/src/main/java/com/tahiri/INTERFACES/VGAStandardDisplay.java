package com.tahiri.INTERFACES;

public class VGAStandardDisplay implements VGA {
    @Override
    public void show(String data) {
        System.out.println("Affichage via VGA : " + data);
    }
}

