package com.gestionplanning

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String query = "INSERT INTO Utilisateur (login, password_hash, role, actif) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, utilisateur.getLogin());
            stmt.setString(2, utilisateur.getPasswordHash());
            stmt.setString(3, utilisateur.getRole().name());
            stmt.setBoolean(4, utilisateur.isActif());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Utilisateur> listerUtilisateurs() {
        List<Utilisateur> utilisateursList = new ArrayList<>();
        String query = "SELECT * FROM Utilisateur";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdUser(rs.getInt("id_user"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setPasswordHash(rs.getString("password_hash"));
                utilisateur.setRole(Role.valueOf(rs.getString("role")));
                utilisateur.setActif(rs.getBoolean("actif"));
                utilisateursList.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateursList;
    }

    public Utilisateur getUtilisateurById(int idUser) {
        Utilisateur utilisateur = null;
        String query = "SELECT * FROM Utilisateur WHERE id_user = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUser);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setIdUser(rs.getInt("id_user"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setPasswordHash(rs.getString("password_hash"));
                utilisateur.setRole(Role.valueOf(rs.getString("role")));
                utilisateur.setActif(rs.getBoolean("actif"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    public void updateUtilisateur(Utilisateur utilisateur) {
        String query = "UPDATE Utilisateur SET login = ?, password_hash = ?, role = ?, actif = ? WHERE id_user = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, utilisateur.getLogin());
            stmt.setString(2, utilisateur.getPasswordHash());
            stmt.setString(3, utilisateur.getRole().name());
            stmt.setBoolean(4, utilisateur.isActif());
            stmt.setInt(5, utilisateur.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUtilisateur(int idUser) {
        String query = "DELETE FROM Utilisateur WHERE id_user = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}