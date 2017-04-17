package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.services.facade.app.rh.Rh;
import com.model.data.app.humanresources.Department;

public class TestRH extends SpringAbstractTest{

	@Autowired
	private Rh rh;
	
	@Test
	public void testCrearDepartamento(){
		CrearDepartamentoPeticion peticion = new CrearDepartamentoPeticion();
		Department departamento = new Department();
		departamento.setName("Data Mining");
		departamento.setGroupName("TI");
		departamento.setModifiedDate(new Date());
		peticion.setEntidad(departamento);
		try{
			rh.crearDepartamento(peticion);
			assertTrue(true);
		}catch(Exception e){
			fail();
		}
	}

	public Rh getRh() {
		return rh;
	}

	public void setRh(Rh rh) {
		this.rh = rh;
	}

}
