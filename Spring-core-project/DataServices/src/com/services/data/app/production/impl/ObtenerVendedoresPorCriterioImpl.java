package com.services.data.app.production.impl;

import java.io.Serializable;
import java.util.List;

import com.core.app.servicios.entidad.ServicioObtenerEntidadesPorCriterio;
import com.model.data.app.purchasing.Vendor;
import com.obj.transf.datos.app.production.ObtenerVendedoresPorCriterioPeticion;
import com.obj.transf.datos.app.production.ObtenerVendedoresPorCriterioRespuesta;
import com.services.data.app.production.ObtenerVendedoresPorCriterio;

public class ObtenerVendedoresPorCriterioImpl implements ObtenerVendedoresPorCriterio {

    private ServicioObtenerEntidadesPorCriterio obtenerEntidadesPorCriterio;
		
	@Override
	public ObtenerVendedoresPorCriterioRespuesta ejecutar(ObtenerVendedoresPorCriterioPeticion peticion) {
		ObtenerVendedoresPorCriterioRespuesta respuesta = new ObtenerVendedoresPorCriterioRespuesta();
		
		try {
			List<Vendor> listaVendedores = obtenerEntidadesPorCriterio.ejecutar(peticion).getListaEntidades();
			for(Vendor vendedor: listaVendedores) {
				System.out.println("Vendedor: "+vendedor.getAccountNumber());
			}
			respuesta.setListaEntidades(listaVendedores);
			respuesta.setMensajeResultadoObtencion( listaVendedores == null || listaVendedores.isEmpty()  ? "Sin Resultados": "Con Resultados" );
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
