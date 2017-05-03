package com.primefacesmc.beans.bpm.compras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.model.data.app.purchasing.Vendor;

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
	
	//Listado de proveedores para llenar la tabla
	private List<Vendor> listaProveedores;
	private Vendor proveedorSeleccionado;
	
	//Etiquetas botones
	private String etiquetaBtnGuardar;
	//Valores para deshabilitar los campos;
	private boolean deshabilitarNumeroCuenta = true;
	private boolean deshabilitarBtnNuevo = false;
	private boolean deshabilitarBtnGuardar = true;
	private boolean deshabilitarBtnCancelar = true;
	private boolean deshabilitarBtnModificar = false;
	private boolean deshabilitarBtnEliminar = false;
	private boolean deshabilitarCampo = true;
	
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializando listado de proveedores");
		this.msgBienvenida = "Bienvenido a Listado de Proveedores";
		this.proveedorActivo = false;
		this.proveedorPreferido = false;
		this.setEtiquetaBtnGuardar("Guardar");
		crearListadoProveedores();
		System.out.println("Finalizando listado de proveedores");
	}
	
	public void crearListadoProveedores(){		
		this.listaProveedores = new ArrayList<Vendor>();
		Vendor proveedor = null;
		for(int i = 0; i < 20; i++ ){
			proveedor = new Vendor();
			proveedor.setAccountNumber("Cuenta000000"+i);
			proveedor.setName("Proveedor Numero 0"+i);
			proveedor.setCreditRating( (short)i );
			proveedor.setActiveFlag(true);
			proveedor.setPreferredVendorStatus(false);
			this.listaProveedores.add(proveedor);
		}
		proveedor = null;
		System.out.println("Total de proveedores creados: "+this.listaProveedores.size());
	}
	
	public void nuevo(ActionEvent evento){
		System.out.println("Habilitando captura nuevo proveedor");
		this.setEtiquetaBtnGuardar("Guardar");
		this.deshabilitarNumeroCuenta = false;
		this.deshabilitarCampo = false;
		deshabilitarBotonesPrincipales(true);
		deshabilitarBotonesCaptura(false);			
	}	
	
	public void guardar(ActionEvent event){
		System.out.println("Guardando datos");
		restaurarAccesoBotonesyCampos();
	}
	
	public void cancelar(ActionEvent evento){
		System.out.println("Limpiando y cancelando" );
		restaurarAccesoBotonesyCampos();
	}
	
	public void modificar(ActionEvent evento){
		System.out.println("Modificar datos proveedor seleccionado");
		System.out.println("Proveedor Seleccionado: "+this.proveedorSeleccionado.getAccountNumber());
		this.setEtiquetaBtnGuardar("Actualizar");
		this.deshabilitarNumeroCuenta = true;
		this.deshabilitarCampo = false;
		deshabilitarBotonesPrincipales(true);
		deshabilitarBotonesCaptura(false);
	}
	
	public void eliminar(ActionEvent evento){
		System.out.println("Eliminar Proveedor Seleccionado");
		System.out.println("Proveedor Seleccionado: "+this.proveedorSeleccionado.getAccountNumber());
	}
	
	public void restaurarAccesoBotonesyCampos(){
		this.setEtiquetaBtnGuardar("Guardar");
		this.deshabilitarNumeroCuenta = true;
		this.deshabilitarCampo = true;
		deshabilitarBotonesPrincipales(false);
		deshabilitarBotonesCaptura(true);
	}
	
	public void deshabilitarBotonesPrincipales(boolean deshabilitado){
		this.deshabilitarBtnNuevo = deshabilitado;
		this.deshabilitarBtnModificar = deshabilitado;
		this.deshabilitarBtnEliminar = deshabilitado;	
	}
	
	public void deshabilitarBotonesCaptura(boolean deshabilitado){
		this.deshabilitarBtnGuardar = deshabilitado;
		this.deshabilitarBtnCancelar = deshabilitado;		
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

	public List<Vendor> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<Vendor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public Vendor getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}

	public void setProveedorSeleccionado(Vendor proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}

	public boolean isDeshabilitarNumeroCuenta() {
		return deshabilitarNumeroCuenta;
	}

	public void setDeshabilitarNumeroCuenta(boolean deshabilitarNumeroCuenta) {
		this.deshabilitarNumeroCuenta = deshabilitarNumeroCuenta;
	}

	public boolean isDeshabilitarBtnNuevo() {
		return deshabilitarBtnNuevo;
	}

	public void setDeshabilitarBtnNuevo(boolean deshabilitarBtnNuevo) {
		this.deshabilitarBtnNuevo = deshabilitarBtnNuevo;
	}

	public boolean isDeshabilitarBtnModificar() {
		return deshabilitarBtnModificar;
	}

	public void setDeshabilitarBtnModificar(boolean deshabilitarBtnModificar) {
		this.deshabilitarBtnModificar = deshabilitarBtnModificar;
	}

	public boolean isDeshabilitarBtnEliminar() {
		return deshabilitarBtnEliminar;
	}

	public void setDeshabilitarBtnEliminar(boolean deshabilitarBtnEliminar) {
		this.deshabilitarBtnEliminar = deshabilitarBtnEliminar;
	}

	public boolean isDeshabilitarBtnCancelar() {
		return deshabilitarBtnCancelar;
	}

	public void setDeshabilitarBtnCancelar(boolean deshabilitarBtnCancelar) {
		this.deshabilitarBtnCancelar = deshabilitarBtnCancelar;
	}

	public boolean isDeshabilitarCampo() {
		return deshabilitarCampo;
	}

	public void setDeshabilitarCampo(boolean deshabilitarCampo) {
		this.deshabilitarCampo = deshabilitarCampo;
	}

	public boolean isDeshabilitarBtnGuardar() {
		return deshabilitarBtnGuardar;
	}

	public void setDeshabilitarBtnGuardar(boolean deshabilitarBtnGuardar) {
		this.deshabilitarBtnGuardar = deshabilitarBtnGuardar;
	}

	public String getEtiquetaBtnGuardar() {
		return etiquetaBtnGuardar;
	}

	public void setEtiquetaBtnGuardar(String etiquetaBtnGuardar) {
		this.etiquetaBtnGuardar = etiquetaBtnGuardar;
	}
	
	
}
