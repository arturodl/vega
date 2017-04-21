package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Shift database table.
 * 
 */
@Entity(name="Shift")
@Table(name="Shift", schema="HumanResources")
@Access(AccessType.FIELD)
public class Shift extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ShiftID")
	private short shiftID;
	
	@Column(name="ShiftID", updatable = false, insertable = false)
	@Basic(optional = false)
	private short id;

	@Column(name="EndTime")
	private String endTime;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	@Column(name="StartTime")
	private String startTime;

	//bi-directional many-to-one association to EmployeeDepartmentHistory
	@OneToMany(mappedBy="shift", fetch=FetchType.LAZY)
	private List<EmployeeDepartmentHistory> employeeDepartmentHistories;

	public Shift() {
	}

	public short getShiftID() {
		return this.shiftID;
	}

	public void setShiftID(short shiftID) {
		this.shiftID = shiftID;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
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