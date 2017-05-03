package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.data.app.person.BusinessEntity;
import com.model.data.app.purchasing.Vendor;
import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.services.facade.app.purchasing.Purchasing;

public class TestPurchasing extends SpringAbstractTest {

	@Autowired
	public Purchasing purchasing;
	
	@Test
	public void testCrearVendor(){
		CrearVendorPeticion peticion = new CrearVendorPeticion();
		BusinessEntity entidadNegocio = new BusinessEntity();
		//entidadNegocio.setRowguid("91793871370192301891830912301");
		entidadNegocio.setModifiedDate(new Date());
		peticion.setEntidad(entidadNegocio);
		try{
			purchasing.crearVendor(peticion);
			assertTrue(true);
		}catch(Exception e){
			fail();
		}
		
		/** Vendor vendor = new Vendor();
		vendor.setAccountNumber("Arturo001");
		vendor.setName("ALR");
		vendor.setCreditRating((short)1);
		vendor.setPreferredVendorStatus(true);
		vendor.setActiveFlag(true);
		vendor.setModifiedDate(new Date());
		peticion.setEntidad(vendor);
		try{
			purchasing.crearVendor(peticion);
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}**/
	}
	
	
}
