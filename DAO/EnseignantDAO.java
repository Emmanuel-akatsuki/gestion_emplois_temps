package DAO;

import modelisations.Enseignant;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class EnseignantDAO {

    public void ajouterEnseignant(Enseignant enseignant) {
        String query = "INSERT INTO Enseignants (matricule, nom, prenom, specialite, grade, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, enseignant.getMatricule());
            stmt.setString(2, enseignant.getNom());
            stmt.setString(3, enseignant.getPrenom());
            stmt.setString(4, enseignant.getSpecialite());
            stmt.setString(5, enseignant.getGrade());
            stmt.setString(6, enseignant.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Enseignant> listerEnseignants() {
        List<Enseignant> enseignantList = new ArrayList<>();
        String query = "SELECT * FROM Enseignants";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Enseignant enseignant = new Enseignant();
                enseignant.setIdEnseignant(rs.getInt("id_enseignant"));
                enseignant.setMatricule(rs.getString("matricule"));
                enseignant.setNom(rs.getString("nom"));
                enseignant.setPrenom(rs.getString("prenom"));
                enseignant.setSpecialite(rs.getString("specialite"));
                enseignant.setGrade(rs.getString("grade"));
                enseignant.setEmail(rs.getString("email"));
                enseignantList.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignantList;
    }

    public Enseignant getEnseignantById(int idEnseignant) {
        Enseignant enseignant = null;
        String query = "SELECT * FROM Enseignants WHERE id_enseignant = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEnseignant);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    enseignant = new Enseignant();
                    enseignant.setIdEnseignant(rs.getInt("id_enseignant"));
                    enseignant.setMatricule(rs.getString("matricule"));
                    enseignant.setNom(rs.getString("nom"));
                    enseignant.setPrenom(rs.getString("prenom"));
                    enseignant.setSpecialite(rs.getString("specialite"));
                    enseignant.setGrade(rs.getString("grade"));
                    enseignant.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }

    public void updateEnseignant(Enseignant enseignant) {
        String query = "UPDATE Enseignants SET matricule = ?, nom = ?, prenom = ?, specialite = ?, grade = ?, email = ? WHERE id_enseignant = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, enseignant.getMatricule());
            stmt.setString(2, enseignant.getNom());
            stmt.setString(3, enseignant.getPrenom());
            stmt.setString(4, enseignant.getSpecialite());
            stmt.setString(5, enseignant.getGrade());
            stmt.setString(6, enseignant.getEmail());
            stmt.setInt(7, enseignant.getIdEnseignant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnseignant(int idEnseignant) {
        String query = "DELETE FROM Enseignants WHERE id_enseignant = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEnseignant);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countEnseignants() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Enseignants";
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
