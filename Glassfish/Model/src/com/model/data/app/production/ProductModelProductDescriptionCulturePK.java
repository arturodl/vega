package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductModelProductDescriptionCulture database table.
 * 
 */
@Embeddable
public class ProductModelProductDescriptionCulturePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductModelID", insertable=false, updatable=false)
	private int productModelID;

	@Column(name="ProductDescriptionID", insertable=false, updatable=false)
	private int productDescriptionID;

	@Column(name="CultureID", insertable=false, updatable=false)
	private String cultureID;

	public ProductModelProductDescriptionCulturePK() {
	}
	public int getProductModelID() {
		return this.productModelID;
	}
	public void setProductModelID(int productModelID) {
		this.productModelID = productModelID;
	}
	public int getProductDescriptionID() {
		return this.productDescriptionID;
	}
	public void setProductDescriptionID(int productDescriptionID) {
		this.productDescriptionID = productDescriptionID;
	}
	public String getCultureID() {
		return this.cultureID;
	}
	public void setCultureID(String cultureID) {
		this.cultureID = cultureID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductModelProductDescriptionCulturePK)) {
			return false;
		}
		ProductModelProductDescriptionCulturePK castOther = (ProductModelProductDescriptionCulturePK)other;
		return 
			(this.productModelID == castOther.productModelID)
			&& (this.productDescriptionID == castOther.productDescriptionID)
			&& this.cultureID.equals(castOther.cultureID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productModelID;
		hash = hash * prime + this.productDescriptionID;
		hash = hash * prime + this.cultureID.hashCode();
		
		return hash;
	}
}