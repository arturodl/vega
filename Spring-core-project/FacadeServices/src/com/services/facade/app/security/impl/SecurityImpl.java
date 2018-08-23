package com.services.facade.app.security.impl;

import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioPeticion;
import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioRespuesta;
import com.services.data.app.security.ObtenerUsuariosPorCriterio;
import com.services.facade.app.security.Security;

public class SecurityImpl implements Security {

	private ObtenerUsuariosPorCriterio obtenerUsuariosPorCriterio;

	@Override
	public ObtenerUsuariosPorCriterioRespuesta obtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterioPeticion peticion) {
		
		ObtenerUsuariosPorCriterioRespuesta respuesta = obtenerUsuariosPorCriterio.ejecutar(peticion);		
		return respuesta;
	}

	public ObtenerUsuariosPorCriterio getObtenerUsuariosPorCriterio() {
		return obtenerUsuariosPorCriterio;
	}

	public void setObtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterio obtenerUsuariosPorCriterio) {
		this.obtenerUsuariosPorCriterio = obtenerUsuariosPorCriterio;
	}

}
