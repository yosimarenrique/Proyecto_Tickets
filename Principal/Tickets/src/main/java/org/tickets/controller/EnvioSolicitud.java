package org.tickets.controller;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.tickets.bean.Solicitud;
import org.tickets.modelo.Envio;

@ManagedBean
public class EnvioSolicitud {
	

	
	private Solicitud solicitud=new Solicitud();
	private Envio envio=new Envio();
	
	public EnvioSolicitud (){
	       
		
	}
	
	

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	
	
	public void enviarsolicitud(){
		
		String email="juandavid.valencia@techandsolve.com";
		
		FacesContext facesContext= FacesContext.getCurrentInstance();
		FacesMessage m = null;
		
		
		boolean mensaje;
		
		   
			mensaje=envio.enviomensaje(solicitud.getNombre(),solicitud.getUbicacion(),solicitud.getTelefono(),solicitud.getDescripcion(),email);
		
			
		   
		   if(mensaje){
			   m = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Correo enviado Exitosamente");
			
		   }else{
			   m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Correo no enviado");
				
		   }
			facesContext.addMessage(null, m);
		
	}
	
	

}

