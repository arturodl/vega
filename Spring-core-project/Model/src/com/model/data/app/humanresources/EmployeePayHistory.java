package com.model.data.app.humanresources;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the EmployeePayHistory database table.
 * 
 */
@Entity(name="EmployeePayHistory")
@Table(name="EmployeePayHistory") // , schema="HumanResources")
@Access(AccessType.FIELD)
public class EmployeePayHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeePayHistoryPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="PayFrequency")
	private short payFrequency;

	@Column(name="Rate")
	private BigDecimal rate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private Employee employee;

	public EmployeePayHistory() {
	}

	public EmployeePayHistoryPK getId() {
		return this.id;
	}

	public void setId(EmployeePayHistoryPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public short getPayFrequency() {
		return this.payFrequency;
	}

	public void setPayFrequency(short payFrequency) {
		this.payFrequency = payFrequency;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}