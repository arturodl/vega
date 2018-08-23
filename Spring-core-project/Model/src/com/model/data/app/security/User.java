package com.model.data.app.security;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity(name="User")
@Table(name="User") //, schema="Person")
@Access(AccessType.FIELD)
public class User extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="username", updatable = false, insertable = false)
	private String usernameForCriteria;

	@Column(name="enabled")
	private byte enabled;

	@Column(name="password")
	private String password;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<UserRole> userRoles;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	

	public String getUsernameForCriteria() {
		return usernameForCriteria;
	}

	public void setUsernameForCriteria(String usernameForCriteria) {
		this.usernameForCriteria = usernameForCriteria;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}