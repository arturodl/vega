package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.obj.transf.datos.app.facturacion.GenerarFacturacionPeticion;
import com.services.facade.app.facturacion.Facturacion;

public class TestFacturacion extends SpringAbstractTest {

	@Autowired
	private Facturacion facturacion;
	
	@Test
	public void testGenerarFacturacion(){
		GenerarFacturacionPeticion peticion = new GenerarFacturacionPeticion();
		
		try{
			facturacion.generarFacturacion(peticion);
			assertTrue(true);
		}catch(Exception e){
			fail();
		}
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}
}
