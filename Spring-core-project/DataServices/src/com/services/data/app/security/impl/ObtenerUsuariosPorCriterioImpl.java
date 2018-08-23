package com.services.data.app.security.impl;

import java.util.List;

import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;
import com.model.data.app.security.User;
import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioPeticion;
import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioRespuesta;
import com.services.data.app.security.ObtenerUsuariosPorCriterio;

public class ObtenerUsuariosPorCriterioImpl implements ObtenerUsuariosPorCriterio {
	
	private ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio;

	@Override
	public ObtenerUsuariosPorCriterioRespuesta ejecutar(ObtenerUsuariosPorCriterioPeticion peticion) {
		ObtenerUsuariosPorCriterioRespuesta respuesta = new ObtenerUsuariosPorCriterioRespuesta();
		
		try{
			List<User> listaUsuarios = obtenerEntidadesPorCriterio.ejecutar(peticion).getListaEntidades();
			respuesta.setListaEntidades(listaUsuarios);
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
