package com.services.facade.app.rh;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.CrearDepartamentoRespuesta;

public interface Rh {
	public CrearDepartamentoRespuesta crearDepartamento(CrearDepartamentoPeticion peticion);
}
