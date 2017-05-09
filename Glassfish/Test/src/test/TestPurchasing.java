package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.data.app.person.Address;
import com.model.data.app.person.AddressType;
import com.model.data.app.person.BusinessEntity;
import com.model.data.app.person.BusinessEntityAddress;
import com.model.data.app.person.Person;
import com.model.data.app.person.StateProvince;
import com.model.data.app.purchasing.Vendor;
import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorPeticion;
import com.services.facade.app.purchasing.Purchasing;

public class TestPurchasing extends SpringAbstractTest {

	@Autowired
	public Purchasing purchasing;
	
	@Test
	public void testCrearVendor(){
		CrearVendorPeticion peticion = new CrearVendorPeticion();
		CrearVendorRespuesta respuesta = null;
	/*	BusinessEntity entidadNegocio = new BusinessEntity();
		//entidadNegocio.setRowguid("91793871370192301891830912301");
		entidadNegocio.setModifiedDate(new Date());
		peticion.setEntidad(entidadNegocio);
		try{
			purchasing.crearVendor(peticion);
			assertTrue(true);
		}catch(Exception e){
			fail();
		}*/
		
	/*	BusinessEntity entidadNegocio = new BusinessEntity();
		entidadNegocio.setModifiedDate(new Date());
		
		Address direccion = new Address();
		direccion.setAddressLine1("juarez 207 - 16");
		direccion.setCity("Xalapa");
		StateProvince provincia = new StateProvince();
		provincia.setStateProvinceID(3);
		
		
		direccion.setStateProvince(provincia);
		direccion.setPostalCode("91000");
		direccion.setModifiedDate(new Date());
		
		AddressType tipoDireccion = new AddressType();
		tipoDireccion.setAddressTypeID(3);
		//tipoDireccion.setModifiedDate(new Date());
		//tipoDireccion.setName("arturo333333");
		
		BusinessEntityAddress direccionEntidad = new BusinessEntityAddress();
		direccionEntidad.setAddressType(tipoDireccion);
		direccionEntidad.setAddress(direccion);
		direccionEntidad.setBusinessEntity(entidadNegocio);		
		direccionEntidad.setModifiedDate(new Date());
		
		entidadNegocio.setBusinessEntityAddress(direccionEntidad);
		direccion.setBusinessEntityAddress(direccionEntidad);
		//tipoDireccion.setBusinessEntityAddress(direccionEntidad);
				
		peticion.setEntidad(direccion); */
		
		/*BusinessEntity entidadNegocio = new BusinessEntity();
		entidadNegocio.setBusinessEntityID(20947);
		
	    Vendor vendor = new Vendor();	
		vendor.setAccountNumber("Arturo023");
		vendor.setName("ALR");
		vendor.setCreditRating((short)1);
		vendor.setPreferredVendorStatus(true);
		vendor.setActiveFlag(true);
		vendor.setModifiedDate(new Date());
		vendor.setPurchasingWebServiceURL("www.arturodl.com");
		vendor.setBusinessEntity(entidadNegocio);
		
		//entidadNegocio.setVendor(vendor);
		
		peticion.setEntidad(vendor);*/
		
		RegistrarProveedorPeticion peticionRegistrarProveedor = new RegistrarProveedorPeticion();
		
		
		try{
			purchasing.registrarProveedor(peticionRegistrarProveedor);
			//respuesta = purchasing.crearVendor(peticion);
			//System.out.println( ((Vendor)respuesta.getEntidad()).getBusinessEntity().getBusinessEntityID() );
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
	
	
}
