/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csrfdoublesubc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KALINDU
 */
@WebServlet(name = "SessionDemo", urlPatterns = {"/SessionDemo"})
public class SessionDemo extends HttpServlet {
    
    
    public static Cookie getCookie(HttpServletRequest request, String name) {
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) { 
                    return cookie;
                }    
            }
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

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
        if(username.equals("admin")&&password.equals("admin")){
            
            //HttpSession session = request.getSession();
            Cookie fk = getCookie(request,"CSRFCookie");
            String Cookie_Name = fk.getName();
            String Cookie_Value = fk.getValue();
            System.out.println(Cookie_Name+" : "+Cookie_Value);
            String token = request.getParameter("token");      
            System.out.println("token in DOM : "+token);
            if(Cookie_Value.equals(token)){
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
           
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
