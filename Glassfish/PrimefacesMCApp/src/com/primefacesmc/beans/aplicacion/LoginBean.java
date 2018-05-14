package com.primefacesmc.beans.aplicacion;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean implements Serializable {
	
	/**  
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String redireccionar;
	private String nombreUsuario;
	private String claveUsuario;	
	
	public void onLogin(ActionEvent event){
		System.out.println("Bienvenido al sistema:"+this.nombreUsuario+", tu clave es: "+this.claveUsuario);
		this.redireccionar = "principal";
	}
	
	public String redireccionar(){
		return this.redireccionar;
	}

	public String getRedireccionar() {
		return redireccionar;
	}

	public void setRedireccionar(String redireccionar) {
		this.redireccionar = redireccionar;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

}
