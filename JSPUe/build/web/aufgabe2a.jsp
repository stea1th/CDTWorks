<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<hr/>
<%= getFakult(request.getParameter("zahl"))%>
<hr/>
<%! public String getFakult(String s) {
        Map<String, String> map = getMap();
        if (map.containsKey(s)) {
            return String.format("Fakultät von %s ist gleich %d", map.get(s), fakult(Integer.parseInt(map.get(s))));
        } else if (map.containsValue(s)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(s)) {
                    return String.format("Fakultät von %s ist gleich %d", s, fakult(Integer.parseInt(s)));
                }
            }

        }
        return "Sie haben falsche Eingabe gemacht";
    }

%>

<%! public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Null", "0");
        map.put("Eins", "1");
        map.put("Zwei", "2");
        map.put("Drei", "3");
        map.put("Vier", "4");
        map.put("Fünf", "5");
        map.put("Sechs", "6");
        map.put("Sieben", "7");
        map.put("Acht", "8");
        map.put("Neun", "9");
        map.put("Zehn", "10");
        return map;
    }%>

<%! public long fakult(int i) {
        long sum = 1;
        for (; i > 1; i--) {
            sum *= i;
        }
        return sum;
    }%>
