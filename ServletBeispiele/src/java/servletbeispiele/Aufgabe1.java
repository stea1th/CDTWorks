package servletbeispiele;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Aufgabe1", urlPatterns={"/Aufgabe1"})

public class Aufgabe1 extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Aufgabe1</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<table align=\"center\" border=\"1px\">\n" +
"            <tr >\n" +
"                <th colspan=\"3\"><h1>Zahlenspielereien</h1></th>\n" +
"            </tr>\n" +
"            <tr>\n" +
"                <th>Zahl</th>\n" +
"                <th>Zahl&sup2</th>\n" +
"                <th>Zahl&sup3</th>\n" +
"            </tr>\n");
        for (int i = 1; i < 11; i++) {
            out.println(String.format("<tr align=\"right\">\n" +
"                <td>%s</td>\n" +
"                <td>%s</td>\n" +
"                <td>%s</td>\n" +
"                \n" +
"            </tr>", i, (int)Math.pow(i, 2), (int)Math.pow(i, 3)));
            
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        doGet(request, response);
    }
}
