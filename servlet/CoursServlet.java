package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.CoursDAO;
import modelisations.Cours;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/CoursAction")
public class CoursServlet extends HttpServlet {

    private CoursDAO coursDAO;

    @Override
    public void init() {
        coursDAO = new CoursDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cours> coursList = coursDAO.listerCours();
        request.setAttribute("coursList", coursList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/cours.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String intitule = request.getParameter("intitule");
        String code = request.getParameter("code_matiere");
        String type = request.getParameter("type_cours");

        String volume = request.getParameter("volume_horaire");

        int credit = 0;
        try {
            credit = Integer.parseInt(request.getParameter("credit"));
        } catch (NumberFormatException e) { e.printStackTrace(); }

        Cours cours = new Cours();
        cours.setIntitule(intitule);
        cours.setCodeMatiere(code);
        cours.setTypeCours(type);
        cours.setVolumeHoraire(volume != null ? volume : "00:00:00");
        cours.setCredit(credit);

        coursDAO.ajouterCours(cours);

        response.sendRedirect(request.getContextPath() + "/CoursAction");
    }
}
