package com.tahiri.INTERFACES;

public class VGAAdapter implements HDMI {
    private VGA vgaDisplay;

    public VGAAdapter(VGA vgaDisplay) {
        this.vgaDisplay = vgaDisplay;
    }

    @Override
    public void display(String data) {
        System.out.println("Adaptation de HDMI à VGA...");
        vgaDisplay.show(data);
    }
}

