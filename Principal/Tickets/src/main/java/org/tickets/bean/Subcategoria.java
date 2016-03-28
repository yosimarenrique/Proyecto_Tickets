package org.tickets.bean;
// default package
// Generated 22-feb-2016 14:08:11 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Subcategoria generated by hbm2java
 */
public class Subcategoria implements java.io.Serializable {

	private Integer codigo;
	private Categoria categoria;
	private String nombre;
	private Set solicituds = new HashSet(0);

	public Subcategoria() {
	}

	public Subcategoria(Categoria categoria, String nombre) {
		this.categoria = categoria;
		this.nombre = nombre;
	}

	public Subcategoria(Categoria categoria, String nombre, Set solicituds) {
		this.categoria = categoria;
		this.nombre = nombre;
		this.solicituds = solicituds;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(Set solicituds) {
		this.solicituds = solicituds;
	}

}
