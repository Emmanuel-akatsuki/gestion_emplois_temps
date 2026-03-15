package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/base";
    private static final String USER = "utilisateur";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur connexion DB");
            e.printStackTrace();
        }

        return conn;
    }
}

