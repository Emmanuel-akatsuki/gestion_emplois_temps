package DAO;

import modelisations.Etudiant;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class EtudiantDAO {

    public void ajouterEtudiant(Etudiant etudiant) {
        String query = "INSERT INTO Etudiants (matricule, nom, prenom, niveau, filiere) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, etudiant.getMatricule());
            stmt.setString(2, etudiant.getNom());
            stmt.setString(3, etudiant.getPrenom());
            stmt.setString(4, etudiant.getNiveau());
            stmt.setString(5, etudiant.getFiliere());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Etudiant> listerEtudiants() {
        List<Etudiant> etudiantsList = new ArrayList<>();
        String query = "SELECT * FROM Etudiants";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setNiveau(rs.getString("niveau"));
                etudiant.setFiliere(rs.getString("filiere"));
                etudiantsList.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiantsList;
    }

    public Etudiant getEtudiantById(int idEtudiant) {
        Etudiant etudiant = null;
        String query = "SELECT * FROM Etudiants WHERE id_etudiant = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEtudiant);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    etudiant = new Etudiant();
                    etudiant.setIdEtudiant(rs.getInt("id_etudiant"));
                    etudiant.setMatricule(rs.getString("matricule"));
                    etudiant.setNom(rs.getString("nom"));
                    etudiant.setPrenom(rs.getString("prenom"));
                    etudiant.setNiveau(rs.getString("niveau"));
                    etudiant.setFiliere(rs.getString("filiere"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    public void updateEtudiant(Etudiant etudiant) {
        String query = "UPDATE Etudiants SET matricule = ?, nom = ?, prenom = ?, niveau = ?, filiere = ? WHERE id_etudiant = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, etudiant.getMatricule());
            stmt.setString(2, etudiant.getNom());
            stmt.setString(3, etudiant.getPrenom());
            stmt.setString(4, etudiant.getNiveau());
            stmt.setString(5, etudiant.getFiliere());
            stmt.setInt(6, etudiant.getIdEtudiant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEtudiant(int idEtudiant) {
        String query = "DELETE FROM Etudiants WHERE id_etudiant = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEtudiant);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countEtudiants() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Etudiants";
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
