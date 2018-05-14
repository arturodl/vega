package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the PersonPhone database table.
 * 
 */
@Entity(name="PersonPhone")
@Table(name="PersonPhone") //, schema="Person")
@Access(AccessType.FIELD)
public class PersonPhone extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonPhonePK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private Person person;

	//bi-directional many-to-one association to PhoneNumberType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PhoneNumberTypeID", insertable=false, updatable=false)
	private PhoneNumberType phoneNumberType;

	public PersonPhone() {
	}

	public PersonPhonePK getId() {
		return this.id;
	}

	public void setId(PersonPhonePK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PhoneNumberType getPhoneNumberType() {
		return this.phoneNumberType;
	}

	public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

}