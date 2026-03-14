package com.gestionplanning


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SallesDAO {
    public void ajouterSalle(Salle salle) {
        String query = "INSERT INTO Salles (nom_salle, capacite, type_salle, batiment) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, salle.getNomSalle());
            stmt.setInt(2, salle.getCapacite());
            stmt.setString(3, salle.getTypeSalle());
            stmt.setString(4, salle.getBatiment());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Salle> listerSalles() {
        List<Salle> sallesList = new ArrayList<>();
        String query = "SELECT * FROM Salles";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Salle salle = new Salle();
                salle.setIdSalle(rs.getInt("id_salle"));
                salle.setNomSalle(rs.getString("nom_salle"));
                salle.setCapacite(rs.getInt("capacite"));
                salle.setTypeSalle(rs.getString("type_salle"));
                salle.setBatiment(rs.getString("batiment"));
                sallesList.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sallesList;
    }

    public Salle getSalleById(int idSalle) {
        Salle salle = null;
        String query = "SELECT * FROM Salles WHERE id_salle = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSalle);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                salle = new Salle();
                salle.setIdSalle(rs.getInt("id_salle"));
                salle.setNomSalle(rs.getString("nom_salle"));
                salle.setCapacite(rs.getInt("capacite"));
                salle.setTypeSalle(rs.getString("type_salle"));
                salle.setBatiment(rs.getString("batiment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }

    public void updateSalle(Salle salle) {
        String query = "UPDATE Salles SET nom_salle = ?, capacite = ?, type_salle = ?, batiment = ? WHERE id_salle = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, salle.getNomSalle());
            stmt.setInt(2, salle.getCapacite());
            stmt.setString(3, salle.getTypeSalle());
            stmt.setString(4, salle.getBatiment());
            stmt.setInt(5, salle.getIdSalle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSalle(int idSalle) {
        String query = "DELETE FROM Salles WHERE id_salle = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSalle);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}