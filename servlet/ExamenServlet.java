package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.ExamenDAO;
import modelisations.Examen;

public class ExamenServlet extends HttpServlet {

    private ExamenDAO examenDAO;

    @Override
    public void init() {
        examenDAO = new ExamenDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Examen> examens = examenDAO.listerExamens();

        request.setAttribute("examens", examens);


        RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur/examens.jsp");
        dispatcher.forward(request, response);
    }
}
