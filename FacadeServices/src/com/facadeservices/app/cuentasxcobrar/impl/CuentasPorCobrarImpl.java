package com.facadeservices.app.cuentasxcobrar.impl;

import com.facadeservices.app.cuentasxcobrar.CuentasPorCobrar;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroPeticion;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroRespuesta;
import com.businesservices.app.cuentasporcobrar.GenerarCobro;

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
