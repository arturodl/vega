package com.primefacesmc.beans.bpm.estadodecuenta;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="estadoDeCuentaBean")
@ViewScoped
public class EstadoDeCuentaBean {
    private String nombreUsuario;
    
    @PostConstruct
    public void inicializar(){
    	nombreUsuario = "Arturo Linares Rincon";
    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
