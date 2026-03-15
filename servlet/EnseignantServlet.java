package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import DAO.*;
import modelisations.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/EnseignantAction")
public class EnseignantServlet extends HttpServlet {

    private EnseignantDAO enseignantDAO;

    @Override
    public void init() {
        enseignantDAO = new EnseignantDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Enseignant> list = enseignantDAO.listerEnseignants();
        request.setAttribute("enseignants", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/enseignants.jsp");
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

        response.sendRedirect("EnseignantAction");
    }
}
