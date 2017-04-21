package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the BusinessEntity database table.
 * 
 */
@Entity(name="BusinessEntity")
@Table(name="BusinessEntity", schema="Person")
@Access(AccessType.FIELD)
public class BusinessEntity extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID")
	@Basic(optional=true)
	private int businessEntityID;
	
	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	@Basic(optional=true)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to BusinessEntityAddress
	@OneToMany(mappedBy="businessEntity", fetch=FetchType.LAZY)
	private List<BusinessEntityAddress> businessEntityAddresses;

	//bi-directional many-to-one association to BusinessEntityContact
	@OneToMany(mappedBy="businessEntity", fetch=FetchType.LAZY)
	private List<BusinessEntityContact> businessEntityContacts;

	//bi-directional one-to-one association to Person
	@OneToOne(mappedBy="businessEntity", fetch=FetchType.LAZY)
	private Person person;

	public BusinessEntity() {
	}

	public int getBusinessEntityID() {
		return this.businessEntityID;
	}

	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
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
		businessEntityAddress.setBusinessEntity(this);

		return businessEntityAddress;
	}

	public BusinessEntityAddress removeBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		getBusinessEntityAddresses().remove(businessEntityAddress);
		businessEntityAddress.setBusinessEntity(null);

		return businessEntityAddress;
	}

	public List<BusinessEntityContact> getBusinessEntityContacts() {
		return this.businessEntityContacts;
	}

	public void setBusinessEntityContacts(List<BusinessEntityContact> businessEntityContacts) {
		this.businessEntityContacts = businessEntityContacts;
	}

	public BusinessEntityContact addBusinessEntityContact(BusinessEntityContact businessEntityContact) {
		getBusinessEntityContacts().add(businessEntityContact);
		businessEntityContact.setBusinessEntity(this);

		return businessEntityContact;
	}

	public BusinessEntityContact removeBusinessEntityContact(BusinessEntityContact businessEntityContact) {
		getBusinessEntityContacts().remove(businessEntityContact);
		businessEntityContact.setBusinessEntity(null);

		return businessEntityContact;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}