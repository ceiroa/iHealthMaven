/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.controller.manage;

import com.ceiroa.ihealthmaven.db.VisitsDB;
import com.ceiroa.ihealthmaven.model.DateHelper;
import com.ceiroa.ihealthmaven.model.PropsHandlerFactory;
import com.ceiroa.ihealthmaven.model.forms.iVisit;
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
public class ManageVisitsServlet extends HttpServlet {

    private String manageVisitsJsp = PropsHandlerFactory.getHandler().getProperty
            ("controller.manage.ManageVisitsServlet.jsp");
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
        request.setAttribute("active", "visits");
        request.setAttribute("infoMessage", "Search for visits to view, edit, or delete:    ");

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(manageVisitsJsp);
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
        request.setAttribute("active", "visits");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String date = request.getParameter("date");

        boolean dateFormatCorrect = true;

        ArrayList<iVisit> visits = null;
        
        if(!date.equals("") && DateHelper.isCorrectFormat(date)){
            request.setAttribute("errorMessage", "Please enter date in format yyyy-MM-dd");
            dateFormatCorrect = false;
        } else {
            boolean searchByDate = (date != null && !date.equals("") && dateFormatCorrect);
            boolean searchByFirstName = (firstName!=null && !firstName.equals(""));
            boolean searchByLastName = (lastName!=null && !lastName.equals(""));

            VisitsDB vDB = new VisitsDB();

            if(searchByDate && searchByFirstName && searchByLastName) {
                visits = vDB.getAllVisitsByDateFirstLastName(date, firstName, lastName);
            }else if (searchByDate && searchByFirstName){
                visits = vDB.getAllVisitsByDateFirstName(date, firstName);
            }else if (searchByDate && searchByLastName){
                visits = vDB.getAllVisitsByDateLastName(date, lastName);
            }else if(searchByFirstName && searchByLastName){
                visits = vDB.getAllVisitsByFirstLastName(firstName, lastName);
            }else if(searchByFirstName) {
                visits = vDB.getAllVisitsByFirstName(firstName);
            } else if(searchByLastName) {
                visits = vDB.getAllVisitsByLastName(lastName);
            } else if(searchByDate) {
                visits = vDB.getAllVisitsByDate(date);
            }
        }

        request.setAttribute("visits", visits);

        if((visits==null || visits.isEmpty()) && dateFormatCorrect) {
            request.setAttribute("errorMessage", "No visits found");
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(manageVisitsJsp);
        dispatcher.forward(request, response);
    }
}
