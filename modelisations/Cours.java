package modelisations;
public class Cours {

    private int idCours;
    private String intitule;
    private String codeMatiere;
    private String typeCours;
    private String volumeHoraire;
    private int credit;

    public Cours() {}

    public Cours(int idCours, String intitule, String codeMatiere, String typeCours, String volumeHoraire, int credit) {
        this.idCours = idCours;
        this.intitule = intitule;
        this.codeMatiere = codeMatiere;
        this.typeCours = typeCours;
        this.volumeHoraire = volumeHoraire;
        this.credit = credit;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(String typeCours) {
        this.typeCours = typeCours;
    }

    public String getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(String volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
