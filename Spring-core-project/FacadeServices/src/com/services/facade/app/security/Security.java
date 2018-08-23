package com.services.facade.app.security;

import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioPeticion;
import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioRespuesta;

public interface Security {
	
	public ObtenerUsuariosPorCriterioRespuesta obtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterioPeticion peticion);

}
