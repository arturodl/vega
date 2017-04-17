package com.services.facade.app.cuentasporcobrar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroPeticion;
import com.obj.transf.datos.app.cuentasporcobrar.GenerarCobroRespuesta;

@WebService(serviceName="CuentasPorCobrarService",
			name="CuentasPorCobrarPort")
@SOAPBinding(style = Style.DOCUMENT)
public interface CuentasPorCobrar{
	
	@WebMethod(operationName="generarCobro",
			   action="generarCobroAction")
	@WebResult(name="crearDepartamentoResponse")
    public GenerarCobroRespuesta 
    				GenerarCobro(@WebParam(name="generarCobroPeticion", mode= Mode.IN)
    							 GenerarCobroPeticion peticion
    							 );
}
