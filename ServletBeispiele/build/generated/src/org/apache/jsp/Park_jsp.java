package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Park_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Parkgebühren</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2 align=\"center\">Parkgebühren</h2><br><hr/>\n");
      out.write("        \n");
      out.write("        <form method=\"post\" action=\"\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <th style=\"width: 120px\" align=\"left\">Parkzeiteingabe:</th>\n");
      out.write("                    <th><input type=\"text\" name=\"stunde\" style=\"width: 50px\"></th>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th></th>\n");
      out.write("                    <th><input type=\"text\" name=\"minute\" style=\"width: 50px\"></th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"2\" align=\"right\"><input type=\"submit\" value=\"Send\"></th>\n");
      out.write("                </tr>\n");
      out.write("            </table><br>\n");
      out.write("            <hr/>\n");
      out.write("            <table align=\"center\">\n");
      out.write("                <tr >\n");
      out.write("                    <th align=\"left\" style=\"width: 100px\">Parkzeit:</th>\n");
      out.write("                    <th align=\"left\" style=\"width: 70px\">Parkgebühr:</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"2\"><hr/></th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align=\"center\">");
 if(request.getParameter("stunde")!=null|request.getParameter("minute")!=null){
                        out.println(String.format("<b>%s</b> Std. <b>%s</b> Minuten",request.getParameter("stunde") ,request.getParameter("minute"))); }
      out.write("</td>\n");
      out.write("                    <td align=\"center\">\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ParkGebuehr", out, false);
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table><hr/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
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
