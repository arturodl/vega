package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.data.app.person.BusinessEntity;
import com.model.data.app.person.Person;
import com.model.data.app.purchasing.Vendor;
import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.services.facade.app.purchasing.Purchasing;

public class TestPurchasing extends SpringAbstractTest {

	@Autowired
	public Purchasing purchasing;
	
	@Test
	public void testCrearVendor(){
		CrearVendorPeticion peticion = new CrearVendorPeticion();
		CrearVendorRespuesta respuesta = null;
		/*BusinessEntity entidadNegocio = new BusinessEntity();
		//entidadNegocio.setRowguid("91793871370192301891830912301");
		entidadNegocio.setModifiedDate(new Date());
		peticion.setEntidad(entidadNegocio);
		try{
			purchasing.crearVendor(peticion);
			assertTrue(true);
		}catch(Exception e){
			fail();
		}*/
		
		BusinessEntity entidadNegocio = new BusinessEntity();
		entidadNegocio.setModifiedDate(new Date());
		
		Vendor vendor = new Vendor();	
		vendor.setAccountNumber("Arturo004");
		vendor.setName("ALR");
		vendor.setCreditRating((short)1);
		vendor.setPreferredVendorStatus(true);
		vendor.setActiveFlag(true);
		vendor.setModifiedDate(new Date());
		vendor.setBusinessEntity(entidadNegocio);
		
		entidadNegocio.setVendor(vendor);
		
		 peticion.setEntidad(entidadNegocio);
		
		
		
		try{
			respuesta = purchasing.crearVendor(peticion);
			System.out.println( ((BusinessEntity)respuesta.getEntidad()).getBusinessEntityID() );
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
	
	
}
