package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductProductPhoto database table.
 * 
 */
@Embeddable
public class ProductProductPhotoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductID", insertable=false, updatable=false)
	private int productID;

	@Column(name="ProductPhotoID", insertable=false, updatable=false)
	private int productPhotoID;

	public ProductProductPhotoPK() {
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductPhotoID() {
		return this.productPhotoID;
	}
	public void setProductPhotoID(int productPhotoID) {
		this.productPhotoID = productPhotoID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductProductPhotoPK)) {
			return false;
		}
		ProductProductPhotoPK castOther = (ProductProductPhotoPK)other;
		return 
			(this.productID == castOther.productID)
			&& (this.productPhotoID == castOther.productPhotoID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productID;
		hash = hash * prime + this.productPhotoID;
		
		return hash;
	}
}