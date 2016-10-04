package com.services.facade.app.rh.impl;

import com.core.app.otd.PeticionEntidad;
import com.core.app.otd.RespuestaEntidad;
import com.services.data.app.rh.CrearDepartamento;
import com.services.facade.app.rh.Rh;

public class RhImpl implements Rh {

	private CrearDepartamento crearDepartamento;
	
	@Override
	public RespuestaEntidad crearDepartamento(PeticionEntidad peticion) {
		RespuestaEntidad respuesta = crearDepartamento.ejecutar(peticion);
		return respuesta;
	}

	public CrearDepartamento getCrearDepartamento() {
		return crearDepartamento;
	}

	public void setCrearDepartamento(CrearDepartamento crearDepartamento) {
		this.crearDepartamento = crearDepartamento;
	}

}
