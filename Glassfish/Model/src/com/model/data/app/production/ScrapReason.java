package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ScrapReason database table.
 * 
 */
@Entity(name="ScrapReason")
@Table(name="ScrapReason", schema="Production")
@Access(AccessType.FIELD)
public class ScrapReason extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ScrapReasonID")
	@Basic(optional=false)
	private short scrapReasonID;
	
	@Column(name="ScrapReasonID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to WorkOrder
	@OneToMany(mappedBy="scrapReason", fetch=FetchType.LAZY)
	private List<WorkOrder> workOrders;

	public ScrapReason() {
	}

	public short getScrapReasonID() {
		return this.scrapReasonID;
	}

	public void setScrapReasonID(short scrapReasonID) {
		this.scrapReasonID = scrapReasonID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<WorkOrder> getWorkOrders() {
		return this.workOrders;
	}

	public void setWorkOrders(List<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}

	public WorkOrder addWorkOrder(WorkOrder workOrder) {
		getWorkOrders().add(workOrder);
		workOrder.setScrapReason(this);

		return workOrder;
	}

	public WorkOrder removeWorkOrder(WorkOrder workOrder) {
		getWorkOrders().remove(workOrder);
		workOrder.setScrapReason(null);

		return workOrder;
	}

}