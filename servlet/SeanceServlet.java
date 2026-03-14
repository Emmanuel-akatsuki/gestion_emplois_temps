package com.gestionplanning.servlet;

import com.gestionplanning.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

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