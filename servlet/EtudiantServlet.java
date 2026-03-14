package com.gestionplanning.servlet;

import com.gestionplanning.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EtudiantServlet extends HttpServlet {

    private EtudiantsDAO etudiantDAO;

    @Override
    public void init() {
        etudiantDAO = new EtudiantsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Etudiant> etudiants = etudiantDAO.listerEtudiants();
        request.setAttribute("etudiants", etudiants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("etudiants.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Etudiant e = new Etudiant();

        e.setMatricule(request.getParameter("matricule"));
        e.setNom(request.getParameter("nom"));
        e.setPrenom(request.getParameter("prenom"));
        e.setNiveau(request.getParameter("niveau"));
        e.setFiliere(request.getParameter("filiere"));

        etudiantDAO.ajouterEtudiant(e);

        response.sendRedirect("etudiants");
    }
}