package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the EmployeeDepartmentHistory database table.
 * 
 */
@Entity(name="EmployeeDepartmentHistory")
@Table(name="EmployeeDepartmentHistory", schema="HumanResources")
@Access(AccessType.FIELD)
public class EmployeeDepartmentHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeDepartmentHistoryPK id;

	@Column(name="EndDate")
	private String endDate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private Employee employee;

	//bi-directional many-to-one association to Shift
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ShiftID", insertable=false, updatable=false)
	private Shift shift;

	public EmployeeDepartmentHistory() {
	}

	public EmployeeDepartmentHistoryPK getId() {
		return this.id;
	}

	public void setId(EmployeeDepartmentHistoryPK id) {
		this.id = id;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Shift getShift() {
		return this.shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

}