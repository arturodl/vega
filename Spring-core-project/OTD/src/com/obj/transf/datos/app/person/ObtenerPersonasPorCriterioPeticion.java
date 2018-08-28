package com.obj.transf.datos.app.person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.core.app.modelo.Entidad;
import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.model.data.app.humanresources.Department;
import com.model.data.app.person.Person;

@XmlRootElement(name = "GetPersonsByCriteriaRequest")
@XmlSeeAlso(Person.class)
public class ObtenerPersonasPorCriterioPeticion extends ObtenerEntidadesPorCriterioPeticion {
	
	private String test;
	
	public ObtenerPersonasPorCriterioPeticion() {
		// Predefinimos la clase para obtenerEntidadesPorCriterio
		this.setClase(Person.class);
	}

	@Override
	@XmlElementRefs({ @XmlElementRef(type = Person.class) })
	public void setEntidad(Entidad entidad) {
		// TODO Auto-generated method stub
		super.setEntidad(entidad);
	}
    	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
