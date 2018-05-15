package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the ProductVendor database table.
 * 
 */
@Entity(name="ProductVendor")
@Table(name="ProductVendor") //, schema="Purchasing")
@Access(AccessType.FIELD)
public class ProductVendor extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductVendorPK id;

	@Column(name="AverageLeadTime")
	private int averageLeadTime;

	@Column(name="LastReceiptCost")
	private BigDecimal lastReceiptCost;

	@Column(name="LastReceiptDate")
	private Timestamp lastReceiptDate;

	@Column(name="MaxOrderQty")
	private int maxOrderQty;

	@Column(name="MinOrderQty")
	private int minOrderQty;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="OnOrderQty")
	private int onOrderQty;

	@Column(name="StandardPrice")
	private BigDecimal standardPrice;

	@Column(name="UnitMeasureCode")
	private String unitMeasureCode;

	//bi-directional many-to-one association to Vendor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", referencedColumnName="BusinessEntityID", insertable=false, updatable=false)
	private Vendor vendor;

	public ProductVendor() {
	}

	public ProductVendorPK getId() {
		return this.id;
	}

	public void setId(ProductVendorPK id) {
		this.id = id;
	}

	public int getAverageLeadTime() {
		return this.averageLeadTime;
	}

	public void setAverageLeadTime(int averageLeadTime) {
		this.averageLeadTime = averageLeadTime;
	}

	public BigDecimal getLastReceiptCost() {
		return this.lastReceiptCost;
	}

	public void setLastReceiptCost(BigDecimal lastReceiptCost) {
		this.lastReceiptCost = lastReceiptCost;
	}

	public Timestamp getLastReceiptDate() {
		return this.lastReceiptDate;
	}

	public void setLastReceiptDate(Timestamp lastReceiptDate) {
		this.lastReceiptDate = lastReceiptDate;
	}

	public int getMaxOrderQty() {
		return this.maxOrderQty;
	}

	public void setMaxOrderQty(int maxOrderQty) {
		this.maxOrderQty = maxOrderQty;
	}

	public int getMinOrderQty() {
		return this.minOrderQty;
	}

	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getOnOrderQty() {
		return this.onOrderQty;
	}

	public void setOnOrderQty(int onOrderQty) {
		this.onOrderQty = onOrderQty;
	}

	public BigDecimal getStandardPrice() {
		return this.standardPrice;
	}

	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	public String getUnitMeasureCode() {
		return this.unitMeasureCode;
	}

	public void setUnitMeasureCode(String unitMeasureCode) {
		this.unitMeasureCode = unitMeasureCode;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}