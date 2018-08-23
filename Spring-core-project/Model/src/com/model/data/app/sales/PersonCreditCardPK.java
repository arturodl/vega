package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PersonCreditCard database table.
 * 
 */
@Embeddable
public class PersonCreditCardPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Column(name="CreditCardID", insertable=false, updatable=false)
	private int creditCardID;

	public PersonCreditCardPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public int getCreditCardID() {
		return this.creditCardID;
	}
	public void setCreditCardID(int creditCardID) {
		this.creditCardID = creditCardID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonCreditCardPK)) {
			return false;
		}
		PersonCreditCardPK castOther = (PersonCreditCardPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& (this.creditCardID == castOther.creditCardID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.creditCardID;
		
		return hash;
	}
}