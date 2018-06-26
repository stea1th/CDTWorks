package dbbeispieleneu.servlets;

import dbbeispieleneu.beans.DataSouceDemoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LeseRegionsTest", urlPatterns = {"/LeseRegionsTest"})

public class LeseRegionsTest extends HttpServlet {

    @EJB
    private DataSouceDemoLocal dataSourceDemo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LeseRegionsTest</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>regions:</h2>");
        try {
            for (String s : dataSourceDemo.leseRegions()) {
                out.println("<p>" + s + "</p>");
            }
        } catch (EJBException e) {
            out.println("<p>Probleme!!!</p>");

        } finally {
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
