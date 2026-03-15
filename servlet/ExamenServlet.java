package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.*;
import modelisations.*;

public class ExamenServlet extends HttpServlet {

    private ExamenDAO examenDAO;

    @Override
    public void init() {
        examenDAO = new ExamenDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Examen> examens = examenDAO.listerExamens();
        request.setAttribute("examens", examens);

        RequestDispatcher dispatcher = request.getRequestDispatcher("examens.jsp");
        dispatcher.forward(request, response);
    }
}