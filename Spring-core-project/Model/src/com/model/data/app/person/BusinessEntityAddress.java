package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.Date;


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
	private BusinessEntityAddressPK id = new BusinessEntityAddressPK();	

	@Column(name="ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name="rowguid", insertable=false, updatable=false)
	private String rowguid;

	//bi-directional many-to-one association to Address
	@OneToOne
	@JoinColumn(name="addressID", referencedColumnName="addressID", insertable=false, updatable=false)
	private Address address;

	//bi-directional many-to-one association to AddressType
	@ManyToOne
	@JoinColumn(name="addressTypeID", referencedColumnName="addressTypeID", insertable=false, updatable= false)
	private AddressType addressType;

	//bi-directional many-to-one association to BusinessEntity
	@OneToOne
	@JoinColumn(name="businessEntityID", referencedColumnName="businessEntityID", insertable=false, updatable=false)
	private BusinessEntity businessEntity;

	public BusinessEntityAddress() {
	}

	public BusinessEntityAddressPK getId() {
		return this.id;
	}

	public void setId(BusinessEntityAddressPK id) {
		this.id = id;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
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
		this.id.setAddressID(address.getAddressID());
		//this.address.setBusinessEntityAddress(this);
	}

	public AddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
		this.id.setAddressTypeID(addressType.getAddressTypeID());
		//this.addressType.setBusinessEntityAddress(this);
	}

	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
		this.id.setBusinessEntityID(this.businessEntity.getBusinessEntityID());
		//this.businessEntity.setBusinessEntityAddress(this);
	}

}