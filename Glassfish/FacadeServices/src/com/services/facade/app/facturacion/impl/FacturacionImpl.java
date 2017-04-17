package com.services.facade.app.facturacion.impl;

import com.obj.transf.datos.app.facturacion.GenerarFacturacionPeticion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionRespuesta;
import com.services.business.app.facturacion.GenerarFacturacion;
import com.services.facade.app.facturacion.Facturacion;

public class FacturacionImpl implements Facturacion {

	private GenerarFacturacion generarFacturacion;

	@Override
	public GenerarFacturacionRespuesta generarFacturacion(GenerarFacturacionPeticion peticion) {
		GenerarFacturacionRespuesta respuesta = generarFacturacion.ejecutar(peticion);
		return respuesta;
	}

	public GenerarFacturacion getGenerarFacturacion() {
		return generarFacturacion;
	}

	public void setGenerarFacturacion(GenerarFacturacion generarFacturacion) {
		this.generarFacturacion = generarFacturacion;
	}
}
