package modelisations;
import java.sql.Time;

public class Seance {

    private int idSeance;
    private int idPlanning;
    private int idEnseignant;
    private int idCours;
    private int idSalle;
    private String jour;
    private Time heureDebut;
    private Time heureFin;

    public Seance(){}

    public Seance(int idSeance, int idPlanning, int idEnseignant, int idCours, int idSalle, String jour, Time heureDebut, Time heureFin) {
        this.idSeance = idSeance;
        this.idPlanning = idPlanning;
        this.idEnseignant = idEnseignant;
        this.idCours = idCours;
        this.idSalle = idSalle;
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

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
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
