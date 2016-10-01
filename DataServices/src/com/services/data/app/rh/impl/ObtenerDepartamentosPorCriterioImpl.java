package com.services.data.app.rh.impl;

import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;

public class ObtenerDepartamentosPorCriterioImpl implements ObtenerDepartamentosPorCriterio {

	@Override
	public ObtenerEntidadesPorCriterioRespuesta ejecutar(ObtenerEntidadesPorCriterioPeticion peticion) {
		ObtenerEntidadesPorCriterioRespuesta respuesta = ejecutar(peticion);
		return respuesta;
	}

}
