package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BusinessEntityAddress database table.
 * 
 */
@Embeddable
public class BusinessEntityAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int businessEntityID;

	private int addressID;

	private int addressTypeID;

	public BusinessEntityAddressPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public int getAddressID() {
		return this.addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public int getAddressTypeID() {
		return this.addressTypeID;
	}
	public void setAddressTypeID(int addressTypeID) {
		this.addressTypeID = addressTypeID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BusinessEntityAddressPK)) {
			return false;
		}
		BusinessEntityAddressPK castOther = (BusinessEntityAddressPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& (this.addressID == castOther.addressID)
			&& (this.addressTypeID == castOther.addressTypeID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.addressID;
		hash = hash * prime + this.addressTypeID;
		
		return hash;
	}
}