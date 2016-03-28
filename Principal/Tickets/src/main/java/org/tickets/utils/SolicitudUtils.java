package org.tickets.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;


public class SolicitudUtils {
	
	private static FacesContext facesContext;

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public static void setFacesContext(FacesContext facesContext) {
		SolicitudUtils.facesContext = facesContext;
	}

	public static void setMensaje(boolean error, String mensaje) {
		Severity severity = FacesMessage.SEVERITY_INFO;
		if (error) {
			severity = FacesMessage.SEVERITY_ERROR;
		}
		facesContext.addMessage(null, new FacesMessage(severity, "Mensaje", mensaje));
	}

}
