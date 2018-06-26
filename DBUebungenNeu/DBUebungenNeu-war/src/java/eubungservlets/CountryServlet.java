package eubungservlets;

import dbuebungneu.beans.CountryTestLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="CountryServlet", urlPatterns={"/CountryServlet"})

public class CountryServlet extends HttpServlet 
{
    @EJB
    private CountryTestLocal countryTest;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CountryServlet</title>");  
        out.println("</head>");
        out.println("<body>");
       
        //countryTest.getById("DE");
        //countryTest.createCountry("de", "Austria", 1);
        countryTest.createCountry("xy", "Litauen", 8);
        //countryTest.createCountry("al", "albany", 1);
        //countryTest.setCountryById("al", "Albania");
        //countryTest.deleteCountry("xy");
        //countryTest.getProperties();
        
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