package com.services.facade.app.rh.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.CrearDepartamentoRespuesta;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;
import com.services.data.app.rh.CrearDepartamento;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;
import com.services.facade.app.rh.Rh;

//Set values to WebService Annotation when it's working on Jboss/Wildfly
//Otherwise quit values and set them on the webservice interface RH 
@WebService(serviceName="RhService",
			name="Rh",
			endpointInterface = "com.services.facade.app.rh.Rh"			
			)
public class RhImpl implements Rh {

	private CrearDepartamento crearDepartamento;
	private ObtenerDepartamentosPorCriterio obtenerDepartamentosPorCriterio;
	
	@Override
	public CrearDepartamentoRespuesta crearDepartamento(CrearDepartamentoPeticion peticion) {
		System.out.println("La entidad es:"+peticion.getEntidad());
		CrearDepartamentoRespuesta respuesta = crearDepartamento.ejecutar(peticion);
		return respuesta;
	}
	
	@Override
	public ObtenerDepartamentosPorCriterioRespuesta obtenerDepartamentosPorCriterio(
			ObtenerDepartamentosPorCriterioPeticion peticion) {
		System.out.println("La entidad para enviar a obtenerDepartamentosPorCriterio es:"+peticion.getEntidad());
		ObtenerDepartamentosPorCriterioRespuesta respuesta = obtenerDepartamentosPorCriterio.ejecutar(peticion);
		System.out.println("Total entidades obtenidas:"+respuesta.getListaEntidades().size());
		return respuesta;
	}

	public CrearDepartamento getCrearDepartamento() {
		return crearDepartamento;
	}

	public void setCrearDepartamento(CrearDepartamento crearDepartamento) {
		this.crearDepartamento = crearDepartamento;
	}

	public ObtenerDepartamentosPorCriterio getObtenerDepartamentosPorCriterio() {
		return obtenerDepartamentosPorCriterio;
	}

	public void setObtenerDepartamentosPorCriterio(ObtenerDepartamentosPorCriterio obtenerDepartamentosPorCriterio) {
		this.obtenerDepartamentosPorCriterio = obtenerDepartamentosPorCriterio;
	}

	
	
}
