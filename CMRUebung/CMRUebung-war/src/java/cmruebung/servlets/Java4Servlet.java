package cmruebung.servlets;

import cmruebung.beans.Java4Local;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Java4Servlet", urlPatterns={"/Java4Servlet"})

public class Java4Servlet extends HttpServlet 
{
    @EJB
    private Java4Local java4;
    
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
        out.println("<title>Servlet Java4Servlet</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>MethodJPQL1:</h1>");
        java4.JPQL1(900);
        out.println("<h1>MethodJPQL2:</h1>");
        java4.JPQL2(90);
        out.println("<h1>MethodJPQL3:</h1>");
        java4.JPQL3("CA");
        out.println("<h1>MethodJPQL4:</h1>");
        java4.JPQL4(201);
        out.println("<h1>MethodJPQL5:</h1>");
        java4.JPQL5(90);
        out.println("<h1>MethodCMR1:</h1>");
        java4.CMR1(90);
        out.println("<h1>MethodCMR2:</h1>");
        java4.CMR2(90);
        out.println("<h1>MethodCMR3:</h1>");
        java4.CMR3("CA");
        out.println("<h1>MethodCMR4:</h1>");
        java4.CMR4(202);
        out.println("<h1>MethodCMR5:</h1>");
        java4.CMR5(90);
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