package com.primefacesmc.beans.aplicacion.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.model.data.app.security.UserRole;
import org.springframework.security.core.userdetails.User;
import com.obj.transf.datos.app.security.ObtenerUsuariosPorCriterioPeticion;
import com.services.facade.app.security.Security;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private Security security;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.model.data.app.security.User usuario = obtenerUsuarioPorNombre(username);
		
		List<GrantedAuthority> authorities = buildUserAuthority(usuario.getUserRoles());

		return buildUserForAuthentication(usuario, authorities);		
	}
	
	private User buildUserForAuthentication(com.model.data.app.security.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), 
				        user.getPassword(), 
				        user.getEnabled() == 1 , 
	                    true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
	
	private com.model.data.app.security.User obtenerUsuarioPorNombre(String username) throws UsernameNotFoundException {
		System.out.println("El nombre de usuario a buscar es: "+username);
		ObtenerUsuariosPorCriterioPeticion peticion = new ObtenerUsuariosPorCriterioPeticion();
			
		com.model.data.app.security.User user = new com.model.data.app.security.User();
		user.setUsernameForCriteria(username);
		user.setEnabled((byte)1);
		
		peticion.setEntidad(user);
		peticion.setClase(com.model.data.app.security.User.class);
		
		try {
			List<com.model.data.app.security.User> listaUsuarios = security.obtenerUsuariosPorCriterio(peticion).getListaEntidades();	
			
			if(listaUsuarios.size() <= 0) {
				throw new UsernameNotFoundException(username);
			}
			
			user = listaUsuarios.get(0);			
			System.out.println("Total de usuarios obtenidos: "+listaUsuarios.size());
			return user;			
		}catch(Exception e){
			e.printStackTrace();	
			throw new UsernameNotFoundException(username);
		}		
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}
