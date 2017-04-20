package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Shift database table.
 * 
 */
@Entity
@NamedQuery(name="Shift.findAll", query="SELECT s FROM Shift s")
public class Shift extends com.core.app.modelo.Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ShiftID")
	private short shiftID;

	@Column(name="EndTime")
	private String endTime;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private Object name;

	@Column(name="StartTime")
	private String startTime;

	//bi-directional many-to-one association to EmployeeDepartmentHistory
	@OneToMany(mappedBy="shift")
	private List<EmployeeDepartmentHistory> employeeDepartmentHistories;

	public Shift() {
	}

	public short getShiftID() {
		return this.shiftID;
	}

	public void setShiftID(short shiftID) {
		this.shiftID = shiftID;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<EmployeeDepartmentHistory> getEmployeeDepartmentHistories() {
		return this.employeeDepartmentHistories;
	}

	public void setEmployeeDepartmentHistories(List<EmployeeDepartmentHistory> employeeDepartmentHistories) {
		this.employeeDepartmentHistories = employeeDepartmentHistories;
	}

	public EmployeeDepartmentHistory addEmployeeDepartmentHistory(EmployeeDepartmentHistory employeeDepartmentHistory) {
		getEmployeeDepartmentHistories().add(employeeDepartmentHistory);
		employeeDepartmentHistory.setShift(this);

		return employeeDepartmentHistory;
	}

	public EmployeeDepartmentHistory removeEmployeeDepartmentHistory(EmployeeDepartmentHistory employeeDepartmentHistory) {
		getEmployeeDepartmentHistories().remove(employeeDepartmentHistory);
		employeeDepartmentHistory.setShift(null);

		return employeeDepartmentHistory;
	}

}