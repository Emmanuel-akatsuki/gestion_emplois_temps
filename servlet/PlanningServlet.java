package com.gestionplanning.servlet;

import com.gestionplanning.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class PlanningServlet extends HttpServlet {

    private PlanningDAO planningDAO;

    @Override
    public void init() {
        planningDAO = new PlanningDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Planning> list = planningDAO.listerPlannings();
        request.setAttribute("plannings", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("planning.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Planning p = new Planning();

        p.setLibelle(request.getParameter("libelle"));
        p.setSemestre(request.getParameter("semestre"));
        p.setAnneeAcad(request.getParameter("annee"));

        planningDAO.ajouterPlanning(p);

        response.sendRedirect("planning");
    }
}