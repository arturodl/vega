package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SalesOrderHeaderSalesReason database table.
 * 
 */
@Embeddable
public class SalesOrderHeaderSalesReasonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SalesOrderID", insertable=false, updatable=false)
	private int salesOrderID;

	@Column(name="SalesReasonID", insertable=false, updatable=false)
	private int salesReasonID;

	public SalesOrderHeaderSalesReasonPK() {
	}
	public int getSalesOrderID() {
		return this.salesOrderID;
	}
	public void setSalesOrderID(int salesOrderID) {
		this.salesOrderID = salesOrderID;
	}
	public int getSalesReasonID() {
		return this.salesReasonID;
	}
	public void setSalesReasonID(int salesReasonID) {
		this.salesReasonID = salesReasonID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalesOrderHeaderSalesReasonPK)) {
			return false;
		}
		SalesOrderHeaderSalesReasonPK castOther = (SalesOrderHeaderSalesReasonPK)other;
		return 
			(this.salesOrderID == castOther.salesOrderID)
			&& (this.salesReasonID == castOther.salesReasonID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.salesOrderID;
		hash = hash * prime + this.salesReasonID;
		
		return hash;
	}
}