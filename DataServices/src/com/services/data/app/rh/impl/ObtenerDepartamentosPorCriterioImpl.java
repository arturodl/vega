package com.services.data.app.rh.impl;

import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;

public class ObtenerDepartamentosPorCriterioImpl implements ObtenerDepartamentosPorCriterio {

	private ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio;
		
	@Override
	public ObtenerDepartamentosPorCriterioRespuesta ejecutar(ObtenerDepartamentosPorCriterioPeticion peticion) {
		ObtenerDepartamentosPorCriterioRespuesta respuesta = null; 
				obtenerEntidadesPorCriterio.ejecutar(peticion);
		return respuesta;
	}

	public ServicioObtenerEntidadesPorCriterio getObtenerEntidadesPorCriterio() {
		return obtenerEntidadesPorCriterio;
	}

	public void setObtenerEntidadesPorCriterio(ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio) {
		this.obtenerEntidadesPorCriterio = obtenerEntidadesPorCriterio;
	}

}
