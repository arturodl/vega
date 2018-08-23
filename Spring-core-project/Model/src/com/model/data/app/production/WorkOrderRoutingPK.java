package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the WorkOrderRouting database table.
 * 
 */
@Embeddable
public class WorkOrderRoutingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="WorkOrderID", insertable=false, updatable=false)
	private int workOrderID;

	@Column(name="ProductID")
	private int productID;

	@Column(name="OperationSequence")
	private short operationSequence;

	public WorkOrderRoutingPK() {
	}
	public int getWorkOrderID() {
		return this.workOrderID;
	}
	public void setWorkOrderID(int workOrderID) {
		this.workOrderID = workOrderID;
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public short getOperationSequence() {
		return this.operationSequence;
	}
	public void setOperationSequence(short operationSequence) {
		this.operationSequence = operationSequence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkOrderRoutingPK)) {
			return false;
		}
		WorkOrderRoutingPK castOther = (WorkOrderRoutingPK)other;
		return 
			(this.workOrderID == castOther.workOrderID)
			&& (this.productID == castOther.productID)
			&& (this.operationSequence == castOther.operationSequence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.workOrderID;
		hash = hash * prime + this.productID;
		hash = hash * prime + ((int) this.operationSequence);
		
		return hash;
	}
}