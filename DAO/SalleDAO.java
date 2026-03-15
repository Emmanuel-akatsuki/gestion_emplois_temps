package DAO;

import modelisations.Salle;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelisations.*;
public class SalleDAO {

    public void ajouterSalle(Salle salle) {
        String query = "INSERT INTO Salles (nom_salle, capacite, type_salle, batiment) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
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
        try (Connection conn = DatabaseConnection.getConnection();
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
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSalle);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    salle = new Salle();
                    salle.setIdSalle(rs.getInt("id_salle"));
                    salle.setNomSalle(rs.getString("nom_salle"));
                    salle.setCapacite(rs.getInt("capacite"));
                    salle.setTypeSalle(rs.getString("type_salle"));
                    salle.setBatiment(rs.getString("batiment"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }

    public void updateSalle(Salle salle) {
        String query = "UPDATE Salles SET nom_salle = ?, capacite = ?, type_salle = ?, batiment = ? WHERE id_salle = ?";
        try (Connection conn = DatabaseConnection.getConnection();
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
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idSalle);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countSalle() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM Salles";
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
