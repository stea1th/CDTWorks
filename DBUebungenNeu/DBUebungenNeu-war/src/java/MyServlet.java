
import dbuebungneu.beans2.MyBeanLocal;
import dbuebungneu.dtos.EmployeesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MyServlet"})

public class MyServlet extends HttpServlet {
    
    @EJB
    private MyBeanLocal myBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MyServlet</title>");
        out.println("<style>\n"
                + "   table { \n"
                + "    width: 100%; /* Ширина таблицы */\n"
                + "    border-spacing: 0; /* Расстояние между ячейками */\n"
                
                + "   }\n"
                + "   tr:nth-child(2n) {\n"
                + "    background: #f0f0f0; /* Цвет фона */\n"
                + "    text-align: right;"
                + "   } \n"
                + "   tr:nth-child(2n+1) {\n"
               
                + "    text-align: right;"
                + "   } \n"
                + "   tr:nth-child(1) {\n"
                + "    background: #666; /* Цвет фона */\n"
                + "    color: #fff; /* Цвет текста */\n"
                + "   } \n"
                + " button {\n"
                + "  display: inline-block;\n"
                + "  font-family: arial,sans-serif;\n"
                + "  font-size: 11px;\n"
                + "  color: rgb(205,216,228);\n"
                + "  text-shadow: 0 -1px rgb(46,53,58);\n"
                + "  text-decoration: none;\n"
                + "  user-select: none;\n"
                + "  line-height: 2em;\n"
                + "  padding: 1px 1.2em;\n"
                + "  outline: none;\n"
                + "  border: 1px solid rgba(33,43,52,1);\n"
                + "  border-radius: 3px;\n"
                + "  background: rgb(81,92,102) linear-gradient(rgb(81,92,102), rgb(69,78,87));\n"
                + "  box-shadow:\n"
                + "   inset 0 1px rgba(101,114,126,1),\n"
                + "   inset 0 0 1px rgba(140,150,170,.8),\n"
                + "   0 1px rgb(83,94,104),\n"
                + "   0 0 1px rgb(86,96,106);\n"
                + "}\n"
                + " button:active {\n"
                + "  box-shadow:\n"
                + "   inset 0 1px 3px rgba(0,10,20,.5),\n"
                + "   0 1px rgb(83,94,104),\n"
                + "   0 0 1px rgb(86,96,106);\n"
                + "}\n"
                + " button:focus:not(:active) {\n"
                + "  border: 1px solid rgb(22,32,43);\n"
                + "  border-bottom: 1px solid rgb(25,34,45);\n"
                + "  background: rgb(53,61,71);\n"
                + "  box-shadow:\n"
                + "   inset 0 1px 3px rgba(0,10,20,.5),\n"
                + "   0 1px rgb(83,94,104),\n"
                + "   0 0 1px rgb(86,96,106);\n"
                + "  pointer-events: none;\n"
                + "}"
                + "  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align='center'>TEST</h1>");
        out.println("<form method='post' >");
        out.println("<input type='number' class='text' name='min' min='1000' max='40000' placeholder='Мин зарплата'>");
        out.println("<input type='number' class='text' name='max' min='1000' max='40000' placeholder='Макс зарплата' >");
        out.println("<button type='submit' >Enter</button>");
        out.println("</form>");
        out.println("<hr/>");
        
        out.println("<table align='center'>"
                + "<tr>"
                + "<th>Vorname</th>"
                + "<th>Nachname</th>"
                + "<th>Salary</th>"
                + "</tr>");
        
        List<EmployeesDTO> list = myBean.g(request.getParameter("min"), request.getParameter("max"));
        if (!list.isEmpty()) {
            
            list.stream().forEach((e) -> {
                out.println(String.format("<tr>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%.2f</td>"
                        + "</tr>", e.getFirstName(), e.getLastName(), (double) e.getSalary()));
            });
            
            out.println("</table>");
        } else {
            out.println("</table>");
            out.println("<div align='center'><font color='#c00000'>Keine Mitarbeiter gefunden</font></div>");
        }
        out.println("<hr/>");
        out.println("<b align='center'>Durchschnittliche Einkommen aller Employees: </b>");
        out.printf("<div align='center'>%.2f</div>", myBean.a2());
        out.println("<hr/>");
        out.println("<b align='center'>Kleinste und grösste Einkommen: </b>");
        for (Object i : myBean.b2()) {
            out.printf("<div align='center' class='x'>%.2f</div>", (double) i);
        }
        out.println("<hr/>");
        
        out.println("<table align='center'>"
                + "<tr>"
                + "<th>Abteilungsname</th>"
                + "<th>Mitarbeiter</th>"
                + "<th>Average Salary</th>"
                + "</tr>");
        myBean.c2a().forEach((e) -> {
            out.println(String.format("<tr>"
                    + "<td>%s</td>"
                    + "<td>%d</td>"
                    + "<td>%.2f</td>"
                    + "</tr>", e[0]==null? "Unbekannt" : e[0], e[1],  e[2]==null? 0.0 : e[2]));
        });
        out.println("</table>");
        
        out.println("<hr/>");
        
        out.println("<table align='center'>"
                + "<tr>"
                + "<th>Abteilungsname</th>"
                + "<th>Mitarbeiter</th>"
                + "<th>Average Salary</th>"
                + "</tr>");
        myBean.c2b().forEach((e) -> {
            out.println(String.format("<tr>"
                    + "<td>%s</td>"
                    + "<td>%d</td>"
                    + "<td>%.2f</td>"
                    + "</tr>", e[1]==null? "Unbekannt" : e[1], e[2],  e[3]==null? 0.0 : e[3]));
        });
        out.println("</table>");

//        out.println("<h1>Method a()</h1>");
//        myBean.a();
//        out.println("<h1>Method b()</h1>");
//        myBean.b(50);
//        out.println("<h1>Method c()</h1>");
//        myBean.c("US");
//        out.println("<h1>Method d()</h1>");
//        myBean.d("Toronto");
//        out.println("<h1>Method e()</h1>");
//        myBean.e("IT");
//        out.println("<h1>Method f()</h1>");
//        myBean.f(20000, 40000);
        out.println("</body>");
        out.println("</html>");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
