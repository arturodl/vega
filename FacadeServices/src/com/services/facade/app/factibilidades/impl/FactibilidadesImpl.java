package com.services.facade.app.factibilidades.impl;

import com.obj.transf.datos.app.factibilidades.GenerarFactibilidadPeticion;
import com.obj.transf.datos.app.factibilidades.GenerarFactibilidadRespuesta;
import com.services.business.app.factibilidades.GenerarFactibilidad;
import com.services.facade.app.factibilidades.Factibilidades;

public class FactibilidadesImpl implements Factibilidades{
	
	private GenerarFactibilidad generarFactibilidad;

	@Override
	public GenerarFactibilidadRespuesta generarFactibilidad(GenerarFactibilidadPeticion peticion) {
		GenerarFactibilidadRespuesta respuesta = generarFactibilidad.ejecutar(peticion);
		return respuesta;
	}

	public GenerarFactibilidad getGenerarFactibilidad() {
		return generarFactibilidad;
	}

	public void setGenerarFactibilidad(GenerarFactibilidad generarFactibilidad) {
		this.generarFactibilidad = generarFactibilidad;
	}

}
