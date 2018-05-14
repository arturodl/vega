package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the WorkOrderRouting database table.
 * 
 */
@Entity(name="WorkOrderRouting")
@Table(name="WorkOrderRouting") //, schema="Production")
@Access(AccessType.FIELD)
public class WorkOrderRouting extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkOrderRoutingPK id;

	@Column(name="ActualCost")
	private BigDecimal actualCost;

	@Column(name="ActualEndDate")
	private Timestamp actualEndDate;

	@Column(name="ActualResourceHrs")
	private BigDecimal actualResourceHrs;

	@Column(name="ActualStartDate")
	private Timestamp actualStartDate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="PlannedCost")
	private BigDecimal plannedCost;

	@Column(name="ScheduledEndDate")
	private Timestamp scheduledEndDate;

	@Column(name="ScheduledStartDate")
	private Timestamp scheduledStartDate;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LocationID")
	private Location location;

	//bi-directional many-to-one association to WorkOrder
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WorkOrderID", insertable=false, updatable=false)
	private WorkOrder workOrder;

	public WorkOrderRouting() {
	}

	public WorkOrderRoutingPK getId() {
		return this.id;
	}

	public void setId(WorkOrderRoutingPK id) {
		this.id = id;
	}

	public BigDecimal getActualCost() {
		return this.actualCost;
	}

	public void setActualCost(BigDecimal actualCost) {
		this.actualCost = actualCost;
	}

	public Timestamp getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(Timestamp actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public BigDecimal getActualResourceHrs() {
		return this.actualResourceHrs;
	}

	public void setActualResourceHrs(BigDecimal actualResourceHrs) {
		this.actualResourceHrs = actualResourceHrs;
	}

	public Timestamp getActualStartDate() {
		return this.actualStartDate;
	}

	public void setActualStartDate(Timestamp actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigDecimal getPlannedCost() {
		return this.plannedCost;
	}

	public void setPlannedCost(BigDecimal plannedCost) {
		this.plannedCost = plannedCost;
	}

	public Timestamp getScheduledEndDate() {
		return this.scheduledEndDate;
	}

	public void setScheduledEndDate(Timestamp scheduledEndDate) {
		this.scheduledEndDate = scheduledEndDate;
	}

	public Timestamp getScheduledStartDate() {
		return this.scheduledStartDate;
	}

	public void setScheduledStartDate(Timestamp scheduledStartDate) {
		this.scheduledStartDate = scheduledStartDate;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public WorkOrder getWorkOrder() {
		return this.workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

}