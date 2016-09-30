package com.facadeservices.app.cuentasporcobrar.impl;

import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroPeticion;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroRespuesta;
import com.businesservices.app.cuentasporcobrar.GenerarCobro;
import com.facadeservices.app.cuentasporcobrar.CuentasPorCobrar;

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
