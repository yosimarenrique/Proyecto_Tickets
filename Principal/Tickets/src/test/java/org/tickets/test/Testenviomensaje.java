package org.tickets.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tickets.bean.*;
import org.tickets.modelo.Envio;




public class Testenviomensaje {
	
Envio envio=new Envio();
Solicitud solicitud=new Solicitud();

	String email;
	
	@Before
	public void init(){
		
		solicitud.setNombre("Yosimar Valega");
		solicitud.setUbicacion("TI");
		solicitud.setTelefono("3005458538");
		solicitud.setDescripcion("Cambio computador y soporte");
		email="solicitudesti@gmail.com";
		 
	}
	
	@Test
	public void testEnviarMensaje(){
		boolean mensaje;
		
			mensaje = envio.enviomensaje(solicitud.getNombre(), solicitud.getUbicacion(), solicitud.getTelefono(), solicitud.getDescripcion(),email);
			Assert.assertEquals(true, mensaje);
		
		
	}
	

}
