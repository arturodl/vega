package com.services.facade.app.production;

import javax.jws.WebMethod;
import javax.jws.WebService;
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
	
	@WebMethod(operationName="obtenerVendedoresPorCriterio",
		       action="obtenerVendedoresPorCriterioAction")
	public ObtenerVendedoresPorCriterioRespuesta obtenerVendedoresPorCriterio(ObtenerVendedoresPorCriterioPeticion peticion);

}
