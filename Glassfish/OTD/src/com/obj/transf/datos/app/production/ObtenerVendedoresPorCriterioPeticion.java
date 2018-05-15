package com.obj.transf.datos.app.production;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.app.modelo.Entidad;
import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.model.data.app.purchasing.Vendor;

@XmlRootElement(name="GetVendorsByCriteriaRequest")
public class ObtenerVendedoresPorCriterioPeticion extends ObtenerEntidadesPorCriterioPeticion {
	
	public ObtenerVendedoresPorCriterioPeticion() {
		// Predefinimos la clase para el servicio de ObtenerEntidadesPorCriterio
		this.setClase(Vendor.class);
	} 

	@Override
	@XmlElementRefs({ @XmlElementRef(type = Vendor.class) })
	public void setEntidad(Entidad entidad) {
		// TODO Auto-generated method stub
		super.setEntidad(entidad);
	}

}
