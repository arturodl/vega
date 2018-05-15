package com.obj.transf.datos.app.person;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlClassExtractor;

import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;

@XmlRootElement(name="GetPersonsByCriteriaResponse")
public class ObtenerPersonasPorCriterioRespuesta extends ObtenerEntidadesPorCriterioRespuesta {
	
	@Override
	@XmlElementWrapper(name="personsList")
	@XmlElement(name="person")
	public List getListaEntidades() {
		// TODO Auto-generated method stub
		return super.getListaEntidades();
	}

}
