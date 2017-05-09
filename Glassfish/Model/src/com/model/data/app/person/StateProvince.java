package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StateProvince database table.
 * 
 */
@Entity(name="StateProvince")
@Table(name="StateProvince", schema="Person")
@Access(AccessType.FIELD)
public class StateProvince extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StateProvinceID")
	@Basic(optional=false)
	private int stateProvinceID;
	
	@Column(name="StateProvinceID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="IsOnlyStateProvinceFlag")
	private boolean isOnlyStateProvinceFlag;

	@Column(name="ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name="Name")
	private String name;

	@Column(name="rowguid", insertable=false, updatable=false)
	private String rowguid;

	@Column(name="StateProvinceCode")
	private String stateProvinceCode;

	@Column(name="TerritoryID")
	private int territoryID;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="stateProvince", fetch=FetchType.LAZY)
	private List<Address> addresses;

	//bi-directional many-to-one association to CountryRegion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CountryRegionCode")
	private CountryRegion countryRegion;

	public StateProvince() {
	}

	public int getStateProvinceID() {
		return this.stateProvinceID;
	}

	public void setStateProvinceID(int stateProvinceID) {
		this.stateProvinceID = stateProvinceID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsOnlyStateProvinceFlag() {
		return this.isOnlyStateProvinceFlag;
	}

	public void setIsOnlyStateProvinceFlag(boolean isOnlyStateProvinceFlag) {
		this.isOnlyStateProvinceFlag = isOnlyStateProvinceFlag;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public String getStateProvinceCode() {
		return this.stateProvinceCode;
	}

	public void setStateProvinceCode(String stateProvinceCode) {
		this.stateProvinceCode = stateProvinceCode;
	}

	public int getTerritoryID() {
		return this.territoryID;
	}

	public void setTerritoryID(int territoryID) {
		this.territoryID = territoryID;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setStateProvince(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setStateProvince(null);

		return address;
	}

	public CountryRegion getCountryRegion() {
		return this.countryRegion;
	}

	public void setCountryRegion(CountryRegion countryRegion) {
		this.countryRegion = countryRegion;
	}

}