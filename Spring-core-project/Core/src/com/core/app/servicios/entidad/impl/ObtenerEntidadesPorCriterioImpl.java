package com.core.app.servicios.entidad.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
			
			/*System.out.println("Before evaluating class fields");
			Field [] fields = clase.getDeclaredFields();
			
			for(Field f : fields){			
				
					f.setAccessible(true);				
					
					if( !f.getType().isPrimitive() && !f.getType().isInterface()){
						
						if(f.getType().getSuperclass().getCanonicalName().equals("com.core.app.modelo.Entidad") ){
							
							if( camposValidos( f.get(peticion.getEntidad() ) ) ){
								System.out.println("Adding left join criteria");
								criteria.createCriteria( f.getName() , CriteriaSpecification.LEFT_JOIN ).add( Example.create(f.get(peticion.getEntidad()) ).enableLike() );
							}
						}						
					}				
			}*/
			
			//criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			System.out.println("Before evaluating fetchMode with no criteria");
			//criteria.setFetchMode("businessEntity", FetchMode.JOIN);
			
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
	
	private boolean camposValidos(Object o) throws IllegalArgumentException, IllegalAccessException  {		
		
		boolean resultado = false;		

		if(o != null){
			
			for(Field f: o.getClass().getDeclaredFields() ) {		
	
				f.setAccessible(true);				
				
				if( !f.getType().isPrimitive() && !f.getType().isInterface() ){	
					
					if( !f.getType().getSuperclass().getCanonicalName().equals("com.core.app.modelo.Entidad")  ){						
						
						if( f.get( o) != null ){
							resultado = true;
							break;
							
						}
					}				
				}
			}		
		
		}
		return resultado;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
