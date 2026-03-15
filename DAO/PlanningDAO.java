package DAO;

import modelisations.Planning;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class PlanningDAO {

    public void ajouterPlanning(Planning planning) {
        String query = "INSERT INTO Planning (libelle, semestre, annee_acad, date_debut, date_fin) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, planning.getLibelle());
            stmt.setString(2, planning.getSemestre());
            stmt.setString(3, planning.getAnneeAcad());
            stmt.setDate(4, new java.sql.Date(planning.getDateDebut().getTime()));
            stmt.setDate(5, new java.sql.Date(planning.getDateFin().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Planning> listerPlannings() {
        List<Planning> planningList = new ArrayList<>();
        String query = "SELECT * FROM Planning";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Planning planning = new Planning();
                planning.setIdPlanning(rs.getInt("id_planning"));
                planning.setLibelle(rs.getString("libelle"));
                planning.setSemestre(rs.getString("semestre"));
                planning.setAnneeAcad(rs.getString("annee_acad"));
                planning.setDateDebut(rs.getDate("date_debut"));
                planning.setDateFin(rs.getDate("date_fin"));
                planningList.add(planning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planningList;
    }

    public Planning getPlanningById(int idPlanning) {
        Planning planning = null;
        String query = "SELECT * FROM Planning WHERE id_planning = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPlanning);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    planning = new Planning();
                    planning.setIdPlanning(rs.getInt("id_planning"));
                    planning.setLibelle(rs.getString("libelle"));
                    planning.setSemestre(rs.getString("semestre"));
                    planning.setAnneeAcad(rs.getString("annee_acad"));
                    planning.setDateDebut(rs.getDate("date_debut"));
                    planning.setDateFin(rs.getDate("date_fin"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planning;
    }

    public void updatePlanning(Planning planning) {
        String query = "UPDATE Planning SET libelle = ?, semestre = ?, annee_acad = ?, date_debut = ?, date_fin = ? WHERE id_planning = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, planning.getLibelle());
            stmt.setString(2, planning.getSemestre());
            stmt.setString(3, planning.getAnneeAcad());
            stmt.setDate(4, new java.sql.Date(planning.getDateDebut().getTime()));
            stmt.setDate(5, new java.sql.Date(planning.getDateFin().getTime()));
            stmt.setInt(6, planning.getIdPlanning());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlanning(int idPlanning) {
        String query = "DELETE FROM Planning WHERE id_planning = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPlanning);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countPlannings() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Planning";
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
