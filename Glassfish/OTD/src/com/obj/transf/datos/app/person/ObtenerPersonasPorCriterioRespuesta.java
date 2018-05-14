package com.obj.transf.datos.app.person;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.model.data.app.humanresources.Department;

@XmlRootElement(name="ObtenerPersonasPorCriterioRespuesta")
public class ObtenerPersonasPorCriterioRespuesta extends ObtenerEntidadesPorCriterioRespuesta {
	
	@Override
	@XmlElementRefs({
	    @XmlElementRef(type=Department.class)		
	}) 
	public List getListaEntidades() {
		// TODO Auto-generated method stub
		return super.getListaEntidades();
	}

}
