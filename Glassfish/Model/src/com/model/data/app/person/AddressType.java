package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.Date;
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
	private Integer addressTypeID;
	
	@Column(name="AddressTypeID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional=true)
	private Date modifiedDate;

	@Column(name="Name")
	@Basic(optional=true)
	private String name;

	@Column(name="rowguid", insertable=false, updatable=false)
	@Basic(optional=true)
	private String rowguid;

	public AddressType() {
	}
	
	public Integer getAddressTypeID() {
		return this.addressTypeID;
	}

	public void setAddressTypeID(Integer addressTypeID) {
		this.addressTypeID = addressTypeID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

/*	public List<BusinessEntityAddress> getBusinessEntityAddresses() {
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
	}*/

}