package com.obj.transf.datos.app.person;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.model.data.app.person.Person;

@XmlRootElement(name="GetPersonsByCriteriaResponse")
@XmlSeeAlso(Person.class)
public class ObtenerPersonasPorCriterioRespuesta extends ObtenerEntidadesPorCriterioRespuesta {
	
	@Override
	@XmlElementWrapper(name="personsList")
	@XmlElement(name="person")	
	public List getListaEntidades() {
		// TODO Auto-generated method stub
		return super.getListaEntidades();
	}

}
