package com.core.app.servicios.entidad.impl;

import javax.persistence.EntityManager;

import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;

public class ObtenerEntidadesPorCriterioImpl implements ServicioObtenerEntidadesPorCriterio{

	private EntityManager entityManager;
	
	@Override
	public ObtenerEntidadesPorCriterioRespuesta ejecutar(ObtenerEntidadesPorCriterioPeticion peticion) {
		
		return null;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
