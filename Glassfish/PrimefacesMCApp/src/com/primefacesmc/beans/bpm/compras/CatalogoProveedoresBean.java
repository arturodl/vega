package com.primefacesmc.beans.bpm.compras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="catalogoProveedoresBean")
@ViewScoped
public class CatalogoProveedoresBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Datos del Proveedor
	private String msgBienvenida;
	private String numeroDeCuenta;
	private String nombre;
	private int calificacionDeCredito;
	private boolean proveedorPreferido;
	private boolean proveedorActivo;
	private String urlWebServiceProveedor;
	private List<Integer> listaCalificaciones = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	//Datos de la direccion del proveedor
	private String direccion1;
	private String direccion2;
	private String ciudad;
	private List<String> listaEstados = Arrays.asList("Aguascalientes","Ciudad de Mexico","Jalisco","Nuevo Leon","Veracruz");
	private String codigoPostal;
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializando listado de proveedores");
		this.msgBienvenida = "Bienvenido a Listado de Proveedores";
		this.proveedorActivo = false;
		this.proveedorPreferido = false;
		System.out.println("Finalizando listado de proveedores");
	}
	
	public void guardar(ActionEvent event){
		System.out.println("Guardando datos");
	}
	
	public void verListado(ActionEvent event){
		System.out.println("Resumiendo y viendo la informacion del proveedor");
		System.out.println("Numero de cuenta insertado: " + this.numeroDeCuenta);
		System.out.println("Nombre del proveedor: " + this.nombre);
		System.out.println("Calificacion de Credito del proveedor: " + this.calificacionDeCredito);
		System.out.println("Proveedor Preferido: " + this.proveedorPreferido);
		System.out.println("Proveedor Activo: " + this.proveedorActivo);
		System.out.println("Terminando de ver la informacion del proveedor");
	}
	
	public void setMsgBienvenida(String msgBienvenida){
		this.msgBienvenida = msgBienvenida;
	}
	
	public String getMsgBienvenida(){
		return msgBienvenida;
	}

	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionDeCredito() {
		return calificacionDeCredito;
	}

	public void setCalificacionDeCredito(int calificacionDeCredito) {
		this.calificacionDeCredito = calificacionDeCredito;
	}

	public boolean getProveedorPreferido() {
		return proveedorPreferido;
	}

	public void setProveedorPreferido(boolean proveedorPreferido) {
		this.proveedorPreferido = proveedorPreferido;
	}

	public boolean getProveedorActivo() {
		return proveedorActivo;
	}

	public void setProveedorActivo(boolean proveedorActivo) {
		this.proveedorActivo = proveedorActivo;
	}

	public String getUrlWebServiceProveedor() {
		return urlWebServiceProveedor;
	}

	public void setUrlWebServiceProveedor(String urlWebServiceProveedor) {
		this.urlWebServiceProveedor = urlWebServiceProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Integer> getListaCalificaciones() {
		return listaCalificaciones;
	}

	public void setListaCalificaciones(List<Integer> listaCalificaciones) {
		this.listaCalificaciones = listaCalificaciones;
	}


	
	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<String> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<String> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
}
