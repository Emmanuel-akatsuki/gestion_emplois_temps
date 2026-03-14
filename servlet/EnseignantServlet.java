package com.gestionplanning.servlet;

import com.gestionplanning.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EnseignantServlet extends HttpServlet {

    private EnseignantsDAO enseignantDAO;

    @Override
    public void init() {
        enseignantDAO = new EnseignantsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Enseignant> list = enseignantDAO.listerEnseignants();
        request.setAttribute("enseignants", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("enseignants.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enseignant e = new Enseignant();

        e.setMatricule(request.getParameter("matricule"));
        e.setNom(request.getParameter("nom"));
        e.setPrenom(request.getParameter("prenom"));
        e.setSpecialite(request.getParameter("specialite"));
        e.setGrade(request.getParameter("grade"));
        e.setEmail(request.getParameter("email"));

        enseignantDAO.ajouterEnseignant(e);

        response.sendRedirect("enseignants");
    }
}