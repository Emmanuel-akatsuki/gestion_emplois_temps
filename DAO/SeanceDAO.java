package com.gestionplanning

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAO {
    public void ajouterSeance(Seance seance) {
        String query = "INSERT INTO Seance (id_planning, id_enseignant, id_cours, id_salle, jour, heure_debut, heure_fin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, seance.getIdPlanning());
            stmt.setInt(2, seance.getIdEnseignant());
            stmt.setInt(3, seance.getIdCours());
            stmt.setInt(4, seance.getIdSalle());
            stmt.setString(5, seance.getJour().name());
            stmt.setTime(6, Time.valueOf(seance.getHeureDebut()));
            stmt.setTime(7, Time.valueOf(seance.getHeureFin()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Seance> listerSeances() {
        List<Seance> seancesList = new ArrayList<>();
        String query = "SELECT * FROM Seance";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Seance seance = new Seance();
                seance.setIdSeance(rs.getInt("id_seance"));
                seance.setIdPlanning(rs.getInt("id_planning"));
                seance.setIdEnseignant(rs.getInt("id_enseignant"));
                seance.setIdCours(rs.getInt("id_cours"));
                seance.setIdSalle(rs.getInt("id_salle"));
                seance.setJour(Jour.valueOf(rs.getString("jour")));
                seance.setHeureDebut(rs.getTime("heure_debut").toLocalTime());
                seance.setHeureFin(rs.getTime("heure_fin").toLocalTime());
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
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSeance);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                seance = new Seance();
                seance.setIdSeance(rs.getInt("id_seance"));
                seance.setIdPlanning(rs.getInt("id_planning"));
                seance.setIdEnseignant(rs.getInt("id_enseignant"));
                seance.setIdCours(rs.getInt("id_cours"));
                seance.setIdSalle(rs.getInt("id_salle"));
                seance.setJour(Jour.valueOf(rs.getString("jour")));
                seance.setHeureDebut(rs.getTime("heure_debut").toLocalTime());
                seance.setHeureFin(rs.getTime("heure_fin").toLocalTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    public void updateSeance(Seance seance) {
        String query = "UPDATE Seance SET id_planning = ?, id_enseignant = ?, id_cours = ?, id_salle = ?, jour = ?, heure_debut = ?, heure_fin = ? WHERE id_seance = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, seance.getIdPlanning());
            stmt.setInt(2, seance.getIdEnseignant());
            stmt.setInt(3, seance.getIdCours());
            stmt.setInt(4, seance.getIdSalle());
            stmt.setString(5, seance.getJour().name());
            stmt.setTime(6, Time.valueOf(seance.getHeureDebut()));
            stmt.setTime(7, Time.valueOf(seance.getHeureFin()));
            stmt.setInt(8, seance.getIdSeance());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSeance(int idSeance) {
        String query = "DELETE FROM Seance WHERE id_seance = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSeance);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}