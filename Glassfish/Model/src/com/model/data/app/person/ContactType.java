package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ContactType database table.
 * 
 */
@Entity(name="ContactType")
@Table(name="ContactType") //, schema="Person")
@Access(AccessType.FIELD)
public class ContactType extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ContactTypeID")
	@Basic(optional=false)
	private int contactTypeID;
	
	@Column(name="ContactTypeID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to BusinessEntityContact
	@OneToMany(mappedBy="contactType", fetch=FetchType.LAZY)
	private List<BusinessEntityContact> businessEntityContacts;

	public ContactType() {
	}

	public int getContactTypeID() {
		return this.contactTypeID;
	}

	public void setContactTypeID(int contactTypeID) {
		this.contactTypeID = contactTypeID;
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

	public List<BusinessEntityContact> getBusinessEntityContacts() {
		return this.businessEntityContacts;
	}

	public void setBusinessEntityContacts(List<BusinessEntityContact> businessEntityContacts) {
		this.businessEntityContacts = businessEntityContacts;
	}

	public BusinessEntityContact addBusinessEntityContact(BusinessEntityContact businessEntityContact) {
		getBusinessEntityContacts().add(businessEntityContact);
		businessEntityContact.setContactType(this);

		return businessEntityContact;
	}

	public BusinessEntityContact removeBusinessEntityContact(BusinessEntityContact businessEntityContact) {
		getBusinessEntityContacts().remove(businessEntityContact);
		businessEntityContact.setContactType(null);

		return businessEntityContact;
	}

}