package cmruebung.servlets;

import cmruebung.beans.CMRJava2Local;
import cmruebung.beans.CMRJava3Local;
import cmruebung.beans.CMRJavaUebungLocal;
import cmruebung.entities.Departments;
import cmruebung.entities.Employees;
import cmruebung.exceptions.KeyNotFoundException;
import cmruebung.exceptions.NoDetailsException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CMRJavaUebungServlet", urlPatterns = {"/CMRJavaUebungServlet"})

public class CMRJavaUebungServlet extends HttpServlet {
    @EJB
    private CMRJava3Local test3;

    @EJB
    private CMRJava2Local test2;

    @EJB
    private CMRJavaUebungLocal test;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CMRJavaUebungServlet</title>");
        out.println("<style>"
                + " .red{color: red;}"
                + " .blue{color: blue;}"
                + "</style>");

        out.println("</head>");
        out.println("<body>");
        out.println("<div>MethodeA1: </div>");
        Departments d = test.a1(176);
        if (d != null) {
            out.printf("<div class='blue'>Departments ID: %d</div>", d.getDepartmentId());
            out.printf("<div class='blue'>Departments Name: %s</div>", d.getDepartmentName());
        } else {
            out.println("<div class='red'>Falsches ID oder Mitarbeiter ist zu keinem Department zugeordnet!!!</div>");
        }
        out.println("<hr>");
        out.println("<div>MethodeB1: </div>");
        int abtId = 1900;
        try {
            Double x = test.b1(abtId);
            out.printf("<div class='blue'>Durchschnittsgehalt des %d Departments: %.2f</div>", abtId, x);
        } catch (NoDetailsException | KeyNotFoundException e) {
            out.println("<div class='red'>" + e.getMessage() + "</div>");
        }
        out.println("<hr>");
        out.println("<div>MethodeC1: </div>");
        int empId = 107;
        List<String> list = test.c1(empId);
        out.printf("<div>Alle Kollegen des Mitarbeiters mit %d ID:</div>", empId);
        if (list != null) {
            for (String e : list) {
                out.println("<div class='blue'>" + e + "</div>");
            }
        } else {
            out.println("<div class='red'>Es gibt keine Kollegen</div>");
        }
        out.println("<hr>");
        out.println("<div>MethodeA2: </div>");
        int locId = 1400;
        out.printf("<div>Name des Landes zu %d Location-ID:</div>", locId);
        String land2 = test2.a2(locId);
        out.printf("<div class='%s'>%s</div>", !land2.contains("ID") ? "blue" : "red", land2);
        out.println("<hr>");
        out.println("<div>MethodeB2: </div>");
        String city = null;
        out.printf("<div>Name des Landes zu %s City-Name:</div>", city);
        String land = test2.b2(city);
        out.printf("<div class='%s'>%s</div>", !land.contains("ID") ? "blue" : "red", land);
        out.println("<hr>");
        out.println("<div>MethodeC2: </div>");
        String countryID = "US";
        out.printf("<div>Anzahl der Locations in %s Country:</div>", countryID);
        if (test2.c2(countryID) != null) {
            out.printf("<div class='blue'>%d Locations</div>", test2.c2(countryID));
        } else {
            out.println("<div class='red'>Country ID is falsch</div>");
        }
        out.println("<hr>");
        out.println("<div>MethodeA4: </div>");
        test3.a4(102, 90);
        test3.getAndPrintDepartments(90);
        out.println("<hr>");
        out.println("<div>MethodeB4: </div>");
//        test3.b4(90, 60);
//        test3.getAndPrintDepartments(90);
        out.println("<hr>");
        out.println("<div>MethodeC4: </div>");
        //test3.b4(90, 50);
        //test3.c4(90, 102);
        out.println("<hr>");
        //test3.getAndPrintDepartments(90);

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
