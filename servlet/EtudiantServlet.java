package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.EtudiantDAO;
import modelisations.Etudiant;

public class EtudiantServlet extends HttpServlet {

    private EtudiantDAO etudiantDAO;

    @Override
    public void init() {
        etudiantDAO = new EtudiantDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Etudiant> list = etudiantDAO.listerEtudiants();

        request.setAttribute("etudiants", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/etudiants.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Etudiant e = new Etudiant();
        e.setMatricule(request.getParameter("matricule"));
        e.setNom(request.getParameter("nom"));
        e.setPrenom(request.getParameter("prenom"));
        e.setNiveau(request.getParameter("niveau"));
        e.setFiliere(request.getParameter("filiere"));

        etudiantDAO.ajouterEtudiant(e);

        response.sendRedirect(request.getContextPath() + "/EtudiantAction");
    }
}
