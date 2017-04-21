package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CountryRegion database table.
 * This table contains all codes of every region into a state
 * 
 * Esta tabla es un catalogo que contiene todas las regiones y sus respectivos codigos
 * al parecer no es necesario actualizar tener una columna como identity
 */
@Entity(name="CountryRegion")
@Table(name="CountryRegion", schema="Person")
@Access(AccessType.FIELD)
public class CountryRegion extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CountryRegionCode")
	@Basic(optional=false)
	private String countryRegionCode;

	@Column(name="ModifiedDate")
	@Basic(optional=false)
	private Timestamp modifiedDate;

	@Column(name="Name")
	@Basic(optional=false)
	private String name;

	//bi-directional many-to-one association to StateProvince
	@OneToMany(mappedBy="countryRegion", fetch=FetchType.LAZY)
	private List<StateProvince> stateProvinces;

	public CountryRegion() {
	}

	public String getCountryRegionCode() {
		return this.countryRegionCode;
	}

	public void setCountryRegionCode(String countryRegionCode) {
		this.countryRegionCode = countryRegionCode;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StateProvince> getStateProvinces() {
		return this.stateProvinces;
	}

	public void setStateProvinces(List<StateProvince> stateProvinces) {
		this.stateProvinces = stateProvinces;
	}

	public StateProvince addStateProvince(StateProvince stateProvince) {
		getStateProvinces().add(stateProvince);
		stateProvince.setCountryRegion(this);

		return stateProvince;
	}

	public StateProvince removeStateProvince(StateProvince stateProvince) {
		getStateProvinces().remove(stateProvince);
		stateProvince.setCountryRegion(null);

		return stateProvince;
	}

}