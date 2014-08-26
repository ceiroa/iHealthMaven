/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.db;

import com.ceiroa.ihealthmaven.db.forms.LumbarSpineDB;
import com.ceiroa.ihealthmaven.db.forms.LowerExtremitiesDB;
import com.ceiroa.ihealthmaven.db.forms.UpperExtremitiesDB;
import com.ceiroa.ihealthmaven.db.forms.CervicalSpineDB;
import com.ceiroa.ihealthmaven.model.forms.CervicalSpineVisit;
import com.ceiroa.ihealthmaven.model.forms.LowerExtremitiesVisit;
import com.ceiroa.ihealthmaven.model.forms.LumbarSpineVisit;
import com.ceiroa.ihealthmaven.model.forms.UpperExtremitiesVisit;
import com.ceiroa.ihealthmaven.model.forms.iVisit;
import java.util.ArrayList;

/**
 *
 * @author ceiroa
 */
public class VisitsDB {

    private final static CervicalSpineDB csDB = new CervicalSpineDB();
    private final static LowerExtremitiesDB leDB = new LowerExtremitiesDB();
    private final static LumbarSpineDB lsDB = new LumbarSpineDB();
    private final static UpperExtremitiesDB ueDB = new UpperExtremitiesDB();

    private final static String csTableName = "cervicalSpineVisits";
    private final static String leTableName = "lowerExtremitiesVisits";
    private final static String lsTableName = "lumbarSpineVisits";
    private final static String ueTableName = "upperExtremitiesVisits";

    private final static iVisit csInstance = new CervicalSpineVisit();
    private final static iVisit leInstance = new LowerExtremitiesVisit();
    private final static iVisit lsInstance = new LumbarSpineVisit();
    private final static iVisit ueInstance = new UpperExtremitiesVisit();

    public static boolean isVisitsForClient(String clientId) {
        ArrayList<iVisit> csVisits = csDB.getVisitsForClient(clientId, csTableName, csInstance);
        if(!csVisits.isEmpty())
            return true;
        ArrayList<iVisit> leVisits = leDB.getVisitsForClient(clientId, leTableName, leInstance);
        if(!leVisits.isEmpty())
            return true;
        ArrayList<iVisit> lsVisits = lsDB.getVisitsForClient(clientId, lsTableName, lsInstance);
        if(!lsVisits.isEmpty())
            return true;
        ArrayList<iVisit> ueVisits = ueDB.getVisitsForClient(clientId, ueTableName, ueInstance);
        if(!ueVisits.isEmpty())
            return true;
        
        return false;
    }

    public ArrayList<iVisit> getVisitsForClient(String clientId) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getVisitsForClient(clientId, csTableName, csInstance));
        visits.addAll(leDB.getVisitsForClient(clientId, leTableName, leInstance));
        visits.addAll(lsDB.getVisitsForClient(clientId, lsTableName, lsInstance));
        visits.addAll(ueDB.getVisitsForClient(clientId, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisits() {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisits(csTableName, csInstance));
        visits.addAll(leDB.getAllVisits(leTableName, leInstance));
        visits.addAll(lsDB.getAllVisits(lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisits(ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDate(String date) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDate(date, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByDate(date, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByDate(date, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByDate(date, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByLastName(String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByLastName(lastName, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByLastName(lastName, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByLastName(lastName, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByLastName(lastName, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByFirstName(String firstName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByFirstName(firstName, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByFirstName(firstName, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByFirstName(firstName, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByFirstName(firstName, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByFirstLastName(String firstName, String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByFirstLastName(firstName, lastName, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByFirstLastName(firstName, lastName, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByFirstLastName(firstName, lastName, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByFirstLastName(firstName, lastName, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDateLastName(String date, String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDateLastName(date, lastName, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByDateLastName(date, lastName, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByDateLastName(date, lastName, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByDateLastName(date, lastName, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDateFirstName(String date, String firstName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDateFirstName(date, firstName, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByDateFirstName(date, firstName, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByDateFirstName(date, firstName, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByDateFirstName(date, firstName, ueTableName, ueInstance));

        return visits;
    }

    public ArrayList<iVisit> getAllVisitsByDateFirstLastName(String date, String firstName, String lastName) {
        ArrayList<iVisit> visits = new ArrayList<iVisit>();

        visits.addAll(csDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, csTableName, csInstance));
        visits.addAll(leDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, leTableName, leInstance));
        visits.addAll(lsDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, lsTableName, lsInstance));
        visits.addAll(ueDB.getAllVisitsByDateFirstLastName(date, firstName, lastName, ueTableName, ueInstance));

        return visits;
    }
}
