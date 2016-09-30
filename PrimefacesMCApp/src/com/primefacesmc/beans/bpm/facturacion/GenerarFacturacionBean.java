package com.primefacesmc.beans.bpm.facturacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.facadeservices.app.facturacion.Facturacion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionPeticion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionRespuesta;

@ManagedBean(name="generarFacturacionBean")
@ViewScoped
public class GenerarFacturacionBean {
	private String nombreUsuario;
	
	@ManagedProperty(value="#{facturacion}")
	private Facturacion facturacion;
	
	@PostConstruct
	public void inicializar(){
		GenerarFacturacionPeticion peticion = new GenerarFacturacionPeticion();
		peticion.setIdUsuario(1);
		try{
			System.out.println("Facturacion = "+facturacion);	
			GenerarFacturacionRespuesta respuesta = facturacion.generarFacturacion(peticion);
			nombreUsuario = respuesta.getNombreUsuario();
		}catch(Exception e){
			System.out.println("Error: "+e.getCause());
			e.printStackTrace();
		}
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
