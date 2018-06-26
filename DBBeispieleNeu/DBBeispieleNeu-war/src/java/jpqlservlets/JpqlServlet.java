package jpqlservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpql.beans.JpqlLocal;

@WebServlet(name="JpqlServlet", urlPatterns={"/JpqlServlet"})

public class JpqlServlet extends HttpServlet 
{
    @EJB
    private JpqlLocal jpql;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet JpqlServlet</title>");  
        out.println("</head>");
        out.println("<body>");
        /*out.println("<h1>TestMethode</h1>");
        jpql.leseBestimmteJobs();
        out.println("<h1>TestMethode2</h1>");
        jpql.leseJobTitles();
        out.println("<h1>TestMethode3</h1>");
        jpql.leseIdsUndTitles();
        out.println("<h1>TestMethode4</h1>");
        jpql.beispiel4();*/
//        out.println("<h1>TestMethode5a</h1>");
//        jpql.beispiel5a();
//        out.println("<h1>TestMethode6</h1>");
//        jpql.beispiel6();
//        out.println("<h1>TestParameterDemo</h1>");
//        jpql.parameterDemo(5000.0, 10000.0);
//        out.println("<h1>TestSingleMethod</h1>");
//        jpql.getSingleDemoA();
//        out.println("<h1>TestSingleMethodB</h1>");
//        jpql.getSingleDemoB();
        out.println("<h1>TestAntiSingleMethodB</h1>");
        jpql.getAntiSingleDemo();
//        out.println("<h1>TestMethode5b</h1>");
//        jpql.beispiel5b();
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