package DAO;

import modelisations.Examen;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class ExamenDAO {

    public void ajouterExamen(Examen examen) {
        String query = "INSERT INTO Examen (id_cours, id_salle, type_examen, session, date_debut, date_fin, heure_debut, heure_fin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, examen.getIdCours());
            stmt.setInt(2, examen.getIdSalle());
            stmt.setString(3, examen.getTypeExamen());
            stmt.setString(4, examen.getSession());
            stmt.setDate(5, java.sql.Date.valueOf(examen.getDateDebut()));
            stmt.setDate(6, java.sql.Date.valueOf(examen.getDateFin()));
            stmt.setTime(7, java.sql.Time.valueOf(examen.getHeureDebut()));
            stmt.setTime(8, java.sql.Time.valueOf(examen.getHeureFin()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Examen> listerExamens() {
        List<Examen> examensList = new ArrayList<>();
        String query = "SELECT * FROM Examen";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Examen examen = new Examen();
                examen.setIdExamen(rs.getInt("id_examen"));
                examen.setIdCours(rs.getInt("id_cours"));
                examen.setIdSalle(rs.getInt("id_salle"));
                examen.setTypeExamen(rs.getString("type_examen"));
                examen.setSession(rs.getString("session"));
                // Conversion SQL -> String pour le modèle
                examen.setDateDebut(rs.getDate("date_debut").toLocalDate().toString());
                examen.setDateFin(rs.getDate("date_fin").toLocalDate().toString());
                examen.setHeureDebut(rs.getTime("heure_debut").toLocalTime().toString());
                examen.setHeureFin(rs.getTime("heure_fin").toLocalTime().toString());
                examensList.add(examen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examensList;
    }

    public Examen getExamenById(int idExamen) {
        Examen examen = null;
        String query = "SELECT * FROM Examen WHERE id_examen = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idExamen);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    examen = new Examen();
                    examen.setIdExamen(rs.getInt("id_examen"));
                    examen.setIdCours(rs.getInt("id_cours"));
                    examen.setIdSalle(rs.getInt("id_salle"));
                    examen.setTypeExamen(rs.getString("type_examen"));
                    examen.setSession(rs.getString("session"));
                    examen.setDateDebut(rs.getDate("date_debut").toLocalDate().toString());
                    examen.setDateFin(rs.getDate("date_fin").toLocalDate().toString());
                    examen.setHeureDebut(rs.getTime("heure_debut").toLocalTime().toString());
                    examen.setHeureFin(rs.getTime("heure_fin").toLocalTime().toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examen;
    }

    public void updateExamen(Examen examen) {
        String query = "UPDATE Examen SET id_cours = ?, id_salle = ?, type_examen = ?, session = ?, date_debut = ?, date_fin = ?, heure_debut = ?, heure_fin = ? WHERE id_examen = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, examen.getIdCours());
            stmt.setInt(2, examen.getIdSalle());
            stmt.setString(3, examen.getTypeExamen());
            stmt.setString(4, examen.getSession());
            stmt.setDate(5, java.sql.Date.valueOf(examen.getDateDebut()));
            stmt.setDate(6, java.sql.Date.valueOf(examen.getDateFin()));
            stmt.setTime(7, java.sql.Time.valueOf(examen.getHeureDebut()));
            stmt.setTime(8, java.sql.Time.valueOf(examen.getHeureFin()));
            stmt.setInt(9, examen.getIdExamen());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteExamen(int idExamen) {
        String query = "DELETE FROM Examen WHERE id_examen = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idExamen);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countExamen() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Examen";
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
