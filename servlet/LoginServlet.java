package com.gestionplanning.servlet;

import com.gestionplanning.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UtilisateurDAO dao = new UtilisateurDAO();

        for (Utilisateur u : dao.listerUtilisateurs()) {

            if (u.getLogin().equals(login) && u.getPasswordHash().equals(password)) {

                HttpSession session = request.getSession();
                session.setAttribute("user", u);

                response.sendRedirect("dashboard.jsp");
                return;
            }
        }

        response.sendRedirect("login.html");
    }
}