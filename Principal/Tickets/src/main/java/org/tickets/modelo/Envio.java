package org.tickets.modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Envio {

	public boolean enviomensaje(String nombre, String ubicacion, String  telefono, String descripcion, String email){
		  // El correo gmail de envio  
		  String correoEnvia = "solicitudesti@gmail.com";  
		  String claveCorreo = "solicitudesti123";  
		  boolean mensaje;
		  
		  //  
		  Properties properties = new Properties();  
		  properties.put("mail.smtp.host", "smtp.gmail.com");  
		  properties.put("mail.smtp.starttls.enable", "true");  
		  properties.put("mail.smtp.port", "587");  
		  properties.put("mail.smtp.auth", "true");  
		  properties.put("mail.user", correoEnvia);  
		  properties.put("mail.password", claveCorreo);  
		  
		  
		  Session session = Session.getInstance(properties, null);  
		  
		  try {  
		    
		   MimeMessage mimeMessage = new MimeMessage(session);  
		  
		     
		   mimeMessage.setFrom(new InternetAddress(correoEnvia, nombre));  
		     
		     
		   InternetAddress[] internetAddresses = {  
		     new InternetAddress(email)};  
		  
		      
		   mimeMessage.setRecipients(Message.RecipientType.TO,  
		     internetAddresses);  
		  
		     
		   mimeMessage.setSubject("Solicitud TI");  
		  
		     
		   MimeBodyPart mimeBodyPart = new MimeBodyPart();  
		  
		   
		   mimeBodyPart.setContent("<table width='100%' cellspacing='0' cellpadding='0' border='0' bgcolor='2499CC' >" 
				   +"<tr><td align='center' > <b><font face='verdana,arial,helvetica' size='4' color='ffffff'>Solicitud TI</font></b></td>" 
				   +"</tr></table> "
				   +"<table width='100%' cellspacing='0' cellpadding='2' border='0'>" 
				   +"<tr><td  width='20%'><img src='http://www.techandsolve.com/web/images/logo.png' alt='logo tech' width='150' height='180'></td><td  width='5%'></td><td valign='top'><b><font face='verdana,arial,helvetica' size='3' color='2499CC'>Soy</font>"
				   +"<font face='verdana,arial,helvetica' size='4' color='2499CC'><br>Solver<br></font>"+nombre+"</b>"
				   +"<br><br> <b><font face='verdana,arial,helvetica' size='4' color='2499CC'>DESCRIPCION DE LA SOLICITUD</font>" 
				   +"<br><br>"+descripcion+"</b><br><br><br><br>"
				   + "<b><font face='verdana,arial,helvetica' size='4' color='2499CC'>Ubicacion</font>"
				   +"<br>"+ubicacion+"</b><br><br><b><font face='verdana,arial,helvetica' size='4' color='2499CC'>Telefono</font>"
				   	+ "<br>"+telefono+"</b><b></td></tr></table> ", "text/html");
		  
		    
		   Multipart multipart = new MimeMultipart();  
		   multipart.addBodyPart(mimeBodyPart);  
		    
		   mimeMessage.setContent(multipart);  
		    
		   Transport transport = session.getTransport("smtp");  
		  transport.connect(correoEnvia, claveCorreo);  
		   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());  
		   transport.close();  
		   
		   mensaje=true;
		  
		  } catch (Exception ex) {  
			  mensaje=false;
			
		  }  
		   
		  return mensaje;
	}
	
}
