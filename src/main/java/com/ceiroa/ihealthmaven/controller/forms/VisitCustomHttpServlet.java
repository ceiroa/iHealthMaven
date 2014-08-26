package com.ceiroa.ihealthmaven.controller.forms;

import com.ceiroa.ihealthmaven.model.PropertiesHandler;
import com.ceiroa.ihealthmaven.model.PropsHandlerFactory;
import javax.servlet.http.HttpServlet;

public class VisitCustomHttpServlet extends HttpServlet {

    PropertiesHandler handler = PropsHandlerFactory.getHandler();

    protected String visitCervicalSpineJsp = handler.getProperty
            ("controller.forms.VisitCervicalSpineServlet.jsp");
    protected String visitLowerExtremitiesJsp = handler.getProperty
            ("controller.forms.VisitLowerExtremitiesServlet.jsp");
    protected String visitLumbarSpineJsp = handler.getProperty
            ("controller.forms.VisitLumbarSpineServlet.jsp");
    protected String visitUpperExtremitiesJsp = handler.getProperty
            ("controller.forms.VisitUpperExtremitiesServlet.jsp");

    protected String newVisitJsp = handler.getProperty
            ("controller.new.NewVisitSerlvlet.jsp");
    protected String manageVisitsJsp = handler.getProperty
            ("controller.manage.ManageVisitsServlet.jsp");

    protected String newVisitSuccessMessage = handler.getProperty
            ("message.newVisitSuccess");
    protected String newVisitErrorMessage = handler.getProperty
            ("message.newVisitError");
    protected String updateVisitSuccessMessage = handler.getProperty
            ("message.updateVisitSuccess");
    protected String updateVisitErrorMessage = handler.getProperty
            ("message.updateVisitError");
    protected String enterValidDateMessage = handler.getProperty
            ("message.enterValidDate");
}
