package com.primefacesmc.beans.bpm.compras;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="enviosDeProveedorBean")
@ViewScoped
public class EnviosDeProveedorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgBienvenida;
	
	@PostConstruct
	private void inicializar(){
		System.out.println("Inicializando enviosDeProveedorBean");
		this.msgBienvenida = "Bienvenido a la Pagina de Envios de Proveedor";
		System.out.println("Finalizando enviosDeProveedorBean");
	}

	public String getMsgBienvenida() {
		return msgBienvenida;
	}

	public void setMsgBienvenida(String msgBienvenida) {
		this.msgBienvenida = msgBienvenida;
	}

}
