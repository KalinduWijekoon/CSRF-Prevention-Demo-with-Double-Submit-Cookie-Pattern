/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csrfdoublesubc;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author KALINDU
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    
    
    String generateToken(){
            SecureRandom secureRandom = new SecureRandom();
            byte[] buffer = new byte[50];
            secureRandom.nextBytes(buffer);
            return DatatypeConverter.printHexBinary(buffer);
        }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String username = request.getParameter("username");
	String password = request.getParameter("password");
        
        if (username.equals("admin") && password.equals("admin")){
            
            HttpSession session = request.getSession();
            String Session_Id = session.getId();
            Cookie sessionCookie = new Cookie("Session_Cookie",Session_Id);
            response.addCookie(sessionCookie);
            String CSRF_Token = generateToken();
            Cookie CSRF_Cookie = new Cookie("CSRF_Token",CSRF_Token);
            response.addCookie(CSRF_Cookie);
            
            response.sendRedirect("welcome.jsp");
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
