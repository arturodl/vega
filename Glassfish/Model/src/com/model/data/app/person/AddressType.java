package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AddressType database table.
 * 
 */
@Entity(name="AddressType")
@Table(name="AddressType", schema="Person")
@Access(AccessType.FIELD)
public class AddressType extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AddressTypeID")
	@Basic(optional=false)
	private int addressTypeID;
	
	@Column(name="AddressTypeID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	//bi-directional many-to-one association to BusinessEntityAddress
	@OneToMany(mappedBy="addressType", fetch=FetchType.LAZY)
	private List<BusinessEntityAddress> businessEntityAddresses;

	public AddressType() {
	}

	public int getAddressTypeID() {
		return this.addressTypeID;
	}

	public void setAddressTypeID(int addressTypeID) {
		this.addressTypeID = addressTypeID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public List<BusinessEntityAddress> getBusinessEntityAddresses() {
		return this.businessEntityAddresses;
	}

	public void setBusinessEntityAddresses(List<BusinessEntityAddress> businessEntityAddresses) {
		this.businessEntityAddresses = businessEntityAddresses;
	}

	public BusinessEntityAddress addBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		getBusinessEntityAddresses().add(businessEntityAddress);
		businessEntityAddress.setAddressType(this);

		return businessEntityAddress;
	}

	public BusinessEntityAddress removeBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		getBusinessEntityAddresses().remove(businessEntityAddress);
		businessEntityAddress.setAddressType(null);

		return businessEntityAddress;
	}

}