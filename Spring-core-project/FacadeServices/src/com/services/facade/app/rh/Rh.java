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

//Quit values from WebService Annotation when it's working on Wildfly/Jboss
//Otherwise set them.
@WebService//(serviceName="RhService",
			//name="RhPort",
			//wsdlLocation = "RhWsdl.wsdl")
@SOAPBinding(style = Style.DOCUMENT)
public interface Rh {
	
	@WebMethod(operationName="createDepartament",
		       action="createDepartamentAction")
	@WebResult( name="createDepartamentResponse")
	public CrearDepartamentoRespuesta 
				crearDepartamento( @WebParam(name="createDepartamentRequest", mode=Mode.IN) 
								   CrearDepartamentoPeticion peticion
								 );
	
	@WebMethod(operationName="getDepartmentsByCriteria",
		       action="getDepartmentsByCriteriaAction")
	@WebResult( name="getDepartmentsByCriteriaResponse")
	public ObtenerDepartamentosPorCriterioRespuesta 
				obtenerDepartamentosPorCriterio(
									@WebParam(name="getDepartmentsByCriteriaRequest", mode=Mode.IN) 
									ObtenerDepartamentosPorCriterioPeticion peticion);
}
