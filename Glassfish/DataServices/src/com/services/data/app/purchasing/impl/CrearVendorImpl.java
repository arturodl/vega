package com.services.data.app.purchasing.impl;

import com.core.app.servicios.entidad.ServicioEntidad;
import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.services.data.app.purchasing.CrearVendor;

public class CrearVendorImpl implements CrearVendor{
	
	private ServicioEntidad crearEntidad;

	@Override
	public CrearVendorRespuesta ejecutar(CrearVendorPeticion peticion) {
		// TODO Auto-generated method stub
		CrearVendorRespuesta respuesta = null;
		try{
			crearEntidad.ejecutar(peticion);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Hubo un error: "+e.getCause());
		}
		
		return respuesta;
	}

	public ServicioEntidad getCrearEntidad() {
		return crearEntidad;
	}

	public void setCrearEntidad(ServicioEntidad crearEntidad) {
		this.crearEntidad = crearEntidad;
	}

}
