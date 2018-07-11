package servlet;

import beans.FehlTageBeanLocal;
import dto.TeilnehmerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testservlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    @EJB
    private FehlTageBeanLocal bean;

    private static final String TESTJSP = "testjsp.jsp";
    private static final String PRINTRESULT = "printresult.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("testjsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TeilnehmerDTO> list = new ArrayList<>();
        try {

            String action = request.getParameter("action");
            switch (action) {
                
                case "abfrage1":
                    list = bean.abfrage1(request.getParameter("name"), request.getParameter("vorname"), request.getParameter("massnahme"));
                    break;
                case "abfrage2":
                    list = bean.abfrage2(request.getParameter("name"), request.getParameter("vorname"), request.getParameter("massnahme"));
                    break;

                case "abfrage3":
                    list = bean.abfrage3(request.getParameter("name"), request.getParameter("vorname"), request.getParameter("massnahme"), request.getParameter("baustein"));
                    break;

                case "abfrage4":
                    list = bean.abfrage4(request.getParameter("massnahme"));
                    break;

                case "abfrage5":
                    list = bean.abfrage5(request.getParameter("massnahme"), request.getParameter("baustein"));
                    break;

                case "abfrage6":
                    list = bean.abfrage6();
                    break;

            }
            request.setAttribute("list", list);
            //request.getRequestDispatcher(PRINTRESULT).forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {

        } finally {
            if (list.isEmpty()) {
                String error = "Teilnehmer ist nicht vorhanden!";
                request.setAttribute("error", error);
            }
            request.getRequestDispatcher(PRINTRESULT).forward(request, response);

        }

    }
}
