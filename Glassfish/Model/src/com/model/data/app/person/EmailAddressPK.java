package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EmailAddress database table.
 * 
 */
@Embeddable
public class EmailAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Column(name="EmailAddressID")
	private int emailAddressID;

	public EmailAddressPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public int getEmailAddressID() {
		return this.emailAddressID;
	}
	public void setEmailAddressID(int emailAddressID) {
		this.emailAddressID = emailAddressID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmailAddressPK)) {
			return false;
		}
		EmailAddressPK castOther = (EmailAddressPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& (this.emailAddressID == castOther.emailAddressID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.emailAddressID;
		
		return hash;
	}
}