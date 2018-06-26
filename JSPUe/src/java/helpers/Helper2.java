/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author stea1th
 */
public class Helper2 {

    private String[] data;

    public Helper2(String[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("Nicht alle Daten wurde eingegeben");
        }
        this.data = data;
    }

    public String getAllData() {
        switch (data[2].substring(0, 1).toLowerCase()) {
            case "m":
                return getWeight(0.1);
            case "w":
                return getWeight(0.15);
            default:
                throw new IllegalArgumentException("Falsche Geschlecht eingabe!");
        }
    }

    private String getWeight(double x) {
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
