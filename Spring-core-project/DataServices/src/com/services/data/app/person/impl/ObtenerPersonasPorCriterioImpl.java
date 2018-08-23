package com.services.data.app.person.impl;

import java.util.List;

import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;
import com.model.data.app.person.Person;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioPeticion;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioRespuesta;
import com.services.data.app.person.ObtenerPersonasPorCriterio;

public class ObtenerPersonasPorCriterioImpl implements ObtenerPersonasPorCriterio {

	private ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio;
		
	@Override
	public ObtenerPersonasPorCriterioRespuesta ejecutar(ObtenerPersonasPorCriterioPeticion peticion) {
		ObtenerPersonasPorCriterioRespuesta respuesta = new ObtenerPersonasPorCriterioRespuesta();
		
		try {
			List<Person> listaPersonas = obtenerEntidadesPorCriterio.ejecutar(peticion).getListaEntidades();
			respuesta.setListaEntidades(listaPersonas);
			respuesta.setMensajeResultadoObtencion( listaPersonas == null || listaPersonas.isEmpty()  ? "Sin Resultados": "Con Resultados" );
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
