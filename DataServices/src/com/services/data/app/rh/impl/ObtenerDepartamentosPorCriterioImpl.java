package com.services.data.app.rh.impl;

import java.util.Date;

import javax.persistence.EntityManager;

import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.core.app.otd.PeticionEntidad;
import com.core.app.otd.RespuestaEntidad;
import com.core.app.servicios.entidad.ServicioEntidad;
import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;
import com.model.data.app.humanresources.Department;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;

public class ObtenerDepartamentosPorCriterioImpl implements ObtenerDepartamentosPorCriterio {

	//private EntityManager entityManager;
	private ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio;
		
	@Override
	//@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)
	public ObtenerEntidadesPorCriterioRespuesta ejecutar(ObtenerEntidadesPorCriterioPeticion peticion) {
		ObtenerEntidadesPorCriterioRespuesta respuesta = obtenerEntidadesPorCriterio.ejecutar(peticion);
		return respuesta;
	}

	public ServicioObtenerEntidadesPorCriterio getObtenerEntidadesPorCriterio() {
		return obtenerEntidadesPorCriterio;
	}

	public void setObtenerEntidadesPorCriterio(ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio) {
		this.obtenerEntidadesPorCriterio = obtenerEntidadesPorCriterio;
	}

}
