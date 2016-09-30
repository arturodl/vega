package com.facadeservices.app.facturacion;

import com.obj.transf.datos.app.facturacion.GenerarFacturacionPeticion;
import com.obj.transf.datos.app.facturacion.GenerarFacturacionRespuesta;

public interface Facturacion {
	  public GenerarFacturacionRespuesta generarFacturacion(GenerarFacturacionPeticion peticion);
}
