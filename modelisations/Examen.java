public class Examen {

    private int idExamen;
    private int idCours;
    private int idSalle;
    private String typeExamen;
    private String session;
    private String dateDebut;
    private String dateFin;
    private String heureDebut;
    private String heureFin;

    public Examen() {}

    public Examen(int idCours, int idSalle, String typeExamen, String session,
                  String dateDebut, String dateFin, String heureDebut, String heureFin) {

        this.idCours = idCours;
        this.idSalle = idSalle;
        this.typeExamen = typeExamen;
        this.session = session;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
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

    public String getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(String typeExamen) {
        this.typeExamen = typeExamen;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
}
