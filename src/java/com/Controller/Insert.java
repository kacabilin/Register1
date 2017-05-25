/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import Commands.SQLOperations;
import com.Model.Profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADI
 */
@WebServlet(name = "Insert", urlPatterns = {"/insert.php"})
public class Insert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
                int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		
		Connection connection = SQLOperations.getConnection();
		
		Profile profile = new Profile();
                profile.setId(id);
		profile.setFirst_name(first_name);
		profile.setLast_name(last_name);
		profile.setUsername(username);
		profile.setPassword(password);
		profile.setConfirm_password(confirm_password);
		
		if(SQLOperations.un(username)){
			out.print("<script type=\"text/javascript\">");
			 out.println("alert('Username Already exist');");
			 out.println("location=window.history.back();");
			 out.println("</script>");
			out.close();
		}else{
		if(password.equals(confirm_password)){
			SQLOperations.addUser(profile, connection);
			out.print("<script type=\"text/javascript\">");
			 out.println("alert('Sucess');");
			 out.println("location='register.jsp';");
			 out.println("</script>");
			out.close();
			System.out.println(connection);
		}else{
			out.print("<script type=\"text/javascript\">");
			 out.println("alert('Password not match');");
			 out.println("location=window.history.back();");
			 out.println("</script>");
			out.close();	
		}
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException {
        processRequest(request, response);
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
