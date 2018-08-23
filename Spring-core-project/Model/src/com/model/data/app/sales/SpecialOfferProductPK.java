package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SpecialOfferProduct database table.
 * 
 */
@Embeddable
public class SpecialOfferProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SpecialOfferID", insertable=false, updatable=false)
	private int specialOfferID;

	@Column(name="ProductID", insertable=false, updatable=false)
	private int productID;

	public SpecialOfferProductPK() {
	}
	public int getSpecialOfferID() {
		return this.specialOfferID;
	}
	public void setSpecialOfferID(int specialOfferID) {
		this.specialOfferID = specialOfferID;
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SpecialOfferProductPK)) {
			return false;
		}
		SpecialOfferProductPK castOther = (SpecialOfferProductPK)other;
		return 
			(this.specialOfferID == castOther.specialOfferID)
			&& (this.productID == castOther.productID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.specialOfferID;
		hash = hash * prime + this.productID;
		
		return hash;
	}
}