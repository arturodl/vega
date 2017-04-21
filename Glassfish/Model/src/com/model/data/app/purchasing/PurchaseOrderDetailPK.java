package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PurchaseOrderDetail database table.
 * 
 */
@Embeddable
public class PurchaseOrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PurchaseOrderID", insertable=false, updatable=false)
	private int purchaseOrderID;

	@Column(name="PurchaseOrderDetailID")
	private int purchaseOrderDetailID;

	public PurchaseOrderDetailPK() {
	}
	public int getPurchaseOrderID() {
		return this.purchaseOrderID;
	}
	public void setPurchaseOrderID(int purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}
	public int getPurchaseOrderDetailID() {
		return this.purchaseOrderDetailID;
	}
	public void setPurchaseOrderDetailID(int purchaseOrderDetailID) {
		this.purchaseOrderDetailID = purchaseOrderDetailID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PurchaseOrderDetailPK)) {
			return false;
		}
		PurchaseOrderDetailPK castOther = (PurchaseOrderDetailPK)other;
		return 
			(this.purchaseOrderID == castOther.purchaseOrderID)
			&& (this.purchaseOrderDetailID == castOther.purchaseOrderDetailID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.purchaseOrderID;
		hash = hash * prime + this.purchaseOrderDetailID;
		
		return hash;
	}
}