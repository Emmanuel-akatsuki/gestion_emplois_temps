package servlet;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.SalleDAO;
import DAO.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class PlanningServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nbCours = CoursDAO.countCours();
        int nbEnseignants = EnseignantDAO.countEnseignants();
        int nbSalles = SalleDAO.countSalle();
        int nbEtudiants = EtudiantDAO.countEtudiants();
        int nbExamen = ExamenDAO.countExamen();
        int nbUtilisateurs = UtilisateursDAO.countUtilisateurs();

        request.setAttribute("cours", nbCours);
        request.setAttribute("enseignants", nbEnseignants);
        request.setAttribute("salles", nbSalles);
        request.setAttribute("etudiants", nbEtudiants);
        request.setAttribute("examen", nbExamen);
        request.setAttribute("utilisateurs", nbUtilisateurs);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("utilisateur/dashboard.jsp");

        dispatcher.forward(request,response);
    }
}
