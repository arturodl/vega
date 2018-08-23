package com.services.business.app.purchasing.impl;

import java.util.Date;

import com.model.data.app.person.Address;
import com.model.data.app.person.AddressType;
import com.model.data.app.person.BusinessEntity;
import com.model.data.app.person.BusinessEntityAddress;
import com.model.data.app.person.StateProvince;
import com.model.data.app.purchasing.Vendor;
import com.obj.transf.datos.app.purchasing.CrearVendorPeticion;
import com.obj.transf.datos.app.purchasing.CrearVendorRespuesta;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorPeticion;
import com.obj.transf.datos.app.purchasing.RegistrarProveedorRespuesta;
import com.services.business.app.purchasing.RegistrarProveedor;
import com.services.data.app.purchasing.CrearVendor;

public class RegistrarProveedorImpl implements RegistrarProveedor{
	
	private CrearVendor crearVendor;
	
	@Override
	public RegistrarProveedorRespuesta ejecutar(RegistrarProveedorPeticion peticion) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido a Registrar Proveedor");
		RegistrarProveedorRespuesta respuestaRegistrarProveedor = null;
		CrearVendorPeticion peticionCrearVendor = new CrearVendorPeticion();
		CrearVendorRespuesta respuestaCrearVendor = null;
		
		// Seteamos los valores de la entidad principal y del proveedor
		BusinessEntity entidadNegocio = new BusinessEntity();
		entidadNegocio.setModifiedDate(new Date());
		//entidadNegocio.setBusinessEntityID(20947);
		
	    Vendor vendor = new Vendor();	
		vendor.setAccountNumber("Arturo025");
		vendor.setName("ALR");
		vendor.setCreditRating(1);
		vendor.setPreferredVendorStatus(2);
		vendor.setActiveFlag(2);
		vendor.setModifiedDate(new Date());
		vendor.setPurchasingWebServiceURL("www.arturodl.com");
		vendor.setBusinessEntity(entidadNegocio);
		
		//entidadNegocio.setVendor(vendor);
		// terminan los valores de la entidad principal y del proveedor
		
		// guardamos primero la entidad principal junto con el vendor
		System.out.println("Antes de crear entidadNegocio");
		peticionCrearVendor.setEntidad(entidadNegocio);
		respuestaCrearVendor = crearVendor.ejecutar(peticionCrearVendor);
		System.out.println(">>>>>>>>>> Nuevo bussines entity creado: "+((BusinessEntity)respuestaCrearVendor.getEntidad()).getBusinessEntityID());
		
		// seteamos los valores de la direccion y del tipo direccion
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
		// terminan los valores de la direccion y del tipo direccion
		
		//guardamos los valores de la direccion
		System.out.println("Antes de crear Direccion");
		peticionCrearVendor.setEntidad(direccion);
		respuestaCrearVendor = crearVendor.ejecutar(peticionCrearVendor);
		System.out.println(">>>>>>>>>>>>>> Nueva direccion: "+((Address) respuestaCrearVendor.getEntidad()).getAddressID());
		
		// Seteamos los valores de la entidad ternaria
		BusinessEntityAddress direccionEntidad = new BusinessEntityAddress();
		direccionEntidad.setAddress(direccion);
		direccionEntidad.setAddressType(tipoDireccion);
		direccionEntidad.setBusinessEntity(entidadNegocio);
		direccionEntidad.setModifiedDate(new Date());
		// terminan los valores de la entidad ternaria
		
		// guardamos los valores de la entidad ternaria
		System.out.println("Antes de crear Direccion Entidad");
		peticionCrearVendor.setEntidad(direccionEntidad);
		respuestaCrearVendor = crearVendor.ejecutar(peticionCrearVendor);
		System.out.println(">>>>>>>>>>>>>>>>>>> Nueva direccion entidad: "+((BusinessEntityAddress)respuestaCrearVendor.getEntidad()).getBusinessEntity() );
		System.out.println("Ha terminado el metodo Registrar Proveedor");
		return respuestaRegistrarProveedor;
	}

	public CrearVendor getCrearVendor() {
		return crearVendor;
	}

	public void setCrearVendor(CrearVendor crearVendor) {
		this.crearVendor = crearVendor;
	}

}
