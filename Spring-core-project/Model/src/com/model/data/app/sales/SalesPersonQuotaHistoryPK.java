package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SalesPersonQuotaHistory database table.
 * 
 */
@Embeddable
public class SalesPersonQuotaHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID", insertable=false, updatable=false)
	private int businessEntityID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="QuotaDate")
	private java.util.Date quotaDate;

	public SalesPersonQuotaHistoryPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public java.util.Date getQuotaDate() {
		return this.quotaDate;
	}
	public void setQuotaDate(java.util.Date quotaDate) {
		this.quotaDate = quotaDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalesPersonQuotaHistoryPK)) {
			return false;
		}
		SalesPersonQuotaHistoryPK castOther = (SalesPersonQuotaHistoryPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& this.quotaDate.equals(castOther.quotaDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.quotaDate.hashCode();
		
		return hash;
	}
}