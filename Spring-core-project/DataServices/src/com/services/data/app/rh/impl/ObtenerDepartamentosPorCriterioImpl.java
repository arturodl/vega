package com.services.data.app.rh.impl;

import java.util.List;

import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;
import com.model.data.app.humanresources.Department;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;

public class ObtenerDepartamentosPorCriterioImpl implements ObtenerDepartamentosPorCriterio {

	private ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio;
		
	@Override
	public ObtenerDepartamentosPorCriterioRespuesta ejecutar(ObtenerDepartamentosPorCriterioPeticion peticion) {
		ObtenerDepartamentosPorCriterioRespuesta respuesta = new ObtenerDepartamentosPorCriterioRespuesta();
		
		try {
			List<Department> listaDepartamentos = obtenerEntidadesPorCriterio.ejecutar(peticion).getListaEntidades();
			respuesta.setMensajeResultadoObtencion( listaDepartamentos == null || listaDepartamentos.isEmpty()  ? "Sin Resultados": "Con Resultados" );
			respuesta.setListaEntidades(listaDepartamentos);
		}catch(Exception e) {
			System.out.println("Error en el Servicio ObtenerDepartamentosPorCriterioImpl:" +e.getMessage());
			e.printStackTrace();
		}
		return respuesta;
	}

	public ServicioObtenerEntidadesPorCriterio getObtenerEntidadesPorCriterio() {
		return obtenerEntidadesPorCriterio;
	}

	public void setObtenerEntidadesPorCriterio(ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio) {
		this.obtenerEntidadesPorCriterio = obtenerEntidadesPorCriterio;
	}

}
