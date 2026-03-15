package DAO;

import modelisations.Seance;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class SeanceDAO {

    public void ajouterSeance(Seance seance) {
        String query = "INSERT INTO Seance (id_planning, id_enseignant, id_cours, id_salle, jour, heure_debut, heure_fin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, seance.getIdPlanning());
            stmt.setInt(2, seance.getIdEnseignant());
            stmt.setInt(3, seance.getIdCours());
            stmt.setInt(4, seance.getIdSalle());
            stmt.setString(5, seance.getJour());
            stmt.setTime(6, seance.getHeureDebut());
            stmt.setTime(7, seance.getHeureFin());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Seance> listerSeances() {
        List<Seance> seancesList = new ArrayList<>();
        String query = "SELECT * FROM Seance";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Seance seance = new Seance();
                seance.setIdSeance(rs.getInt("id_seance"));
                seance.setIdPlanning(rs.getInt("id_planning"));
                seance.setIdEnseignant(rs.getInt("id_enseignant"));
                seance.setIdCours(rs.getInt("id_cours"));
                seance.setIdSalle(rs.getInt("id_salle"));
                seance.setJour(rs.getString("jour"));
                seance.setHeureDebut(rs.getTime("heure_debut"));
                seance.setHeureFin(rs.getTime("heure_fin"));
                seancesList.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seancesList;
    }

    public Seance getSeanceById(int idSeance) {
        Seance seance = null;
        String query = "SELECT * FROM Seance WHERE id_seance = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSeance);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    seance = new Seance();
                    seance.setIdSeance(rs.getInt("id_seance"));
                    seance.setIdPlanning(rs.getInt("id_planning"));
                    seance.setIdEnseignant(rs.getInt("id_enseignant"));
                    seance.setIdCours(rs.getInt("id_cours"));
                    seance.setIdSalle(rs.getInt("id_salle"));
                    seance.setJour(rs.getString("jour"));
                    seance.setHeureDebut(rs.getTime("heure_debut"));
                    seance.setHeureFin(rs.getTime("heure_fin"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    public void updateSeance(Seance seance) {
        String query = "UPDATE Seance SET id_planning = ?, id_enseignant = ?, id_cours = ?, id_salle = ?, jour = ?, heure_debut = ?, heure_fin = ? WHERE id_seance = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, seance.getIdPlanning());
            stmt.setInt(2, seance.getIdEnseignant());
            stmt.setInt(3, seance.getIdCours());
            stmt.setInt(4, seance.getIdSalle());
            stmt.setString(5, seance.getJour());
            stmt.setTime(6, seance.getHeureDebut());
            stmt.setTime(7, seance.getHeureFin());
            stmt.setInt(8, seance.getIdSeance());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSeance(int idSeance) {
        String query = "DELETE FROM Seance WHERE id_seance = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSeance);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countSeance() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Seance";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
