package cmrjpqlbeispiele.servlets;

import cmrbeispiele.beans.CMRJPQLDemoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="CMRJPQLDemoTest", urlPatterns={"/CMRJPQLDemoTest"})

public class CMRJPQLDemoTest extends HttpServlet 
{
    @EJB
    private CMRJPQLDemoLocal test;
    
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
        out.println("<title>Servlet CMRJPQLDemoTest</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<script type='text/javascript'>alert('Das Ergebniss: ')</script>");
//        out.println("<h1>TestCRMJPQLDemo1</h1>");
//        test.abfrageTyp1();
//        out.println("<h1>TestCRMJPQLDemo2</h1>");
//        test.abfrageTyp2();
//        out.println("<h1>TestCRMJPQLDemoX</h1>");
//        test.abfrageTypX();
//        out.println("<h1>TestCRMJPQLDemo3</h1>");
//        test.abfrageTyp3();
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