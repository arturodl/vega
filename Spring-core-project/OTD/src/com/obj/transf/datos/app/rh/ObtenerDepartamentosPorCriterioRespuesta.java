package com.obj.transf.datos.app.rh;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;
import com.model.data.app.humanresources.Department;
import com.model.data.app.person.Person;

@XmlRootElement(name="GetDepartmentsByCriteriaResponse")
@XmlSeeAlso(Department.class)
public class ObtenerDepartamentosPorCriterioRespuesta extends ObtenerEntidadesPorCriterioRespuesta {
	
	@Override
	@XmlElementWrapper(name="departmentsList")
	@XmlElement(name="department")
	public List getListaEntidades() {
		// TODO Auto-generated method stub
		System.out.println("Llamada a getListaEntidades desde el hijo departments");
		return super.getListaEntidades();
	}  

}
