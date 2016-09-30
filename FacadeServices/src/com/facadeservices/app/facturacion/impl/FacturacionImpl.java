package com.facadeservices.app.facturacion.impl;

import com.businesservices.app.facturacion.GenerarFacturacion;
import com.facadeservices.app.facturacion.Facturacion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionPeticion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionRespuesta;

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
