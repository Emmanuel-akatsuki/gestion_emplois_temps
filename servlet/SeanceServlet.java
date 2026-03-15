package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.*;
import modelisations.*;

public class SeanceServlet extends HttpServlet {

    private SeanceDAO seanceDAO;

    @Override
    public void init() {
        seanceDAO = new SeanceDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Seance> seances = seanceDAO.listerSeances();
        request.setAttribute("seances", seances);

        RequestDispatcher dispatcher = request.getRequestDispatcher("seances.jsp");
        dispatcher.forward(request, response);
    }
}