package com.primefacesmc.beans.bpm.facturacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="generarFacturacionBean")
@ViewScoped
public class GenerarFacturacionBean {
	private String nombreUsuario;
	
	@PostConstruct
	public void inicializar(){
		nombreUsuario="Melissa Linares";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
