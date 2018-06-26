package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import newpackage.AbfrageLocal;
import newpackage.TestDataDTO;

@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})

public class TestServlet extends HttpServlet {

    @EJB
    private AbfrageLocal abfrage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet TestServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 align=\"center\">TestÜbung 5</h2>");
        out.println("<div><hr>\n"
                + "            <form method=\"post\">\n"
                + "            <input type=\"number\" name=\"id\"/>\n"
                + "            <button type=\"submit\">Submit</button>\n"
                + "            </form>"
                + "        </div>");
        try {
            if (request.getParameter("id") != null && request.getParameter("id").length() != 0) {
                if (request.getParameter("id").length() < 4) {
                    List<TestDataDTO> list = abfrage.getData(Integer.parseInt(request.getParameter("id")));
                    if (!list.isEmpty()) {
                        out.println("<h2>Abteilung: " + list.get(0).getAbteilName() + "</h2>");

                        for (TestDataDTO t : list) {
                            out.println("<p>" + t.getmId() + " " + t.getmName() + " " + t.getmSalary() + "</p>");
                        }
                    } else {
                        out.println("<p>Es existieren keine Daten zu diesem Id</p>");
                    }
                } else {
                    List<TestDataDTO> list = abfrage.getAllEmpl(Integer.parseInt(request.getParameter("id")));
                    if (!list.isEmpty()) {
                        out.println("<h2>City: " + list.get(0).getCity() + "</h2>");

                        for (TestDataDTO t : list) {
                            out.println("<p>" + t.getmId() + " " + t.getmName() + " " + t.getmSalary() + " " + t.getAbteilName() + "</p>");
                        }
                    } else {
                        out.println("<p>Es existieren keine Daten zu diesem Id</p>");
                    }
                }
            } else {
                out.println("<p>Bitte geben Sie Id ein!</p>");
            }
        } catch (EJBException e) {
            out.println("<p>" + e.getMessage() + "</p>");
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
