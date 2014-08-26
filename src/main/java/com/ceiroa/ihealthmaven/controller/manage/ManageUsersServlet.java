/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.controller.manage;

import com.ceiroa.ihealthmaven.db.UserDB;
import com.ceiroa.ihealthmaven.model.PropsHandlerFactory;
import com.ceiroa.ihealthmaven.model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ceiroa
 */
public class ManageUsersServlet extends HttpServlet {

    private String manageUsersJsp = PropsHandlerFactory.getHandler().getProperty
            ("controller.manage.ManageUsersServlet.jsp");
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("active", "manageUsers");

        //Retrieve all users from database
        ArrayList<User> users = UserDB.getUsers();
        request.setAttribute("users", users);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(manageUsersJsp);
        dispatcher.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //If the request is to deactivate a merchant
        if(!request.getParameter("id").equals("0")
                && request.getParameter("action").equals("deactivate")) {
            UserDB.deactivate(Long.parseLong(request.getParameter("id")));
        }

        if(!request.getParameter("id").equals("0")
                && request.getParameter("action").equals("activate")) {
            UserDB.activate(Long.parseLong(request.getParameter("id")));
        }

        //Retrieve all users from database
        ArrayList<User> users = UserDB.getUsers();
        request.setAttribute("users", users);
        
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(manageUsersJsp);
        dispatcher.forward(request, response);
    }
}
