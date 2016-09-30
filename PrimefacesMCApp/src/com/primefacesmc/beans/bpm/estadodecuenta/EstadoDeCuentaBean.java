package com.primefacesmc.beans.bpm.estadodecuenta;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.facadeservices.app.cuentasporcobrar.CuentasPorCobrar;

@ManagedBean(name="estadoDeCuentaBean")
@ViewScoped
public class EstadoDeCuentaBean {
    private String nombreUsuario;
    
    @ManagedProperty(value="#{cuentasPorCobrar}")
    private CuentasPorCobrar cuentasPorCobrarFacade;
        
    @PostConstruct
    public void inicializar(){
    	nombreUsuario = "Arturo Linares Rincon";
    }

	public CuentasPorCobrar getCuentasPorCobrarFacade() {
		return cuentasPorCobrarFacade;
	}

	public void setCuentasPorCobrarFacade(CuentasPorCobrar cuentasPorCobrarFacade) {
		this.cuentasPorCobrarFacade = cuentasPorCobrarFacade;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
