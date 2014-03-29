/*
 * 
 */

package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Dan Cannon
 */
@WebServlet(name = "GetTest", urlPatterns  = {"/gettest"})
public class GetTest extends HttpServlet
{
    private static final int serialVersionUID = -5392874;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Request Test</title></head><body>");
        writer.print("<div><h1>Get Paramaters: Values</h1><div>");
        writer.print("<div>Notice the url at the top, you can copy and past that and" +
                " get this same page, try it!");
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String str = (String)names.nextElement();
            writer.print("<div>" + str + ": " + request.getParameter(str) + "</div>");
        }
        writer.print("</body></html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Request Test</title></head><body>");
        writer.print("<div><h1>Post Paramaters: Values</h1><div>");
        writer.print("<div>Notice the url at the top, this way can store more paramaters" +
                " but you can't bookmark the results. Neither is particularly secure!");
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String str = (String)names.nextElement();
            writer.print("<div>" + str + ": " + request.getParameter(str) + "</div>");
        }
        writer.print("</body></html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Test Servlet";
    }

}
