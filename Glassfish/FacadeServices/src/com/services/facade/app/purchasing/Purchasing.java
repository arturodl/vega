package com.services.facade.app.purchasing;

import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;

public interface Purchasing {
		public CrearVendorRespuesta crearVendor(CrearVendorPeticion peticion);
}
