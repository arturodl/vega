package com.services.facade.app.person.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioPeticion;
import com.obj.transf.datos.app.person.ObtenerPersonasPorCriterioRespuesta;
import com.services.data.app.person.ObtenerPersonasPorCriterio;
import com.services.facade.app.person.Person;

@RestController
@RequestMapping(value = "/person")
public class PersonImpl implements Person {

	@Autowired
	private ObtenerPersonasPorCriterio obtenerPersonasPorCriterio;

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
		System.out.println("El valor de test es: " + peticion.getTest());
				
		ObtenerPersonasPorCriterioRespuesta respuesta = null;
		if (peticion == null || peticion.getEntidad() == null)
			respuesta = new ObtenerPersonasPorCriterioRespuesta();
		else
			respuesta = obtenerPersonasPorCriterio.ejecutar(peticion);
		System.out.println("Saliendo de obtenerPersonasPorCriterio");
		return respuesta;
	}

	public ObtenerPersonasPorCriterio getObtenerPersonasPorCriterio() {
		return obtenerPersonasPorCriterio;
	}

	public void setObtenerPersonasPorCriterio(ObtenerPersonasPorCriterio obtenerPersonasPorCriterio) {
		this.obtenerPersonasPorCriterio = obtenerPersonasPorCriterio;
	}

}
