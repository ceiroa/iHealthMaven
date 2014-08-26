/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.controller.newitem;

import com.ceiroa.ihealthmaven.db.ClientDB;
import com.ceiroa.ihealthmaven.model.Client;
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
public class NewVisitServlet extends HttpServlet { 

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
        request.setAttribute("active", "newVisit");

        //Retrieve all clients from database
        //ArrayList<Client> clients = ClientDB.getClients();
        //request.setAttribute("clients", clients);

        request.setAttribute("infoMessage", "Search for a user to create a visit for:");
        
        String url = "/new/newVisit.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
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
        request.setAttribute("active", "newVisit");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        ArrayList<Client> clients = null;

        if(!lastName.equals("") && !firstName.equals("")) {
             clients = ClientDB.getClientsByFirstAndLastName(firstName, lastName);
        } else if(!lastName.equals("")) {
             clients = ClientDB.getClientsByLastName(lastName);
        } else if(!firstName.equals("")) {
            clients = ClientDB.getClientsByFirstName(firstName);
        }
        request.setAttribute("clients", clients);

        if(clients==null || clients.isEmpty()) {
            request.setAttribute("errorMessage", "No clients found");
        }

        String url = "/new/newVisit.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
