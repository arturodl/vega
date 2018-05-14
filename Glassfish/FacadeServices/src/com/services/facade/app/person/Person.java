package com.services.facade.app.person;

import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioPeticion;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioRespuesta;


public interface Person {
	
	public String sayHello();
	
	public ObtenerPersonasPorCriterioRespuesta obtenerPersonasPorCriterio(ObtenerPersonasPorCriterioPeticion peticion);
}
