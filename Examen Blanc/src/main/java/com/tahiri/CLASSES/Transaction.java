package com.tahiri.CLASSES;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private LocalDate date;
    private double montant;
    private TypeTransaction type;

    // Enumération pour le type de transaction
    public enum TypeTransaction { VENTE, ACHAT }

    // Builder Pattern
    public static class Builder {
        private String id;
        private LocalDate date;
        private double montant;
        private TypeTransaction type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder montant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder type(TypeTransaction type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }

    // Getters
    public String getId() { return id; }
    public LocalDate getDate() { return date; }
    public double getMontant() { return montant; }
    public TypeTransaction getType() { return type; }
    public double setMontant(double montant){ return this.montant=montant; }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', date=" + date + ", montant=" + montant + ", type=" + type + '}';
    }
}
