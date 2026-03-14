package com.gestionplanning

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanningDAO {
    public void ajouterPlanning(Planning planning) {
        String query = "INSERT INTO Planning (libelle, semestre, annee_acad, date_debut, date_fin) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, planning.getLibelle());
            stmt.setString(2, planning.getSemestre());
            stmt.setString(3, planning.getAnneeAcad());
            stmt.setDate(4, Date.valueOf(planning.getDateDebut()));
            stmt.setDate(5, Date.valueOf(planning.getDateFin()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Planning> listerPlannings() {
        List<Planning> planningList = new ArrayList<>();
        String query = "SELECT * FROM Planning";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Planning planning = new Planning();
                planning.setIdPlanning(rs.getInt("id_planning"));
                planning.setLibelle(rs.getString("libelle"));
                planning.setSemestre(rs.getString("semestre"));
                planning.setAnneeAcad(rs.getString("annee_acad"));
                planning.setDateDebut(rs.getDate("date_debut").toLocalDate());
                planning.setDateFin(rs.getDate("date_fin").toLocalDate());
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
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPlanning);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                planning = new Planning();
                planning.setIdPlanning(rs.getInt("id_planning"));
                planning.setLibelle(rs.getString("libelle"));
                planning.setSemestre(rs.getString("semestre"));
                planning.setAnneeAcad(rs.getString("annee_acad"));
                planning.setDateDebut(rs.getDate("date_debut").toLocalDate());
                planning.setDateFin(rs.getDate("date_fin").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planning;
    }

    public void updatePlanning(Planning planning) {
        String query = "UPDATE Planning SET libelle = ?, semestre = ?, annee_acad = ?, date_debut = ?, date_fin = ? WHERE id_planning = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, planning.getLibelle());
            stmt.setString(2, planning.getSemestre());
            stmt.setString(3, planning.getAnneeAcad());
            stmt.setDate(4, Date.valueOf(planning.getDateDebut()));
            stmt.setDate(5, Date.valueOf(planning.getDateFin()));
            stmt.setInt(6, planning.getIdPlanning());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlanning(int idPlanning) {
        String query = "DELETE FROM Planning WHERE id_planning = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPlanning);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}