package com.primefacesmc.beans.bpm.facturacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.facadeservices.app.facturacion.Facturacion;

@ManagedBean(name="generarFacturacionBean")
@ViewScoped
public class GenerarFacturacionBean {
	private String nombreUsuario;
	
	@ManagedProperty(value="#{facturacion}")
	private Facturacion facturacion;
	
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

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}
}
