package com.services.facade.app.purchasing.impl;

import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorPeticion;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorRespuesta;
import com.services.business.app.purchasing.RegistrarProveedor;
import com.services.data.app.purchasing.CrearVendor;
import com.services.facade.app.purchasing.Purchasing;

public class PurchasingImpl implements Purchasing{
	
	private CrearVendor crearVendor;
	private RegistrarProveedor registrarProveedor;

	@Override
	public CrearVendorRespuesta crearVendor(CrearVendorPeticion peticion) {
		CrearVendorRespuesta respuesta = null;
		respuesta = crearVendor.ejecutar(peticion);
		return respuesta;
	}
	
	@Override
	public RegistrarProveedorRespuesta registrarProveedor(RegistrarProveedorPeticion peticion) {
		RegistrarProveedorRespuesta respuesta = null;
		System.out.println("Antes de invocar Registrar Proveedor");
		respuesta = registrarProveedor.ejecutar(peticion);
		System.out.println("Despues de invocar Registrar Proveedor");
		return respuesta;
	}

	public CrearVendor getCrearVendor() {
		return crearVendor;
	}

	public void setCrearVendor(CrearVendor crearVendor) {
		this.crearVendor = crearVendor;
	}

	public RegistrarProveedor getRegistrarProveedor() {
		return registrarProveedor;
	}

	public void setRegistrarProveedor(RegistrarProveedor registrarProveedor) {
		this.registrarProveedor = registrarProveedor;
	}

	
	
}
