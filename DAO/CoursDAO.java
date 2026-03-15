package DAO;

import modelisations.Cours;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class CoursDAO {

    public void ajouterCours(Cours cours) {
        String query = "INSERT INTO Cours (intitule, code_matiere, type_cours, volume_horaire, credit) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cours.getIntitule());
            stmt.setString(2, cours.getCodeMatiere());
            stmt.setString(3, cours.getTypeCours());
            stmt.setString(4, cours.getVolumeHoraire());
            stmt.setInt(5, cours.getCredit());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cours> listerCours() {
        List<Cours> coursList = new ArrayList<>();
        String query = "SELECT * FROM Cours";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdCours(rs.getInt("id_cours"));
                cours.setIntitule(rs.getString("intitule"));
                cours.setCodeMatiere(rs.getString("code_matiere"));
                cours.setTypeCours(rs.getString("type_cours"));
                Time vt = rs.getTime("volume_horaire");
                cours.setVolumeHoraire(vt != null ? vt.toString() : "00:00:00");
                cours.setCredit(rs.getInt("credit"));
                coursList.add(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursList;
    }

    public Cours getCoursById(int idCours) {
        Cours cours = null;
        String query = "SELECT * FROM Cours WHERE id_cours = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idCours);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cours = new Cours();
                    cours.setIdCours(rs.getInt("id_cours"));
                    cours.setIntitule(rs.getString("intitule"));
                    cours.setCodeMatiere(rs.getString("code_matiere"));
                    cours.setTypeCours(rs.getString("type_cours"));
                    Time vt = rs.getTime("volume_horaire");
                    cours.setVolumeHoraire(vt != null ? vt.toString() : "00:00:00");
                    cours.setCredit(rs.getInt("credit"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }

    public void updateCours(Cours cours) {
        String query = "UPDATE Cours SET intitule = ?, code_matiere = ?, type_cours = ?, volume_horaire = ?, credit = ? WHERE id_cours = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cours.getIntitule());
            stmt.setString(2, cours.getCodeMatiere());
            stmt.setString(3, cours.getTypeCours());
            stmt.setString(4, cours.getVolumeHoraire());
            stmt.setInt(5, cours.getCredit());
            stmt.setInt(6, cours.getIdCours());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCours(int idCours) {
        String query = "DELETE FROM Cours WHERE id_cours = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idCours);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countCours() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Cours";
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
