package com.gestionplanning.servlet;

import com.gestionplanning.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SalleServlet extends HttpServlet {

    private SallesDAO salleDAO;

    @Override
    public void init() {
        salleDAO = new SallesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Salle> salles = salleDAO.listerSalles();
        request.setAttribute("salles", salles);

        RequestDispatcher dispatcher = request.getRequestDispatcher("salles.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Salle salle = new Salle();

        salle.setNomSalle(request.getParameter("nom_salle"));
        salle.setCapacite(Integer.parseInt(request.getParameter("capacite")));
        salle.setTypeSalle(request.getParameter("type_salle"));
        salle.setBatiment(request.getParameter("batiment"));

        salleDAO.ajouterSalle(salle);

        response.sendRedirect("salles");
    }
}