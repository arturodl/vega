package com.obj.transf.datos.app.rh;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.app.modelo.Entidad;
import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.model.data.app.humanresources.Department;

@XmlRootElement(name="GetDepartmentsByCriteriaRequest")
public class ObtenerDepartamentosPorCriterioPeticion extends ObtenerEntidadesPorCriterioPeticion{
	
	private String test;

	public ObtenerDepartamentosPorCriterioPeticion() {
		this.setClase(Department.class);
	}
	
	@Override
    @XmlElementRefs({
    	@XmlElementRef(type=Department.class)		
	}) 
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
