package com.core.app.servicios.entidad.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;

public class ObtenerEntidadesPorCriterioImpl implements ServicioObtenerEntidadesPorCriterio{

	private EntityManager entityManager;
	
	@Override
	public ObtenerEntidadesPorCriterioRespuesta ejecutar(ObtenerEntidadesPorCriterioPeticion peticion) {
		System.out.println("Entrando a ObtenerEntidadesPorCriterioImpl");
		
		ObtenerEntidadesPorCriterioRespuesta respuesta = null;
		
		try {
			Session session = entityManager.unwrap(Session.class);
			
			Class<?> clase = peticion.getClase(); 
			
			System.out.println("Before creating the Example Instance: " + clase);
			
			Example example = Example.create(peticion.getEntidad());
			
			Criteria criteria = session.createCriteria( clase ).
					  					add( example );
			
			List listaEntidades = criteria.list();
			
			respuesta = new ObtenerEntidadesPorCriterioRespuesta();
			respuesta.setListaEntidades(listaEntidades);
			System.out.println("Saliendo de ObtenerEntidadesPorCriterioImpl");
		}catch(Exception e) {
			System.out.println("Error en el Servicio ObtenerEntidadesPorCriterioImpl:" +e.getMessage());
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
