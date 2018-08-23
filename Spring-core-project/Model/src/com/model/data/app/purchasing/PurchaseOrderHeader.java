package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PurchaseOrderHeader database table.
 * 
 */
@Entity(name="PurchaseOrderHeader")
@Table(name="PurchaseOrderHeader", schema="Purchasing")
@Access(AccessType.FIELD)
public class PurchaseOrderHeader extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PurchaseOrderID")
	@Basic(optional=false)
	private int purchaseOrderID;
	
	@Column(name="PurchaseOrderID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="EmployeeID")
	private int employeeID;

	@Column(name="Freight")
	private BigDecimal freight;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="OrderDate")
	private Timestamp orderDate;

	@Column(name="RevisionNumber")
	private short revisionNumber;

	@Column(name="ShipDate")
	private Timestamp shipDate;

	@Column(name="Status")
	private short status;

	@Column(name="SubTotal")
	private BigDecimal subTotal;

	@Column(name="TaxAmt")
	private BigDecimal taxAmt;

	@Column(name="TotalDue")
	private BigDecimal totalDue;

	@Column(name="VendorID")
	private int vendorID;

	//bi-directional many-to-one association to PurchaseOrderDetail
	@OneToMany(mappedBy="purchaseOrderHeader", fetch=FetchType.LAZY)
	private List<PurchaseOrderDetail> purchaseOrderDetails;

	//bi-directional many-to-one association to ShipMethod
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ShipMethodID")
	private ShipMethod shipMethod;

	public PurchaseOrderHeader() {
	}

	public int getPurchaseOrderID() {
		return this.purchaseOrderID;
	}

	public void setPurchaseOrderID(int purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public BigDecimal getFreight() {
		return this.freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public short getRevisionNumber() {
		return this.revisionNumber;
	}

	public void setRevisionNumber(short revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public Timestamp getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Timestamp shipDate) {
		this.shipDate = shipDate;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTaxAmt() {
		return this.taxAmt;
	}

	public void setTaxAmt(BigDecimal taxAmt) {
		this.taxAmt = taxAmt;
	}

	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	public int getVendorID() {
		return this.vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public PurchaseOrderDetail addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().add(purchaseOrderDetail);
		purchaseOrderDetail.setPurchaseOrderHeader(this);

		return purchaseOrderDetail;
	}

	public PurchaseOrderDetail removePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().remove(purchaseOrderDetail);
		purchaseOrderDetail.setPurchaseOrderHeader(null);

		return purchaseOrderDetail;
	}

	public ShipMethod getShipMethod() {
		return this.shipMethod;
	}

	public void setShipMethod(ShipMethod shipMethod) {
		this.shipMethod = shipMethod;
	}

}