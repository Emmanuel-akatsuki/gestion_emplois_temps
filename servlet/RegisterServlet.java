package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DAO.*;
import modelisations.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import code.DatabaseConnection;
@WebServlet("/RegisterAction")

public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try{

            Connection conn = DatabaseConnection.getConnection();

            String sql = "INSERT INTO Utilisateur(login,password_hash,role,actif) VALUES(?,?,?,1)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, role);

            ps.executeUpdate();
            response.sendRedirect(request.getContextPath() + "/utilisateur/login.jsp");


        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
