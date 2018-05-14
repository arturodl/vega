package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PhoneNumberType database table.
 * 
 */
@Entity(name="PhoneNumberType")
@Table(name="PhoneNumberType") //, schema="Person")
@Access(AccessType.FIELD)
public class PhoneNumberType extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PhoneNumberTypeID")
	@Basic(optional=false)
	private int phoneNumberTypeID;
	
	@Column(name="PhoneNumberTypeID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to PersonPhone
	@OneToMany(mappedBy="phoneNumberType", fetch=FetchType.LAZY)
	private List<PersonPhone> personPhones;

	public PhoneNumberType() {
	}

	public int getPhoneNumberTypeID() {
		return this.phoneNumberTypeID;
	}

	public void setPhoneNumberTypeID(int phoneNumberTypeID) {
		this.phoneNumberTypeID = phoneNumberTypeID;
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

	public List<PersonPhone> getPersonPhones() {
		return this.personPhones;
	}

	public void setPersonPhones(List<PersonPhone> personPhones) {
		this.personPhones = personPhones;
	}

	public PersonPhone addPersonPhone(PersonPhone personPhone) {
		getPersonPhones().add(personPhone);
		personPhone.setPhoneNumberType(this);

		return personPhone;
	}

	public PersonPhone removePersonPhone(PersonPhone personPhone) {
		getPersonPhones().remove(personPhone);
		personPhone.setPhoneNumberType(null);

		return personPhone;
	}

}