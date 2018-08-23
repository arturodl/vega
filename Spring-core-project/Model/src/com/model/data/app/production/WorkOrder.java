package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the WorkOrder database table.
 * 
 */
@Entity(name="WorkOrder")
@Table(name="WorkOrder") //, schema="Production")
@Access(AccessType.FIELD)
public class WorkOrder extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WorkOrderID")
	@Basic(optional=false)
	private int workOrderID;

	@Column(name="WorkOrderID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;
	
	@Column(name="DueDate")
	private Timestamp dueDate;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="OrderQty")
	private int orderQty;

	@Column(name="ScrappedQty")
	private short scrappedQty;

	@Column(name="StartDate")
	private Timestamp startDate;

	@Column(name="StockedQty")
	private int stockedQty;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID")
	private Product product;

	//bi-directional many-to-one association to ScrapReason
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ScrapReasonID")
	private ScrapReason scrapReason;

	//bi-directional many-to-one association to WorkOrderRouting
	@OneToMany(mappedBy="workOrder", fetch=FetchType.LAZY)
	private List<WorkOrderRouting> workOrderRoutings;

	public WorkOrder() {
	}

	public int getWorkOrderID() {
		return this.workOrderID;
	}

	public void setWorkOrderID(int workOrderID) {
		this.workOrderID = workOrderID;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public short getScrappedQty() {
		return this.scrappedQty;
	}

	public void setScrappedQty(short scrappedQty) {
		this.scrappedQty = scrappedQty;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public int getStockedQty() {
		return this.stockedQty;
	}

	public void setStockedQty(int stockedQty) {
		this.stockedQty = stockedQty;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ScrapReason getScrapReason() {
		return this.scrapReason;
	}

	public void setScrapReason(ScrapReason scrapReason) {
		this.scrapReason = scrapReason;
	}

	public List<WorkOrderRouting> getWorkOrderRoutings() {
		return this.workOrderRoutings;
	}

	public void setWorkOrderRoutings(List<WorkOrderRouting> workOrderRoutings) {
		this.workOrderRoutings = workOrderRoutings;
	}

	public WorkOrderRouting addWorkOrderRouting(WorkOrderRouting workOrderRouting) {
		getWorkOrderRoutings().add(workOrderRouting);
		workOrderRouting.setWorkOrder(this);

		return workOrderRouting;
	}

	public WorkOrderRouting removeWorkOrderRouting(WorkOrderRouting workOrderRouting) {
		getWorkOrderRoutings().remove(workOrderRouting);
		workOrderRouting.setWorkOrder(null);

		return workOrderRouting;
	}

}