package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SalesOrderDetail database table.
 * 
 */
@Embeddable
public class SalesOrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SalesOrderID", insertable=false, updatable=false)
	private int salesOrderID;

	@Column(name="SalesOrderDetailID")
	private int salesOrderDetailID;

	public SalesOrderDetailPK() {
	}
	public int getSalesOrderID() {
		return this.salesOrderID;
	}
	public void setSalesOrderID(int salesOrderID) {
		this.salesOrderID = salesOrderID;
	}
	public int getSalesOrderDetailID() {
		return this.salesOrderDetailID;
	}
	public void setSalesOrderDetailID(int salesOrderDetailID) {
		this.salesOrderDetailID = salesOrderDetailID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalesOrderDetailPK)) {
			return false;
		}
		SalesOrderDetailPK castOther = (SalesOrderDetailPK)other;
		return 
			(this.salesOrderID == castOther.salesOrderID)
			&& (this.salesOrderDetailID == castOther.salesOrderDetailID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.salesOrderID;
		hash = hash * prime + this.salesOrderDetailID;
		
		return hash;
	}
}