package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EmployeeDepartmentHistory database table.
 * 
 */
@Embeddable
public class EmployeeDepartmentHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BusinessEntityID")
	private int businessEntityID;

	@Column(name="StartDate")
	private String startDate;

	@Column(name="DepartmentID", insertable=false, updatable=false)
	private short departmentID;

	@Column(name="ShiftID")
	private short shiftID;

	public EmployeeDepartmentHistoryPK() {
	}
	public int getBusinessEntityID() {
		return this.businessEntityID;
	}
	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}
	public String getStartDate() {
		return this.startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public short getDepartmentID() {
		return this.departmentID;
	}
	public void setDepartmentID(short departmentID) {
		this.departmentID = departmentID;
	}
	public short getShiftID() {
		return this.shiftID;
	}
	public void setShiftID(short shiftID) {
		this.shiftID = shiftID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeeDepartmentHistoryPK)) {
			return false;
		}
		EmployeeDepartmentHistoryPK castOther = (EmployeeDepartmentHistoryPK)other;
		return 
			(this.businessEntityID == castOther.businessEntityID)
			&& this.startDate.equals(castOther.startDate)
			&& (this.departmentID == castOther.departmentID)
			&& (this.shiftID == castOther.shiftID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.businessEntityID;
		hash = hash * prime + this.startDate.hashCode();
		hash = hash * prime + ((int) this.departmentID);
		hash = hash * prime + ((int) this.shiftID);
		
		return hash;
	}
}