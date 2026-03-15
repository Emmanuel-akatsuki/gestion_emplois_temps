package com.planning.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Planning")
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planning")
    private int idPlanning;

    private String libelle;
    private String semestre;

    @Column(name = "annee_acad")
    private String anneeAcad;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    public Planning(){}

    public Planning(int idPlanning, String libelle, String semestre, String anneeAcad, Date dateDebut, Date dateFin) {
        this.idPlanning = idPlanning;
        this.libelle = libelle;
        this.semestre = semestre;
        this.anneeAcad = anneeAcad;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAnneeAcad() {
        return anneeAcad;
    }

    public void setAnneeAcad(String anneeAcad) {
        this.anneeAcad = anneeAcad;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
