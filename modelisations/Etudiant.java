package modelisations;
public class Etudiant {

    private int idEtudiant;
    private String matricule;
    private String nom;
    private String prenom;
    private String niveau;
    private String filiere;

    public Etudiant(){}

    public Etudiant(int idEtudiant, String matricule, String nom, String prenom, String niveau, String filiere) {
        this.idEtudiant = idEtudiant;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.filiere = filiere;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
