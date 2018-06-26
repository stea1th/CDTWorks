package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gruesse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <h3>Hallo Welt!</h3>\n");
      out.write("        <h4>Geben Sie Ihren Namen und Ihre Gru&szlig;worte ein, um\n");
      out.write("            die Welt über diese JSP-Seite zu gr&uuml;&szlig;en.</h4>\n");
      out.write("        <form method=\"post\" action=\"\">\n");
      out.write("            <table>\n");
      out.write("                <tr><td align=\"right\">Name</td>\n");
      out.write("                    <td><input type=\"text\" name=\"benutzer\" size=\"40\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td align=\"right\">Gru&szlig;worte</td>\n");
      out.write("                    <td><input type=\"text\" name=\"gruesse\" size=\"80\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td><input type=\"submit\" value=\"Absenden\" /></td>\n");
      out.write("                    <td><input type=\"reset\" value=\"R&uuml;cksetzen\" /></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 String benutzer = request.getParameter("benutzer");
            String gruesse = request.getParameter("gruesse");
            if (benutzer != null && gruesse != null
                    && !benutzer.equals("") && !gruesse.equals("")) {
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "gruesse-modul.jsp", out, false);
      out.write("\n");
      out.write("        ");
 } else {
        
      out.write("\n");
      out.write("        <p>Information: Erster Aufruf dieser Seite oder\n");
      out.write("            Aufruf ohne Parameter in der aktuellen Sitzung.</p>\n");
      out.write("            ");
 }
            
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
