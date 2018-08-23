package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BusinessEntityContact database table.
 * 
 */
@Embeddable
public class BusinessEntityContactPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Column(name="PersonID", insertable=false, updatable=false)
	private int personID;

	@Column(name="ContactTypeID", insertable=false, updatable=false)
	private int contactTypeID;

	public BusinessEntityContactPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public int getPersonID() {
		return this.personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getContactTypeID() {
		return this.contactTypeID;
	}
	public void setContactTypeID(int contactTypeID) {
		this.contactTypeID = contactTypeID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BusinessEntityContactPK)) {
			return false;
		}
		BusinessEntityContactPK castOther = (BusinessEntityContactPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& (this.personID == castOther.personID)
			&& (this.contactTypeID == castOther.contactTypeID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.personID;
		hash = hash * prime + this.contactTypeID;
		
		return hash;
	}
}