package com.obj.transf.datos.app.production;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.app.otd.ObtenerEntidadesPorCriterioRespuesta;

@XmlRootElement(name="GetVendorsByCriteriaResponse")
public class ObtenerVendedoresPorCriterioRespuesta extends ObtenerEntidadesPorCriterioRespuesta {

	@Override
	@XmlElementWrapper(name="vendorList")
	@XmlElement(name="vendor")
	public List getListaEntidades() {
		// TODO Auto-generated method stub7
		System.out.println("Llamada a getListaEntidades desde el hijo vendors");
		return super.getListaEntidades(); 
	}  

}
