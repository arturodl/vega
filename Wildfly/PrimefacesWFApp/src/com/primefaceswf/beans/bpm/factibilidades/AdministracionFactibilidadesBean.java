package com.primefaceswf.beans.bpm.factibilidades;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="administracionFactibilidadesBean")
@ViewScoped
public class AdministracionFactibilidadesBean {
	private String nombreUsuario;
    
    /*@ManagedProperty(value="#{factibilidades}")
    private Factibilidades factibilidades;
    */
	
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
	
	/*
	public Factibilidades getFactibilidades() {
		return factibilidades;
	}

	public void setFactibilidades(Factibilidades factibilidades) {
		this.factibilidades = factibilidades;
	}
	*/
}
