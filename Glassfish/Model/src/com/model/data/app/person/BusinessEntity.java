package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.core.app.modelo.Entidad;
import com.model.data.app.purchasing.Vendor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BusinessEntity database table.
 * 
 */
@Entity(name="BusinessEntity")
@Table(name="BusinessEntity") //, schema="Person")
@Access(AccessType.FIELD)
public class BusinessEntity extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID")
	@Basic(optional=false)
	private int businessEntityID;
	
	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;
	
	@Column(name="rowguid", insertable=false, updatable=false)
	private String rowguid;

	@Column(name="ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;	

/*	//bi-directional many-to-one association to BusinessEntityAddress
	@OneToOne(mappedBy="businessEntity", fetch=FetchType.LAZY)
	private BusinessEntityAddress businessEntityAddress;

	//bi-directional many-to-one association to BusinessEntityContact
	@OneToMany(mappedBy="businessEntity", fetch=FetchType.LAZY)
	private List<BusinessEntityContact> businessEntityContacts;

	//bi-directional one-to-one association to Person
	@OneToOne(mappedBy="businessEntity")
	private Person person;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="businessEntity", fetch=FetchType.LAZY)
	private Vendor vendor;*/
	
	public BusinessEntity() {
	}
	
	

/*	public BusinessEntityAddress getBusinessEntityAddress() {
		return businessEntityAddress;
	}



	public void setBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		this.businessEntityAddress = businessEntityAddress;
	}



	public Vendor getVendor() {
		return vendor;
	}



	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
*/


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

	/*
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
*/
/*	public List<BusinessEntityContact> getBusinessEntityContacts() {
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
	}*/

/*	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
*/
	public int getBusinessEntityID() {
		return businessEntityID;
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

}