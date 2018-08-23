package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PersonPhone database table.
 * 
 */
@Embeddable
public class PersonPhonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberTypeID", insertable=false, updatable=false)
	private int phoneNumberTypeID;

	public PersonPhonePK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPhoneNumberTypeID() {
		return this.phoneNumberTypeID;
	}
	public void setPhoneNumberTypeID(int phoneNumberTypeID) {
		this.phoneNumberTypeID = phoneNumberTypeID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonPhonePK)) {
			return false;
		}
		PersonPhonePK castOther = (PersonPhonePK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& this.phoneNumber.equals(castOther.phoneNumber)
			&& (this.phoneNumberTypeID == castOther.phoneNumberTypeID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.phoneNumber.hashCode();
		hash = hash * prime + this.phoneNumberTypeID;
		
		return hash;
	}
}