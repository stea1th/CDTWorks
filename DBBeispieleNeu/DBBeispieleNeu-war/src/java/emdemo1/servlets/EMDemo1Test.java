package emdemo1.servlets;

import emdemo1.beans.EMDemo1Local;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="EMDemo1Test", urlPatterns={"/EMDemo1Test"})

public class EMDemo1Test extends HttpServlet {
    
    @EJB
    private EMDemo1Local eMDemo1;
    
    
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
        out.println("<title>Servlet EMDemo1Test</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<p>TestMethode</p>");
        //eMDemo1.holeDatenSatz();
        //eMDemo1.schreibeDatenSatz();
        //eMDemo1.loescheDatenSatz();
        eMDemo1.aendernDatenSatz();
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