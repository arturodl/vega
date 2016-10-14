package com.obj.transf.datos.app.rh;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;

import com.core.app.modelo.Entidad;
import com.core.app.otd.PeticionEntidad;
import com.model.data.app.humanresources.Department;


public class CrearDepartamentoPeticion extends PeticionEntidad{

	private String tipoSolicitud;
	private String uidPermisoUsuario;
	
	@Override
    @XmlElementRefs({
    	@XmlElementRef(type=Department.class)		
	})
	public void setEntidad(Entidad entidad) {
		// TODO Auto-generated method stub
		super.setEntidad(entidad);
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getUidPermisoUsuario() {
		return uidPermisoUsuario;
	}

	public void setUidPermisoUsuario(String uidPermisoUsuario) {
		this.uidPermisoUsuario = uidPermisoUsuario;
	}
	

	
}
