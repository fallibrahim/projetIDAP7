package com.example.projetidap7;

public class Modele {
    private int id;
    private String nom;
    private String quantite;
    private double prix;
    private String famille;


    public Modele(int id, String nom, String quantite, double prix, String famille) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.famille = famille;
    }

    public Modele(String nom, String quantite, double prix, String famille) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.famille = famille;
    }

    public Modele() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String getFamille() {
        return famille;
    }

    public void setFamille(String  famille) {
        this.famille = famille;
    }
}
