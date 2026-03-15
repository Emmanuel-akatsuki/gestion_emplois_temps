package com.planning.model;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Seance")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seance")
    private int idSeance;

    @ManyToOne
    @JoinColumn(name = "id_planning")
    private Planning planning;

    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "id_cours")
    private Cours cours;

    @ManyToOne
    @JoinColumn(name = "id_salle")
    private Salle salle;

    private String jour;

    @Column(name = "heure_debut")
    private Time heureDebut;

    @Column(name = "heure_fin")
    private Time heureFin;

    public Seance(){}

    public Seance(int idSeance, Planning planning, Enseignant enseignant, Cours cours, Salle salle, String jour, Time heureDebut, Time heureFin) {
        this.idSeance = idSeance;
        this.planning = planning;
        this.enseignant = enseignant;
        this.cours = cours;
        this.salle = salle;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }
}
