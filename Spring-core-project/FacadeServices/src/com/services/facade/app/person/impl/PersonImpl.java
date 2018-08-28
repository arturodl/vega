package com.services.facade.app.person.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.data.app.humanresources.Department;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioPeticion;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioRespuesta;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioRespuesta;
import com.services.data.app.person.ObtenerPersonasPorCriterio;
import com.services.data.app.rh.ObtenerDepartamentosPorCriterio;
import com.services.facade.app.person.Person;

@RestController
@RequestMapping(value = "/person")
public class PersonImpl implements Person {

	@Autowired
	private ObtenerPersonasPorCriterio obtenerPersonasPorCriterio;
	
	@Autowired
	private ObtenerDepartamentosPorCriterio obtenerDepartamentosPorCriterio;

	@Override
	@GetMapping("/sayHello")
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hi from PersonService";
	}
 
	@Override
	@PostMapping("/getPersonsByCriteria")
	public ObtenerPersonasPorCriterioRespuesta obtenerPersonasPorCriterio(
			@RequestBody ObtenerPersonasPorCriterioPeticion peticion) {
		System.out.println("La entidad para enviar a obtenerPersonasPorCriterio es: " + peticion.getEntidad());	
				
		ObtenerPersonasPorCriterioRespuesta respuesta = null;
		
		//Checamos que la peticion no sea nula o que la entidad contenida en la peticion tampoco sea nula.
		if (peticion == null || peticion.getEntidad() == null) {
			respuesta = new ObtenerPersonasPorCriterioRespuesta();
			respuesta.setListaEntidades(new ArrayList());
			respuesta.setMensajeResultadoObtencion("Por favor proporcione los datos de busqueda");
		}
		else {
			System.out.println("FirstName: " + ((com.model.data.app.person.Person)peticion.getEntidad()).getFirstName());
			System.out.println("NameStyle: " + ((com.model.data.app.person.Person)peticion.getEntidad()).getNameStyle());
			System.out.println("EmailPromotion: " + ((com.model.data.app.person.Person)peticion.getEntidad()).getEmailPromotion());
			System.out.println("El valor de test es: " + peticion.getTest());
			respuesta = obtenerPersonasPorCriterio.ejecutar(peticion);
		}
		System.out.println("Saliendo de obtenerPersonasPorCriterio");
		return respuesta;
	}
	
	@Override
	@RequestMapping(value="/getDepartmentsByCriteria", method=RequestMethod.POST,
					consumes={MediaType.APPLICATION_JSON_VALUE, 
          				  	  MediaType.APPLICATION_XML_VALUE},				    
					produces={MediaType.APPLICATION_JSON_VALUE,
            				  MediaType.APPLICATION_XML_VALUE}
				    )
	@ResponseBody
	public ObtenerDepartamentosPorCriterioRespuesta obtenerDepartamentosPorCriterio(
			@RequestBody ObtenerDepartamentosPorCriterioPeticion peticion) {
		System.out.println("La entidad para enviar a obtenerDepartamentosPorCriterio es:"+peticion.getEntidad());
		if(peticion.getEntidad() != null) {
			System.out.println("ModifiedDate:"+((Department)peticion.getEntidad()).getModifiedDate());
		}
		System.out.print("La peticion es nula?: "+ peticion);
		System.out.println("El valor de TEST es: "+ peticion.getTest());
				
		ObtenerDepartamentosPorCriterioRespuesta respuesta = null;
		
		//Checamos que la peticion no sea nula o que la entidad contenida en la peticion tampoco sea nula.
		if(peticion == null || peticion.getEntidad() == null) {
			respuesta = new ObtenerDepartamentosPorCriterioRespuesta();
			respuesta.setListaEntidades(new ArrayList());
			respuesta.setMensajeResultadoObtencion("Por favor proporcione los datos de busqueda");
		}
		else {
			System.out.println("El Valor de GroupName es:"+((Department)peticion.getEntidad()).getGroupName());
			System.out.println("El valor de test es: " + peticion.getTest());
			respuesta = obtenerDepartamentosPorCriterio.ejecutar(peticion);
			if(respuesta.getListaEntidades().size() >0) {
				for(Department department: (List<Department>)respuesta.getListaEntidades()) {
					System.out.println("Fecha de "+department.getId()+" :"+department.getModifiedDate());
				}
			}
		}
		
		System.out.println("Saliendo de obtenerDepartamentosPorCriterioPeticion");
		return respuesta;
	}

	public ObtenerPersonasPorCriterio getObtenerPersonasPorCriterio() {
		return obtenerPersonasPorCriterio;
	}

	public void setObtenerPersonasPorCriterio(ObtenerPersonasPorCriterio obtenerPersonasPorCriterio) {
		this.obtenerPersonasPorCriterio = obtenerPersonasPorCriterio;
	}

	public ObtenerDepartamentosPorCriterio getObtenerDepartamentosPorCriterio() {
		return obtenerDepartamentosPorCriterio;
	}

	public void setObtenerDepartamentosPorCriterio(ObtenerDepartamentosPorCriterio obtenerDepartamentosPorCriterio) {
		this.obtenerDepartamentosPorCriterio = obtenerDepartamentosPorCriterio;
	}
	
	
}
