package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.obj.transf.datos.app.rh.CrearDepartamentoPeticion;
import com.obj.transf.datos.app.rh.ObtenerDepartamentosPorCriterioPeticion;
import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioPeticion;
import com.services.facade.app.rh.Rh;
import com.services.facade.app.security.Security;
import com.model.data.app.humanresources.Department;
import com.model.data.app.security.User;

public class TestSecurity extends SpringAbstractTest{

	@Autowired
	private Security security;
	
	@Test
	public void testObtenerUsuarios(){
		ObtenerUsuariosPorCriterioPeticion peticion = new ObtenerUsuariosPorCriterioPeticion();
		User user = new User();
		user.setUsernameForCriteria("arturo");
		user.setEnabled((byte)1);
			
		peticion.setEntidad(user);
		peticion.setClase(User.class);
		
		try {
			List<User> listaUsuarios = security.obtenerUsuariosPorCriterio(peticion).getListaEntidades();			
			System.out.println("Total de usuarios obtenidos: "+listaUsuarios.size());
			System.out.println("El primer usuario es: "+listaUsuarios.get(0).getUsername());
			System.out.println("Los Roles del usuario son: "+listaUsuarios.get(0).getUserRoles());
			System.out.println("El Rol del primer usuario es: "+ listaUsuarios.get(0).getUserRoles().get(0).getRole());
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();			
			fail();
		}
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	
}
