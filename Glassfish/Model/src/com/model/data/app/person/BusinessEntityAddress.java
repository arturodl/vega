package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the BusinessEntityAddress database table.
 * 
 */
@Entity(name="BusinessEntityAddress")
@Table(name="BusinessEntityAddress", schema="Person")
@Access(AccessType.FIELD)
public class BusinessEntityAddress extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BusinessEntityAddressPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AddressID", insertable=false, updatable=false)
	private Address address;

	//bi-directional many-to-one association to AddressType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AddressTypeID", insertable=false, updatable=false)
	private AddressType addressType;

	//bi-directional many-to-one association to BusinessEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private BusinessEntity businessEntity;

	public BusinessEntityAddress() {
	}

	public BusinessEntityAddressPK getId() {
		return this.id;
	}

	public void setId(BusinessEntityAddressPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

}