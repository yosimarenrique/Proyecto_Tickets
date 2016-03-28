package org.tickets.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.tickets.bean.Empleado;
import org.tickets.modelo.EmpleadoDao;



@ManagedBean
@SessionScoped
public class AdminBean {
	
	@Inject
	private EmpleadoDao dao;
	
	public AdminBean() {
		// TODO Auto-generated constructor stub
	}
	
	Empleado empleado=new Empleado();

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public String verificarDatos() throws Exception {
		
//		EmpleadoDao empDao=new EmpleadoDao();
		
		Empleado emp;
		String resultado;

		try {
			

			emp = dao.verificarDatos(empleado);
			if (emp != null) {


				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", emp);
				resultado = "index"; 
				
			} else {
				resultado = "error";
			}
		} catch (Exception e) {
			throw e;
		}

		return resultado;
	}

	

	

}
