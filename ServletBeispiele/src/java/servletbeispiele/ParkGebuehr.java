package servletbeispiele;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParkGebuehr", urlPatterns = {"/ParkGebuehr"})

public class ParkGebuehr extends HttpServlet {
    private int stunde, minute;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println(getParkGeb(request.getParameter("stunde"), request.getParameter("minute")));
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private boolean proof() {
        return 0 <= stunde && stunde <= 23 && 0 <= minute && minute <= 59;
    }

    private int transformToMin() {
        return stunde * 60 + minute;
    }

    public String getParkGeb(String stunde, String minute) throws Exception {
        double sum = 2.5;
        try {
            this.stunde = Integer.parseInt(stunde);
            this.minute = Integer.parseInt(minute);
        } catch (NumberFormatException e) {
            throw new Exception("Bitte nur Zahlen eingeben!");
        }

        if (proof()) {
            if (transformToMin() <= 120) {
                return String.format("%.2f", sum);
            } else {
                int rest = transformToMin() - 120;
                while (rest > 0) {
                    sum += 0.5;
                    rest -= 30;
                }
                return String.format("%.2f", sum > 9 ? 9 : sum);
            }
        }
        return ("Falsche Stunden/Minuten Eingabe");
    }
}
