package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the EmailAddress database table.
 * 
 */
@Entity(name="EmailAddress")
@Table(name="EmailAddress") //, schema="Person")
@Access(AccessType.FIELD)
public class EmailAddress extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmailAddressPK id;

	@Column(name="EmailAddress")
	private String emailAddress;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private Person person;

	public EmailAddress() {
	}

	public EmailAddressPK getId() {
		return this.id;
	}

	public void setId(EmailAddressPK id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}