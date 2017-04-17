package com.core.app.otd;

import javax.xml.bind.annotation.XmlTransient;

import com.core.app.modelo.Entidad;


public class PeticionEntidad {
	
	private Entidad entidad;
    
	@XmlTransient
	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
}
