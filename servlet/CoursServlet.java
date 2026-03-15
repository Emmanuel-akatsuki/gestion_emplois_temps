package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.*;
import modelisations.*;

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

        RequestDispatcher dispatcher = request.getRequestDispatcher("cours.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String intitule = request.getParameter("intitule");
        String code = request.getParameter("code_matiere");
        String type = request.getParameter("type_cours");
        int credit = Integer.parseInt(request.getParameter("credit"));

        Cours cours = new Cours();
        cours.setIntitule(intitule);
        cours.setCodeMatiere(code);
        cours.setTypeCours(type);
        cours.setCredit(credit);

        coursDAO.ajouterCours(cours);

        response.sendRedirect("cours");
    }
}