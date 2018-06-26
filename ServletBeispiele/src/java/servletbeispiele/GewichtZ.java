package servletbeispiele;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GewichtZ", urlPatterns = {"/GewichtZ"})

public class GewichtZ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println( getAllData(request.getParameter("grosse"), request.getParameter("gewicht"),
                request.getParameter("geschlecht")));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public String getAllData(String... data) {
        
        try {
            switch (data[2]) {
                case "m":
                    return getWeight(0.1, data);
                case "w":
                    return getWeight(0.15, data);
                default:
                    throw new IllegalArgumentException("Falsche Geschlechteingabe!");
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private String getWeight(double x, String... data) {
        try {
            int normal = Integer.parseInt(data[0]);
            if (normal > 100) {
                normal -= 100;
            } else {
                throw new IllegalArgumentException("Grösse passt nicht");
            }
            double ideal = normal - (normal * x);

            String diff = Double.parseDouble(data[1]) == normal ? "Normalgewicht"
                    : Double.parseDouble(data[1]) - normal > 0 ? "Übergewicht" : "Untergewicht";

            return String.format("Normalgewicht für Sie ist: %s\n"
                    + "Idealgewicht für Sie ist: %.2f\n"
                    + "Sie haben %s", normal, ideal, diff);
        } catch (Exception e) {
            throw new IllegalArgumentException("Falsches Format");
        }
    }
}
