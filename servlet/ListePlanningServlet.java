package servlet;

import DAO.PlanningDAO;
import modelisations.Planning;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListePlanningServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanningDAO dao = new PlanningDAO();
        List<Planning> list = dao.listerPlannings();

        request.setAttribute("plannings", list);

        request.getRequestDispatcher("utilisateur/planning.jsp").forward(request, response);
    }
}
