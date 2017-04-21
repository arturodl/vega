package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Address database table.
 * 
 */
@Entity(name="Address")
@Table(name="Address", schema="Person")
@Access(AccessType.FIELD)
public class Address extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AddressID")
	@Basic(optional=false)
	private int addressID;

	@Column(name="AddressID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="AddressLine1")
	private String addressLine1;

	@Column(name="AddressLine2")
	private String addressLine2;

	@Column(name="City")
	private String city;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="PostalCode")
	private String postalCode;

	private String rowguid;

	@Column(name="SpatialLocation")
	private byte[] spatialLocation;

	//bi-directional many-to-one association to StateProvince
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="StateProvinceID")
	private StateProvince stateProvince;

	//bi-directional many-to-one association to BusinessEntityAddress
	@OneToMany(mappedBy="address", fetch=FetchType.LAZY)
	private List<BusinessEntityAddress> businessEntityAddresses;

	public Address() {
	}

	public int getAddressID() {
		return this.addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public byte[] getSpatialLocation() {
		return this.spatialLocation;
	}

	public void setSpatialLocation(byte[] spatialLocation) {
		this.spatialLocation = spatialLocation;
	}

	public StateProvince getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(StateProvince stateProvince) {
		this.stateProvince = stateProvince;
	}

	public List<BusinessEntityAddress> getBusinessEntityAddresses() {
		return this.businessEntityAddresses;
	}

	public void setBusinessEntityAddresses(List<BusinessEntityAddress> businessEntityAddresses) {
		this.businessEntityAddresses = businessEntityAddresses;
	}

	public BusinessEntityAddress addBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		getBusinessEntityAddresses().add(businessEntityAddress);
		businessEntityAddress.setAddress(this);

		return businessEntityAddress;
	}

	public BusinessEntityAddress removeBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		getBusinessEntityAddresses().remove(businessEntityAddress);
		businessEntityAddress.setAddress(null);

		return businessEntityAddress;
	}

}