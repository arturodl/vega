package com.facadeservices.app.factibilidades.impl;

import com.businesservices.app.factibilidades.GenerarFactibilidad;
import com.facadeservices.app.factibilidades.Factibilidades;
import com.obj.transf.datos.app.factibilidades.GenerarFactibilidadPeticion;
import com.obj.transf.datos.app.factibilidades.GenerarFactibilidadRespuesta;

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
