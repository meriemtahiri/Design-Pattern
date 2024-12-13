package com.tahiri.CLASSES;

import java.util.Date;

public class Transaction {
    private final String id;
    private final Date date;
    private final double montant;
    private final Type type;

    // Constructeur privé pour forcer l'utilisation du Builder
    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = Type.valueOf(builder.type);
    }

    // Getters pour accéder aux propriétés
    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type='" + type + '\'' +
                '}';
    }

    // Classe interne Builder
    public static class Builder {
        private String id;
        private Date date;
        private double montant;
        private String type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder setType(String type) {
            if (!type.equals("Vente") && !type.equals("Achat")) {
                throw new IllegalArgumentException("Le type doit être 'Vente' ou 'Achat'.");
            }
            this.type = type;
            return this;
        }

        public Transaction build() {
            if (id == null || date == null || type == null) {
                throw new IllegalStateException("Les champs id, date et type sont obligatoires.");
            }
            return new Transaction(this);
        }
    }
}
