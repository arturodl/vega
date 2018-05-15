package com.services.facade.app.production;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.obj.transf.datos.app.production.ObtenerVendedoresPorCriterioPeticion;
import com.obj.transf.datos.app.production.ObtenerVendedoresPorCriterioRespuesta;

@WebService//(serviceName="ProductionService",
			//name="ProductionPort")
@SOAPBinding(style=Style.DOCUMENT)
public interface Production {
	
	@WebMethod(operationName="sayHello",
		       action="sayHelloAction")
	public String sayHello();
	
	@WebMethod(operationName="getVendorsByCriteria",
		       action="getVendorsByCriteriaAction")
	@WebResult(name="getVendorsByCriteriaResponse")
	public ObtenerVendedoresPorCriterioRespuesta obtenerVendedoresPorCriterio(
			@WebParam(name="getVendorsByCriteriaRequest", mode=Mode.IN) 
			ObtenerVendedoresPorCriterioPeticion peticion);

}
