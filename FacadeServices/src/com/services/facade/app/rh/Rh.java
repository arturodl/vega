package com.services.facade.app.rh;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.validation.executable.ValidateOnExecution;
import javax.xml.ws.BindingType;
import javax.xml.ws.ServiceMode;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.CrearDepartamentoRespuesta;

@WebService(serviceName="RhService",
			name="RhPort")
@SOAPBinding(style = Style.DOCUMENT)
public interface Rh {
	
	@WebMethod(operationName="crearDepartamento",
		       action="crearDepartamentoAction")
	@WebResult( name="crearDepartamentoResponse")
	public CrearDepartamentoRespuesta 
				crearDepartamento( @WebParam(name="crearDepartamentoRequest", mode=Mode.IN) 
								   CrearDepartamentoPeticion peticion
								 );
}
