package com.services.data.app.rh.impl;

import com.core.app.otd.PeticionEntidad;
import com.core.app.otd.RespuestaEntidad;
import com.core.app.servicios.entidad.ServicioEntidad;
import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.CrearDepartamentoRespuesta;
import com.services.data.app.rh.CrearDepartamento;

public class CrearDepartamentoImpl implements CrearDepartamento {

	private ServicioEntidad crearEntidad;
	
	@Override
	public CrearDepartamentoRespuesta ejecutar(CrearDepartamentoPeticion peticion) {
		CrearDepartamentoRespuesta respuesta = null; 
				crearEntidad.ejecutar(peticion);
		return respuesta;
	}

	public ServicioEntidad getCrearEntidad() {
		return crearEntidad;
	}

	public void setCrearEntidad(ServicioEntidad crearEntidad) {
		this.crearEntidad = crearEntidad;
	}

}
