/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.controller;

import com.ceiroa.ihealthmaven.model.AccessController;
import com.ceiroa.ihealthmaven.model.PropertiesHandler;
import com.ceiroa.ihealthmaven.model.PropsHandlerFactory;
import com.ceiroa.ihealthmaven.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ceiroa
 */
public class IndexServlet extends HttpServlet {

    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PropertiesHandler handler = PropsHandlerFactory.getHandler();
        request.setAttribute("versionNumber", handler.getProperty("versionNumber"));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Get params from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Find user
        User user = null;
        try {
            user = AccessController.findUser(username, password);
        } catch (Exception ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url;

        if(user!=null) {
            //Create session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1800);
            session.setAttribute("user", user);

            //Redirect to home page
            url = "/home.jsp";
        } else {
            //Send back to log in page with error message
            request.setAttribute("errorMessage", "Wrong Username <br/> or Password");

            url = "/index.jsp";
        }
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
