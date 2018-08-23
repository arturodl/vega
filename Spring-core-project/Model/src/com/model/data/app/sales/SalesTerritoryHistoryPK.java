package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SalesTerritoryHistory database table.
 * 
 */
@Embeddable
public class SalesTerritoryHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="StartDate")
	private java.util.Date startDate;

	@Column(name="TerritoryID", insertable=false, updatable=false)
	private int territoryID;

	public SalesTerritoryHistoryPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public int getTerritoryID() {
		return this.territoryID;
	}
	public void setTerritoryID(int territoryID) {
		this.territoryID = territoryID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalesTerritoryHistoryPK)) {
			return false;
		}
		SalesTerritoryHistoryPK castOther = (SalesTerritoryHistoryPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& this.startDate.equals(castOther.startDate)
			&& (this.territoryID == castOther.territoryID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.startDate.hashCode();
		hash = hash * prime + this.territoryID;
		
		return hash;
	}
}