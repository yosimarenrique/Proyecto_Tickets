# encoding: iso-8859-1
Feature: Enviar correo
Background:
Given el usuario ingresa a index.xhtml

Scenario Outline: Enviar mensaje
When el usuario ingresa nombre <nombre>  
And se ingresa la ubicacion <ubicacion>
And se ingresa el telefono <telefono>
And se ingresa la descripcion <descripcion>
And presiona el boton enviar correo   
Then se muestra mensaje de envio

Examples:
|nombre|ubicacion|telefono|descripcion|
|"Juan Valdez"|"Tech TI "|"3005458538"|"Cambio teclado Prueba"|