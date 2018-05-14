package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the SalesOrderHeaderSalesReason database table.
 * 
 */
@Entity(name="SalesOrderHeaderSalesReason")
@Table(name="SalesOrderHeaderSalesReason") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesOrderHeaderSalesReason extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesOrderHeaderSalesReasonPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to SalesOrderHeader
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SalesOrderID", insertable=false, updatable=false)
	private SalesOrderHeader salesOrderHeader;

	//bi-directional many-to-one association to SalesReason
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SalesReasonID", insertable=false, updatable=false)
	private SalesReason salesReason;

	public SalesOrderHeaderSalesReason() {
	}

	public SalesOrderHeaderSalesReasonPK getId() {
		return this.id;
	}

	public void setId(SalesOrderHeaderSalesReasonPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public SalesOrderHeader getSalesOrderHeader() {
		return this.salesOrderHeader;
	}

	public void setSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
		this.salesOrderHeader = salesOrderHeader;
	}

	public SalesReason getSalesReason() {
		return this.salesReason;
	}

	public void setSalesReason(SalesReason salesReason) {
		this.salesReason = salesReason;
	}

}