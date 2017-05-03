package com.services.facade.app.purchasing.impl;

import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.services.data.app.purchasing.CrearVendor;
import com.services.facade.app.purchasing.Purchasing;

public class PurchasingImpl implements Purchasing{
	
	private CrearVendor crearVendor;

	@Override
	public CrearVendorRespuesta crearVendor(CrearVendorPeticion peticion) {
		CrearVendorRespuesta respuesta = null;
		respuesta = crearVendor.ejecutar(peticion);
		return respuesta;
	}

	public CrearVendor getCrearVendor() {
		return crearVendor;
	}

	public void setCrearVendor(CrearVendor crearVendor) {
		this.crearVendor = crearVendor;
	}
	
}
