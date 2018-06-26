package eubungservlets;

import dbuebungneu.beans.DepartmentsTestLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="DepartmentsServlet", urlPatterns={"/DepartmentsServlet"})

public class DepartmentsServlet extends HttpServlet {
    @EJB
    private DepartmentsTestLocal departmentsTest;
    
    
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
        out.println("<title>Servlet DepartmentsServlet</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Method void getAllData();</h1>");
        departmentsTest.getAllData();
        out.println("<h1>Method void getDataWithParam();</h1>");
        departmentsTest.getDataWithParam();
        out.println("<h1>Method void getData(int locationId);</h1>");
        departmentsTest.getData(1234);
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