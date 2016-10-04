package com.services.facade.app.cuentasporcobrar;

import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroPeticion;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroRespuesta;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;

public interface CuentasPorCobrar{
    public GenerarCobroRespuesta GenerarCobro(GenerarCobroPeticion peticion);
}
