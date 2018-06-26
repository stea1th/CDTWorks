package cmruebung.servlets;

import cmruebung.beans.CRMTestLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="CMRUebungServlet", urlPatterns={"/CMRUebungServlet"})

public class CMRUebungServlet extends HttpServlet 
{
    @EJB
    private CRMTestLocal test;
    
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
        out.println("<title>Servlet CMRUebungServlet</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>TestMethodA()</h1>");
        out.println("<script type='text/javascript'>alert('Hi, its me, your Javascript :)');</script>");
        test.a();
        out.println("<h1>TestMethodB()</h1>");
        test.b();
        out.println("<h1>TestMethodC()</h1>");
        test.c();
        out.println("<h1>TestMethodD()</h1>");
        test.d();
        out.println("<h1>TestMethodE()</h1>");
        test.e(124);
        out.println("<h1>TestMethodF()</h1>");
        test.f();
        out.println("<h1>TestMethodG()</h1>");
        test.g("UK");
        out.println("<h1>TestMethodH()</h1>");
        test.h("King");
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