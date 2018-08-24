package com.services.facade.app.person;

import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioPeticion;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioRespuesta;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;


public interface Person {
	
	public String sayHello();
	
	public ObtenerPersonasPorCriterioRespuesta obtenerPersonasPorCriterio(ObtenerPersonasPorCriterioPeticion peticion);
	
	public ObtenerDepartamentosPorCriterioRespuesta obtenerDepartamentosPorCriterio(ObtenerDepartamentosPorCriterioPeticion peticion);
}
