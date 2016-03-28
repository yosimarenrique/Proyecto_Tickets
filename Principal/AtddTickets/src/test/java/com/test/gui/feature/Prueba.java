package com.test.gui.feature;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Prueba {
	
	private Utils util;
	private WebDriver driver;
	
	public Prueba(){
		
		util = Utils.getInstance();
		driver = util.getWebDriver();
		
	}
	

@Given("^el usuario ingresa a index.xhtml$")
public void el_usuario_ingresa_a_index_xhtml() throws Throwable {
    // Express the Regexp above with the code you wish you had
	driver.get("http://localhost:8080/Tickets/faces/index.xhtml");
    
}

@When("^el usuario ingresa nombre \"([^\"]*)\"$")
public void el_usuario_ingresa_nombre(String nombre) throws Throwable {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions
			.visibilityOfElementLocated(By.id("envio:nombre"))).sendKeys(nombre);
}

@When("^se ingresa la ubicacion \"([^\"]*)\"$")
public void se_ingresa_la_ubicacion(String ubicacion) throws Throwable {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions
			.visibilityOfElementLocated(By.id("envio:ubicacion"))).sendKeys(ubicacion);
}

@When("^se ingresa el telefono \"([^\"]*)\"$")
public void se_ingresa_el_telefono(String telefono) throws Throwable {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions
			.visibilityOfElementLocated(By.id("envio:telefono"))).sendKeys(telefono);
}

@When("^se ingresa la descripcion \"([^\"]*)\"$")
public void se_ingresa_la_descripcion(String descripcion) throws Throwable {
	(new WebDriverWait(driver, 10)).until(ExpectedConditions
			.visibilityOfElementLocated(By.id("envio:descripcion"))).sendKeys(descripcion);
	
}

@When("^presiona el boton enviar correo$")
public void presiona_el_boton_enviar_correo() throws Throwable {
	WebElement btnenviar = driver.findElement(By.id("envio:btnenviar"));
	btnenviar.click();
}

@Then("^se muestra mensaje de envio$")
public void se_muestra_mensaje_de_envio() throws Throwable {
	Thread.sleep(4000);
	String mensajeExito = driver.findElement(By.xpath("//*[@id=\"mensaje_container\"]/div/div/div[2]/p")).getText();
	
	Assert.assertEquals("Correo enviado Exitosamente", mensajeExito);
}

@cucumber.api.java.After
public void tearDown(){
	driver.quit();
}


}
