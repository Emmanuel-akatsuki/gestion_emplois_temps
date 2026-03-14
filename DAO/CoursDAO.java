package com.gestionplanning

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDAO {
    public void ajouterCours(Cours cours) {
        String query = "INSERT INTO Cours (intitule, code_matiere, type_cours, volume_horaire, credit) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cours.getIntitule());
            stmt.setString(2, cours.getCodeMatiere());
            stmt.setString(3, cours.getTypeCours().name());
            stmt.setTime(4, Time.valueOf(cours.getVolumeHoraire()));
            stmt.setInt(5, cours.getCredit());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cours> listerCours() {
        List<Cours> coursList = new ArrayList<>();
        String query = "SELECT * FROM Cours";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdCours(rs.getInt("id_cours"));
                cours.setIntitule(rs.getString("intitule"));
                cours.setCodeMatiere(rs.getString("code_matiere"));
                cours.setTypeCours(TypeCours.valueOf(rs.getString("type_cours")));
                cours.setVolumeHoraire(rs.getTime("volume_horaire").toLocalTime());
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
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idCours);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cours = new Cours();
                cours.setIdCours(rs.getInt("id_cours"));
                cours.setIntitule(rs.getString("intitule"));
                cours.setCodeMatiere(rs.getString("code_matiere"));
                cours.setTypeCours(TypeCours.valueOf(rs.getString("type_cours")));
                cours.setVolumeHoraire(rs.getTime("volume_horaire").toLocalTime());
                cours.setCredit(rs.getInt("credit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }
    public void updateCours(Cours cours) {
        String query = "UPDATE Cours SET intitule = ?, code_matiere = ?, type_cours = ?, volume_horaire = ?, credit = ? WHERE id_cours = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cours.getIntitule());
            stmt.setString(2, cours.getCodeMatiere());
            stmt.setString(3, cours.getTypeCours().name());
            stmt.setTime(4, Time.valueOf(cours.getVolumeHoraire()));
            stmt.setInt(5, cours.getCredit());
            stmt.setInt(6, cours.getIdCours());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCours(int idCours) {
        String query = "DELETE FROM Cours WHERE id_cours = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idCours);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}