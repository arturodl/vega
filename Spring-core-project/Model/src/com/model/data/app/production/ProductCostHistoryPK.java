package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductCostHistory database table.
 * 
 */
@Embeddable
public class ProductCostHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductID", insertable=false, updatable=false)
	private int productID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="StartDate")
	private java.util.Date startDate;

	public ProductCostHistoryPK() {
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductCostHistoryPK)) {
			return false;
		}
		ProductCostHistoryPK castOther = (ProductCostHistoryPK)other;
		return 
			(this.productID == castOther.productID)
			&& this.startDate.equals(castOther.startDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productID;
		hash = hash * prime + this.startDate.hashCode();
		
		return hash;
	}
}