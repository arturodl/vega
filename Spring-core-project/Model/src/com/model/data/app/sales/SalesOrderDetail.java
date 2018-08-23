package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the SalesOrderDetail database table.
 * 
 */
@Entity(name="SalesOrderDetail")
@Table(name="SalesOrderDetail") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesOrderDetail extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesOrderDetailPK id;

	@Column(name="CarrierTrackingNumber")
	private String carrierTrackingNumber;

	@Column(name="LineTotal")
	private BigDecimal lineTotal;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="OrderQty")
	private short orderQty;

	@Column(name="ProductID")
	private int productID;

	private String rowguid;

	@Column(name="SpecialOfferID")
	private int specialOfferID;

	@Column(name="UnitPrice")
	private BigDecimal unitPrice;

	@Column(name="UnitPriceDiscount")
	private BigDecimal unitPriceDiscount;

	//bi-directional many-to-one association to SalesOrderHeader
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SalesOrderID", insertable=false, updatable=false)
	private SalesOrderHeader salesOrderHeader;

	public SalesOrderDetail() {
	}

	public SalesOrderDetailPK getId() {
		return this.id;
	}

	public void setId(SalesOrderDetailPK id) {
		this.id = id;
	}

	public String getCarrierTrackingNumber() {
		return this.carrierTrackingNumber;
	}

	public void setCarrierTrackingNumber(String carrierTrackingNumber) {
		this.carrierTrackingNumber = carrierTrackingNumber;
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

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public int getSpecialOfferID() {
		return this.specialOfferID;
	}

	public void setSpecialOfferID(int specialOfferID) {
		this.specialOfferID = specialOfferID;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPriceDiscount() {
		return this.unitPriceDiscount;
	}

	public void setUnitPriceDiscount(BigDecimal unitPriceDiscount) {
		this.unitPriceDiscount = unitPriceDiscount;
	}

	public SalesOrderHeader getSalesOrderHeader() {
		return this.salesOrderHeader;
	}

	public void setSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
		this.salesOrderHeader = salesOrderHeader;
	}

}