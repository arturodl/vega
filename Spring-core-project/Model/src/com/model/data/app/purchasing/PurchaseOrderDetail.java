package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the PurchaseOrderDetail database table.
 * 
 */
@Entity(name="PurchaseOrderDetail")
@Table(name="PurchaseOrderDetail", schema="Purchasing")
@Access(AccessType.FIELD)
public class PurchaseOrderDetail extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PurchaseOrderDetailPK id;

	@Column(name="DueDate")
	private Timestamp dueDate;

	@Column(name="LineTotal")
	private BigDecimal lineTotal;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="OrderQty")
	private short orderQty;

	@Column(name="ProductID")
	private int productID;

	@Column(name="ReceivedQty")
	private BigDecimal receivedQty;

	@Column(name="RejectedQty")
	private BigDecimal rejectedQty;

	@Column(name="StockedQty")
	private BigDecimal stockedQty;

	@Column(name="UnitPrice")
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to PurchaseOrderHeader
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PurchaseOrderID", insertable=false, updatable=false)
	private PurchaseOrderHeader purchaseOrderHeader;

	public PurchaseOrderDetail() {
	}

	public PurchaseOrderDetailPK getId() {
		return this.id;
	}

	public void setId(PurchaseOrderDetailPK id) {
		this.id = id;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getLineTotal() {
		return this.lineTotal;
	}

	public void setLineTotal(BigDecimal lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public short getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(short orderQty) {
		this.orderQty = orderQty;
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public BigDecimal getReceivedQty() {
		return this.receivedQty;
	}

	public void setReceivedQty(BigDecimal receivedQty) {
		this.receivedQty = receivedQty;
	}

	public BigDecimal getRejectedQty() {
		return this.rejectedQty;
	}

	public void setRejectedQty(BigDecimal rejectedQty) {
		this.rejectedQty = rejectedQty;
	}

	public BigDecimal getStockedQty() {
		return this.stockedQty;
	}

	public void setStockedQty(BigDecimal stockedQty) {
		this.stockedQty = stockedQty;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public PurchaseOrderHeader getPurchaseOrderHeader() {
		return this.purchaseOrderHeader;
	}

	public void setPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		this.purchaseOrderHeader = purchaseOrderHeader;
	}

}