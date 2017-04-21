package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the BusinessEntityContact database table.
 * 
 */
@Entity(name="BusinessEntityContact")
@Table(name="BusinessEntityContact", schema="Person")
@Access(AccessType.FIELD)
public class BusinessEntityContact extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BusinessEntityContactPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to BusinessEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private BusinessEntity businessEntity;

	//bi-directional many-to-one association to ContactType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ContactTypeID", insertable=false, updatable=false)
	private ContactType contactType;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PersonID", insertable=false, updatable=false)
	private Person person;

	public BusinessEntityContact() {
	}

	public BusinessEntityContactPK getId() {
		return this.id;
	}

	public void setId(BusinessEntityContactPK id) {
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

	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	public ContactType getContactType() {
		return this.contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}