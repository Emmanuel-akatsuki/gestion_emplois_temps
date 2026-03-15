package servlet;

import DAO.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/PlanningAction")
public class PlanningServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("cours", CoursDAO.countCours());
        request.setAttribute("enseignants", EnseignantDAO.countEnseignants());
        request.setAttribute("salles", SalleDAO.countSalle());
        request.setAttribute("etudiants", EtudiantDAO.countEtudiants());
        request.setAttribute("examen", ExamenDAO.countExamen());

        request.setAttribute("cm", 10);
        request.setAttribute("td", 5);
        request.setAttribute("tp", 3);

        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
