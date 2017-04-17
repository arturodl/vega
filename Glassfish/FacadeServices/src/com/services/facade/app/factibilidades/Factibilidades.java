package com.services.facade.app.factibilidades;

import com.obj.transf.datos.app.factibilidades.GenerarFactibilidadPeticion;
import com.obj.transf.datos.app.factibilidades.GenerarFactibilidadRespuesta;

public interface Factibilidades  {
	public GenerarFactibilidadRespuesta generarFactibilidad(GenerarFactibilidadPeticion peticion);

}
