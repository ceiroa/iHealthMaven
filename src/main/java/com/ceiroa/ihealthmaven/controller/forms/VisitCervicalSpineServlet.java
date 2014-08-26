/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.controller.forms;

import com.ceiroa.ihealthmaven.db.forms.CervicalSpineDB;
import com.ceiroa.ihealthmaven.model.forms.CervicalSpineVisit;
import com.ceiroa.ihealthmaven.model.DateHelper;
import com.ceiroa.ihealthmaven.model.IntHelper;
import com.ceiroa.ihealthmaven.model.forms.iVisit;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ceiroa
 */
public class VisitCervicalSpineServlet extends VisitCustomHttpServlet {

    private final static String tableName = "cervicalSpineVisits";
    private final static iVisit instance = new CervicalSpineVisit();

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

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(visitCervicalSpineJsp);
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

        String visitId = request.getParameter("visitId");
        String clientId = request.getParameter("clientId");
        String postReqSource = request.getParameter("postReqSource");
        String noMenu = request.getParameter("noMenu");

        request.setAttribute("visitId", visitId);
        request.setAttribute("clientId", clientId);
        request.setAttribute("noMenu", noMenu);

        String url="";
        
        //Save new visit - The user already filled the information
        if(postReqSource.equals("entryForm") && !clientId.isEmpty() && visitId.isEmpty()) {
            iVisit visit = new CervicalSpineVisit();
            VisitHelper.setCommonFields(visit, request);
            VisitHelper.setDateCreated(visit, request);
            //Set cervicalSpine-specific fields
            setVisitFields(visit, request);

            int success = CervicalSpineDB.insert(visit, tableName);
            if(success==1) {
                request.setAttribute("successMessage", newVisitSuccessMessage);
            } else {
                request.setAttribute("errorMessage", newVisitErrorMessage);
            }
            url = newVisitJsp;
        //View existing visit
        } else if(postReqSource.equals("visitsLog") && !visitId.isEmpty()) {
            CervicalSpineDB csDB = new CervicalSpineDB();
            iVisit visit = csDB.getVisitByID(visitId, tableName, instance);
            request.setAttribute("visit", visit);
            String dateCreated = visit.getDateCreated();
            if(dateCreated != null) {
                request.setAttribute("date", dateCreated);
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = visitCervicalSpineJsp;
        //Update existing visit
        } else if(postReqSource.equals("entryForm") && !visitId.isEmpty()) {
            String date = request.getParameter("dateCreated");
            if(!date.isEmpty()) {
                iVisit visit = new CervicalSpineVisit();
                visit.setId(Long.parseLong(visitId));
                visit.setClientId(Long.parseLong(clientId));
                VisitHelper.setCommonFields(visit, request);
                VisitHelper.setDateCreated(visit, request);
                setVisitFields(visit, request);

                int message = CervicalSpineDB.update(visit, Integer.parseInt(visitId),
                        tableName);

                if(message!=0) {
                    CervicalSpineDB.updateDateCreated(visit, Integer.parseInt(visitId),
                            tableName);
                    request.setAttribute("successMessage", updateVisitSuccessMessage);
                } else {
                    request.setAttribute("errorMessage", updateVisitErrorMessage);
                }
            } else {
                request.setAttribute("errorMessage", enterValidDateMessage);
            }
            request.setAttribute("active", "visits");
            url = manageVisitsJsp;
        //The user wants to create a new visit. We check first if
        //a visit of this type exists for this client
        } else {
            CervicalSpineDB csDB = new CervicalSpineDB();
            iVisit visit = csDB.getVisitByClientID(clientId, tableName, instance);
            if(visit != null) {
                request.setAttribute("visit", visit);
                request.setAttribute("date", visit.getDateCreated());
            } else {
                request.setAttribute("date", DateHelper.now());
            }
            url = visitCervicalSpineJsp;
        }
        
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void setVisitFields(iVisit visit, HttpServletRequest request) {
        ((CervicalSpineVisit)visit).setFlex(IntHelper.parseInt(request.getParameter("flex")));
        ((CervicalSpineVisit)visit).setLlf(IntHelper.parseInt(request.getParameter("llf")));
        ((CervicalSpineVisit)visit).setLlr(IntHelper.parseInt(request.getParameter("llr")));
        ((CervicalSpineVisit)visit).setExt(IntHelper.parseInt(request.getParameter("ext")));
        ((CervicalSpineVisit)visit).setRlf(IntHelper.parseInt(request.getParameter("rlf")));
        ((CervicalSpineVisit)visit).setRlr(IntHelper.parseInt(request.getParameter("rlr")));
        ((CervicalSpineVisit)visit).setJacksonComp(request.getParameter("jacksonComp"));
        ((CervicalSpineVisit)visit).setMaxComp(request.getParameter("maxComp"));
        ((CervicalSpineVisit)visit).setShoulderDep(request.getParameter("shoulderDep"));
        ((CervicalSpineVisit)visit).setSotoHall(request.getParameter("sotoHall"));
        ((CervicalSpineVisit)visit).setSpurlings(request.getParameter("spurlings"));
        ((CervicalSpineVisit)visit).setCsDistraction(request.getParameter("csDistraction"));
        ((CervicalSpineVisit)visit).setValsavas(request.getParameter("valsavas"));
        ((CervicalSpineVisit)visit).setBaccody(request.getParameter("baccody"));
        ((CervicalSpineVisit)visit).setLatArm(request.getParameter("latArm"));
        ((CervicalSpineVisit)visit).setLatForearm(request.getParameter("latForearm"));
        ((CervicalSpineVisit)visit).setMiddleFinger(request.getParameter("middleFinger"));
        ((CervicalSpineVisit)visit).setMedForearm(request.getParameter("medForearm"));
        ((CervicalSpineVisit)visit).setMedArm(request.getParameter("medArm"));
        ((CervicalSpineVisit)visit).setBiceps(request.getParameter("biceps"));
        ((CervicalSpineVisit)visit).setBrachiorad(request.getParameter("brachiorad"));
        ((CervicalSpineVisit)visit).setTriceps(request.getParameter("triceps"));
        ((CervicalSpineVisit)visit).setShoulderAbd(request.getParameter("shoulderAbd"));
        ((CervicalSpineVisit)visit).setWristExt(request.getParameter("wristExt"));
        ((CervicalSpineVisit)visit).setWristFlex(request.getParameter("wristFlex"));
        ((CervicalSpineVisit)visit).setFingerExt(request.getParameter("fingerExt"));
        ((CervicalSpineVisit)visit).setFingerFlex(request.getParameter("fingerFlex"));
        ((CervicalSpineVisit)visit).setFingerAbd(request.getParameter("fingerAbd"));
    }
}
