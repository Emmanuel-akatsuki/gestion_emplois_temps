package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.SeanceDAO;
import modelisations.Seance;

public class SeanceServlet extends HttpServlet {

    private SeanceDAO seanceDAO;

    @Override
    public void init() {
        seanceDAO = new SeanceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<Seance> seances = seanceDAO.listerSeances();


        request.setAttribute("seances", seances);


        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/seances.jsp");
        dispatcher.forward(request, response);
    }
}
