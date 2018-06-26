package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aufgabe1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public long fakult(int i){
    long sum = 1;
    for(; i > 1; i--) sum *= i;
    return sum; 
}
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <style>\n");
      out.write("            name{font-size: 35px; font-style: oblique; color: green;}\n");
      out.write("            .zahl{width: 120px}\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("        <title>JSP Aufgabe</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"\" method=\"post\" id=\"nameform\">\n");
      out.write("            Geben Sie was ein:\n");
      out.write("            <input type=\"text\" name=\"mytext\"><br>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        <p align=\"center\"><b>");
      out.print( request.getParameter("mytext")
        );
      out.write("</b></p>\n");
      out.write("        <table align=\"center\" border=\"2px\">\n");
      out.write("            <tr>\n");
      out.write("                <th colspan=\"2\"><name>Fakultäten</name></th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th class=\"zahl\"><h3>Zahl</h3></th>\n");
      out.write("                <th class=\"zahl\"><h3>Fakultät</h3></th>\n");
      out.write("            </tr>\n");
      out.write("            ");
 for (int i = 0; i <= Integer.parseInt(request.getParameter("mytext")); i++) {
      out.write("\n");
      out.write("            <tr style=\"background-color: ");
      out.print( i % 2 == 0 ? "lightblue" : "lightyellow");
      out.write("\" align=\"right\">\n");
      out.write("                <td>");
      out.print( i);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( fakult(i));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <button  type=\"submit\" form=\"nameform\" value=\"Submit\">Submit</button>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
