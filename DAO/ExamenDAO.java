package DAO;

import modelisations.Examen;
import code.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamenDAO {


    public List<Examen> listerExamens() {
        List<Examen> examens = new ArrayList<>();
        String query = "SELECT * FROM examen";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Examen examen = new Examen();
                examen.setId(rs.getInt("id"));
                examen.setTitre(rs.getString("titre"));
                examen.setDate(rs.getDate("date"));
                examen.setCoursId(rs.getInt("cours_id"));
                examens.add(examen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examens;
    }

    // Nouvelle méthode pour ajouter un examen
    public void addExamen(Examen examen) {
        String query = "INSERT INTO examen (titre, date, cours_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, examen.getTitre());
            stmt.setDate(2, new java.sql.Date(examen.getDate().getTime()));
            stmt.setInt(3, examen.getCoursId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
