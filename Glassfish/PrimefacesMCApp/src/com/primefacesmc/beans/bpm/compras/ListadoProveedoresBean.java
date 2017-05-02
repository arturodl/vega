package com.primefacesmc.beans.bpm.compras;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="listadoProveedoresBean")
@ViewScoped
public class ListadoProveedoresBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgBienvenida;
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializando listado de proveedores");
		this.msgBienvenida = "Bienvenido a Listado de Proveedores";
		System.out.println("Finalizando listado de proveedores");
	}
	
	public void verListado(ActionEvent event){
		System.out.println("Viendo el listado de proveedores");
		System.out.println("Terminando de ver el listado de proveedores");
	}
	
	public void setMsgBienvenida(String msgBienvenida){
		this.msgBienvenida = msgBienvenida;
	}
	
	public String getMsgBienvenida(){
		return msgBienvenida;
	}
}
