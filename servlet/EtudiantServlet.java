package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.*;
import modelisations.*;

public class EtudiantServlet extends HttpServlet {

    private EtudiantDAO etudiantDAO;

    @Override
    public void init() {
        etudiantDAO = new EtudiantDAO();
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