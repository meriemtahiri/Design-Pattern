package com.tahiri.TESTS;

import com.tahiri.CLASSES.Agent;
import com.tahiri.CLASSES.Container;
import com.tahiri.CLASSES.Transaction;
import com.tahiri.INTERFACES.HDMI;
import com.tahiri.INTERFACES.HDMIStandardDisplay;
import com.tahiri.INTERFACES.VGA;
import com.tahiri.INTERFACES.VGAStandardDisplay;
import com.tahiri.INTERFACES.VGAAdapter;

import java.time.LocalDate;

public class TestContainer {

    public static void main(String[] args) {
        // Créer des agents
        Agent agent1 = new Agent("Agent 1");
        Agent agent2 = new Agent("Agent 2");

        // Créer un conteneur
        Container container = Container.getInstance();

        // Ajouter des agents au conteneur
        container.addAgent(agent1);
        container.addAgent(agent2);

        // Créer un afficheur HDMI standard et l'ajouter au conteneur
        HDMI hdmiDisplay = new HDMIStandardDisplay();
        container.addDisplay(hdmiDisplay);  // Méthode hypothétique pour ajouter un afficheur

        // Créer un affichage via VGA (avec un adaptateur HDMI)
        VGA vgaDisplay = new VGAStandardDisplay();
        HDMI vgaAdapter = new VGAAdapter(vgaDisplay);
        container.addDisplay(vgaAdapter);  // Ajouter un afficheur VGA via l'adaptateur

        // Simuler une transaction
        Transaction transaction = new Transaction.Builder()
                .id("T1")
                .date(LocalDate.now())
                .montant(500)
                .type(Transaction.TypeTransaction.VENTE)
                .build();

        // Ajouter la transaction à un agent et tester la notification
        agent1.addTransaction(transaction);
        agent2.addTransaction(transaction);

        // Test de l'affichage via HDMI et VGA
        // Le conteneur va déléguer l'affichage à chaque afficheur
        System.out.println("\nAffichage via HDMI:");
        container.displayState("État actuel des agents");

        System.out.println("\nAffichage via VGA via l'adaptateur:");
        container.displayState("État actuel des agents");
    }
}
