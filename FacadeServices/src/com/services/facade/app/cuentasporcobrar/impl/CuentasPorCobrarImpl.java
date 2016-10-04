package com.services.facade.app.cuentasporcobrar.impl;

import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroPeticion;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroRespuesta;
import com.services.business.app.cuentasporcobrar.GenerarCobro;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;
import com.services.facade.app.cuentasporcobrar.CuentasPorCobrar;
import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;

public class CuentasPorCobrarImpl implements CuentasPorCobrar {
	
	private GenerarCobro generarCobro;
	
	@Override
	public GenerarCobroRespuesta GenerarCobro(GenerarCobroPeticion peticion) {
		GenerarCobroRespuesta respuesta = generarCobro.ejecutar(peticion);
		return respuesta;
	}
	
	public GenerarCobro getGenerarCobro() {
		return generarCobro;
	}

	public void setGenerarCobro(GenerarCobro generarCobro) {
		this.generarCobro = generarCobro;
	}

}
