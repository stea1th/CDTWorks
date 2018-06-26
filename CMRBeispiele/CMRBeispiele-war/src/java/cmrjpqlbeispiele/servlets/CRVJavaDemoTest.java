package cmrjpqlbeispiele.servlets;

import cmrbeispiele.beans.CMRJavaDemoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CRVJavaDemoTest", urlPatterns = {"/CRVJavaDemoTest"})

public class CRVJavaDemoTest extends HttpServlet {

    @EJB
    private CMRJavaDemoLocal test;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CRVJavaDemoTest</title>");
        out.println("</head>");
        out.println("<body>");
//        String erg = test.frageTyp1(25348);
//        out.println("<script type='text/javascript'>var years = prompt('Сколько вам лет?', 100);\n"
//                + "\n"
//                + "alert('Вам ' + years + ' лет!')</script>");
        //out.println("<div>" + erg + "</div>");
        out.println("<h1>MethodFrageTyp2</h1>");
        test.frageTyp2("a1");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
