package com.services.facade.app.rh.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.CrearDepartamentoRespuesta;
import com.services.data.app.rh.CrearDepartamento;
import com.services.facade.app.rh.Rh;

@WebService(endpointInterface = "com.services.facade.app.rh.Rh")
public class RhImpl implements Rh {

	private CrearDepartamento crearDepartamento;
	
	@Override
	public CrearDepartamentoRespuesta crearDepartamento(CrearDepartamentoPeticion peticion) {
		System.out.println("La entidad es:"+peticion.getEntidad());
		CrearDepartamentoRespuesta respuesta = crearDepartamento.ejecutar(peticion);
		return respuesta;
	}

	public CrearDepartamento getCrearDepartamento() {
		return crearDepartamento;
	}

	public void setCrearDepartamento(CrearDepartamento crearDepartamento) {
		this.crearDepartamento = crearDepartamento;
	}
	
}
