package com.businesservices.app.facturacion.impl;

import com.businesservices.app.facturacion.GenerarFacturacion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionPeticion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionRespuesta;

public class GenerarFacturacionImpl implements GenerarFacturacion {

	@Override
	public GenerarFacturacionRespuesta ejecutar(GenerarFacturacionPeticion peticion) {
		// TODO Auto-generated method stub
		GenerarFacturacionRespuesta respuesta = new GenerarFacturacionRespuesta();
		respuesta.setIdUsuario(peticion.getIdUsuario());
		respuesta.setNombreUsuario("Arturo Linares II");
		respuesta.setIdPosicion(3);
		respuesta.setPosicion("Layer");
		return respuesta;
	}

}
