public class Utilisateur {

    private int idUser;
    private String login;
    private String passwordHash;
    private String role;
    private boolean actif;

    public Utilisateur() {}

    public Utilisateur(String login, String passwordHash, String role, boolean actif) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.role = role;
        this.actif = actif;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}
