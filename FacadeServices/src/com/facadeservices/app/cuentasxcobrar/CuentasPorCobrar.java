package com.facadeservices.app.cuentasxcobrar;

import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroPeticion;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroRespuesta;

public interface CuentasPorCobrar{
    public GenerarCobroRespuesta GenerarCobro(GenerarCobroPeticion peticion);
}
