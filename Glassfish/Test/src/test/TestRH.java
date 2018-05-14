package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.services.facade.app.rh.Rh;
import com.model.data.app.humanresources.Department;

public class TestRH extends SpringAbstractTest{

	@Autowired
	private Rh rh;
	
	
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
	
	@Test
	public void testObtenerDepartamento(){
		ObtenerDepartamentosPorCriterioPeticion peticion = new ObtenerDepartamentosPorCriterioPeticion();
		Department departamento = new Department();
		departamento.setName("UX Department");
		
		peticion.setEntidad(departamento);
		peticion.setClase(Department.class);
		
		try {
			List<Department> listaDepartamentos = rh.obtenerDepartamentosPorCriterio(peticion).getListaEntidades();
			System.out.println("Total de departamentos obtenidos: "+listaDepartamentos.size());
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
