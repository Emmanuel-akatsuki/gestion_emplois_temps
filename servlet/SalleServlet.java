package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.SalleDAO;
import modelisations.Salle;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/SalleAction")
public class SalleServlet extends HttpServlet {

    private SalleDAO salleDAO;

    @Override
    public void init() {
        salleDAO = new SalleDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Salle> salles = salleDAO.listerSalles();

        request.setAttribute("salles", salles);

        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/salles.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Salle salle = new Salle();
        salle.setNomSalle(request.getParameter("nom_salle"));
        salle.setCapacite(Integer.parseInt(request.getParameter("capacite")));
        salle.setTypeSalle(request.getParameter("type_salle"));
        salle.setBatiment(request.getParameter("batiment"));

        salleDAO.ajouterSalle(salle);

        response.sendRedirect(request.getContextPath() + "/SalleAction");
    }
}
