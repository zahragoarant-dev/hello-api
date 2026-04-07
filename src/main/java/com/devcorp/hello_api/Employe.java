package com.devcorp.hello_api;

import jakarta.persistence.*;

@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String poste;

    public Employe() {}

    public Employe(String nom, String prenom, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getPoste() { return poste; }
}