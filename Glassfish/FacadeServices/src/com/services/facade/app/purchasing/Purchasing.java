package com.services.facade.app.purchasing;

import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorPeticion;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorRespuesta;
import com.services.business.app.purchasing.RegistrarProveedor;

public interface Purchasing {
		public CrearVendorRespuesta crearVendor(CrearVendorPeticion peticion);
		public RegistrarProveedorRespuesta registrarProveedor(RegistrarProveedorPeticion peticion); 
}
