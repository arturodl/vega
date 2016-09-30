package com.primefacesmc.beans.bpm.factibilidades;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.facadeservices.app.factibilidades.Factibilidades;

@ManagedBean(name="administracionFactibilidadesBean")
@ViewScoped

public class AdministracionFactibilidades {
    private String nombreUsuario;
    
    @ManagedProperty(value="#{factibilidades}")
    private Factibilidades factibilidades;
    
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
	
	public Factibilidades getFactibilidades() {
		return factibilidades;
	}

	public void setFactibilidades(Factibilidades factibilidades) {
		this.factibilidades = factibilidades;
	}
}
