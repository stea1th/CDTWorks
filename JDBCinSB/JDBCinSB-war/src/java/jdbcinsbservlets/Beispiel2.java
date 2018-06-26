package jdbcinsbservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.DepthTest;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbcinsbdtos.DeptSalDTO;
import jdbcinsbserver.DBVermittlerLocal;

@WebServlet(name="Beispiel2", urlPatterns={"/Beispiel2"})

public class Beispiel2 extends HttpServlet {

    @EJB
    private DBVermittlerLocal dBVermittler;
    
    
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
        out.println("<title>Servlet Beispiel2</title>");  
        out.println("</head>");
        out.println("<body>");
        
        try{
            for(DeptSalDTO d : dBVermittler.dbLesenUndAbliefern()){
                out.println("<p>" + d.getDeptId()+ " "+ d.getDeptName()+": " + d.getDeptSalSum()+"</p>");
            }
            
        }catch(EJBException e){
            out.println("<p>"+e.getMessage()+"</p>");
        }
        
        
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
