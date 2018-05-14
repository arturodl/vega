package com.services.facade.app.production.impl;

import javax.jws.WebService;

import com.obj.transf.datos.app.production.ObtenerVendedoresPorCriterioPeticion;
import com.obj.transf.datos.app.production.ObtenerVendedoresPorCriterioRespuesta;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;
import com.services.data.app.production.ObtenerVendedoresPorCriterio;
import com.services.facade.app.production.Production;

@WebService(endpointInterface = "com.services.facade.app.production.Production")
public class ProductionImpl implements Production {
	
	private ObtenerVendedoresPorCriterio obtenerVendedoresPorCriterio;

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hola desde ProductionService";
	}
 
	@Override
	public ObtenerVendedoresPorCriterioRespuesta obtenerVendedoresPorCriterio(
			ObtenerVendedoresPorCriterioPeticion peticion) {
		// TODO Auto-generated method stub 
		System.out.println("La entidad para enviar a obtenerDepartamentosPorCriterio es:"+peticion.getEntidad());
		ObtenerVendedoresPorCriterioRespuesta respuesta = obtenerVendedoresPorCriterio.ejecutar(peticion);
		System.out.println("Total entidades obtenidas:"+respuesta.getListaEntidades().size());
		return respuesta;
	}

	public ObtenerVendedoresPorCriterio getObtenerVendedoresPorCriterio() {
		return obtenerVendedoresPorCriterio;
	}

	public void setObtenerVendedoresPorCriterio(ObtenerVendedoresPorCriterio obtenerVendedoresPorCriterio) {
		this.obtenerVendedoresPorCriterio = obtenerVendedoresPorCriterio;
	}

}
