package com.core.app.servicios.entidad.impl;

import javax.persistence.EntityManager;

import com.core.app.otd.PeticionEntidad;
import com.core.app.otd.RespuestaEntidad;
import com.core.app.servicios.entidad.ServicioEntidad;

public class CrearEntidadImpl implements ServicioEntidad{
	
	private EntityManager entityManager;

	@Override
	public RespuestaEntidad ejecutar(PeticionEntidad peticion) {
		RespuestaEntidad respuesta = new RespuestaEntidad();
		System.out.println("Bienvenido a CrearEntidad");
		System.out.println("Nuestro entity manager era: "+entityManager);
		try{
			System.out.println("Antes de persistir");
			entityManager.persist(peticion.getEntidad());
			entityManager.flush();
			entityManager.detach(peticion.getEntidad());
			respuesta.setEntidad(peticion.getEntidad());
			System.out.println("Despues de persistir");
			System.out.println("El nuevo departamento es: "+peticion.getEntidad());
		}catch(Exception e){
			System.out.println("Error:" +e.getMessage());
			e.printStackTrace();
			
		}
		return respuesta;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
