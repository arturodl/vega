package com.services.facade.app.rh;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.BindingType;
import javax.xml.ws.ServiceMode;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.CrearDepartamentoRespuesta;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;

@WebService//(serviceName="RhService",
			//name="RhPort")
@SOAPBinding(style = Style.DOCUMENT)
public interface Rh {
	
	@WebMethod(operationName="crearDepartamento",
		       action="crearDepartamentoAction")
	@WebResult( name="crearDepartamentoResponse")
	public CrearDepartamentoRespuesta 
				crearDepartamento( @WebParam(name="crearDepartamentoRequest", mode=Mode.IN) 
								   CrearDepartamentoPeticion peticion
								 );
	
	@WebMethod(operationName="obtenerDepartamentos",
		       action="obtenerDepartamentosAction")
	@WebResult( name="obtenerDepartamentosResponse")
	public ObtenerDepartamentosPorCriterioRespuesta 
				obtenerDepartamentosPorCriterio(
									@WebParam(name="obtenerDepartamentosRequest", mode=Mode.IN) 
									ObtenerDepartamentosPorCriterioPeticion peticion);
}
