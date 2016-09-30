package com.primefacesmc.beans.bpm.factibilidades;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="administracionFactibilidadesBean")
@ViewScoped

public class AdministracionFactibilidades {
    private String nombreUsuario;
    
    @PostConstruct
    public void inicializar(){
    	this.nombreUsuario = "Emilio Linares";
    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
