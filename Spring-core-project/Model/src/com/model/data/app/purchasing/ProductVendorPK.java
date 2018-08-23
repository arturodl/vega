package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductVendor database table.
 * 
 */
@Embeddable
public class ProductVendorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductID", insertable=false, updatable=false)
	private int productID;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	public ProductVendorPK() {
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductVendorPK)) {
			return false;
		}
		ProductVendorPK castOther = (ProductVendorPK)other;
		return 
			(this.productID == castOther.productID)
			&& (this.businessEntityID == castOther.businessEntityID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productID;
		hash = hash * prime + this.businessEntityID;
		
		return hash;
	}
}