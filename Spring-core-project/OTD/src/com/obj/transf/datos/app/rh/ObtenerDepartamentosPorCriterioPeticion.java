package com.obj.transf.datos.app.rh;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.core.app.modelo.Entidad;
import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.model.data.app.humanresources.Department;
//import com.model.data.app.humanresources.JsonEntity;

@XmlRootElement(name="GetDepartmentsByCriteriaRequest")
public class ObtenerDepartamentosPorCriterioPeticion extends ObtenerEntidadesPorCriterioPeticion{
	
	private String test;
	
	public ObtenerDepartamentosPorCriterioPeticion() {
		this.setClase(Department.class);
	}
	
	@Override
    @XmlElementRefs({ @XmlElementRef(type=Department.class)	}) 
	@JsonSetter("department")
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, 
				  property = "@type")
	@JsonSubTypes({ @JsonSubTypes.Type(value=Department.class, name = "Department") })
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
