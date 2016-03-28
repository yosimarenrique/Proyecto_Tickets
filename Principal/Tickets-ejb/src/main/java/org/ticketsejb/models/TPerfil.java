/**
*
* @author yosimar.valega
* @date: 08/03/2016
* 
*/


package org.ticketsejb.models;




import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="perfil" , schema = "solicitud")
public class TPerfil implements Serializable{
	
	
	public TPerfil(){
		
	}
	
	public TPerfil(String perfil){
		this.perfil=perfil;
	};

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Basic (optional=false)
	@Column (name="codigo")
	private Integer codigo;
	

	@Basic (optional=false)
	@Column (name="perfil")
	private String perfil;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	

}
