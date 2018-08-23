package com.core.app.otd;

import javax.xml.bind.annotation.XmlTransient;

import com.core.app.modelo.Entidad;

@XmlTransient
public class ObtenerEntidadesPorCriterioPeticion {
		
	private Entidad entidad;
	
	private Class clase;

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	
	@XmlTransient
	public Class getClase() {
		return clase;
	}

	public void setClase(Class clase) {
		this.clase = clase;
	}

}
