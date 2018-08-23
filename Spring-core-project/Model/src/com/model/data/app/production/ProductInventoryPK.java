package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductInventory database table.
 * 
 */
@Embeddable
public class ProductInventoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductID", insertable=false, updatable=false)
	private int productID;

	@Column(name="LocationID", insertable=false, updatable=false)
	private short locationID;

	public ProductInventoryPK() {
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public short getLocationID() {
		return this.locationID;
	}
	public void setLocationID(short locationID) {
		this.locationID = locationID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductInventoryPK)) {
			return false;
		}
		ProductInventoryPK castOther = (ProductInventoryPK)other;
		return 
			(this.productID == castOther.productID)
			&& (this.locationID == castOther.locationID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productID;
		hash = hash * prime + ((int) this.locationID);
		
		return hash;
	}
}