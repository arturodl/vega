package com.obj.transf.datos.app.rh;

import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.model.data.app.humanresources.Department;

@XmlRootElement(name="obtenerDepartamentosPorCriterioRespuesta")
public class ObtenerDepartamentosPorCriterioRespuesta extends ObtenerEntidadesPorCriterioRespuesta {
	
	@Override
	@XmlElementRefs({
	    @XmlElementRef(type=Department.class)		
	}) 
	public List getListaEntidades() {
		// TODO Auto-generated method stub
		return super.getListaEntidades();
	}

}
