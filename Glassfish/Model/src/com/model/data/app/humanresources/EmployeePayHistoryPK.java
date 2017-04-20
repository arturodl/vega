package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EmployeePayHistory database table.
 * 
 */
@Embeddable
public class EmployeePayHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RateChangeDate")
	private java.util.Date rateChangeDate;

	public EmployeePayHistoryPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public java.util.Date getRateChangeDate() {
		return this.rateChangeDate;
	}
	public void setRateChangeDate(java.util.Date rateChangeDate) {
		this.rateChangeDate = rateChangeDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeePayHistoryPK)) {
			return false;
		}
		EmployeePayHistoryPK castOther = (EmployeePayHistoryPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& this.rateChangeDate.equals(castOther.rateChangeDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.rateChangeDate.hashCode();
		
		return hash;
	}
}