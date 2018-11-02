package com.egg.facilitadores.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumno {
	
	@Id
	private Integer documento;
	
	private String nombre;
	private String apellido;


	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

}
