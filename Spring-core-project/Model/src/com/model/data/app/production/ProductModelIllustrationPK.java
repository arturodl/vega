package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductModelIllustration database table.
 * 
 */
@Embeddable
public class ProductModelIllustrationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductModelID", insertable=false, updatable=false)
	private int productModelID;

	@Column(name="IllustrationID", insertable=false, updatable=false)
	private int illustrationID;

	public ProductModelIllustrationPK() {
	}
	public int getProductModelID() {
		return this.productModelID;
	}
	public void setProductModelID(int productModelID) {
		this.productModelID = productModelID;
	}
	public int getIllustrationID() {
		return this.illustrationID;
	}
	public void setIllustrationID(int illustrationID) {
		this.illustrationID = illustrationID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductModelIllustrationPK)) {
			return false;
		}
		ProductModelIllustrationPK castOther = (ProductModelIllustrationPK)other;
		return 
			(this.productModelID == castOther.productModelID)
			&& (this.illustrationID == castOther.illustrationID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productModelID;
		hash = hash * prime + this.illustrationID;
		
		return hash;
	}
}