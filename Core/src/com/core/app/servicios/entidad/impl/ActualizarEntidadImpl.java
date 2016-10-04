package com.core.app.servicios.entidad.impl;

import javax.persistence.EntityManager;

import com.core.app.otd.PeticionEntidad;
import com.core.app.otd.RespuestaEntidad;
import com.core.app.servicios.entidad.ServicioEntidad;

public class ActualizarEntidadImpl implements ServicioEntidad{

	private EntityManager entityManager;
	
	@Override
	public RespuestaEntidad ejecutar(PeticionEntidad peticion) {
		RespuestaEntidad respuesta = new RespuestaEntidad();
		return respuesta;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
