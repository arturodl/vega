package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SalesReason database table.
 * 
 */
@Entity(name="SalesReason")
@Table(name="SalesReason") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesReason extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SalesReasonID")
	@Basic(optional=false)
	private int salesReasonID;
	
	@Column(name="SalesReasonID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	@Column(name="ReasonType")
	private String reasonType;

	//bi-directional many-to-one association to SalesOrderHeaderSalesReason
	@OneToMany(mappedBy="salesReason", fetch=FetchType.LAZY)
	private List<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasons;

	public SalesReason() {
	}

	public int getSalesReasonID() {
		return this.salesReasonID;
	}

	public void setSalesReasonID(int salesReasonID) {
		this.salesReasonID = salesReasonID;
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

	public String getReasonType() {
		return this.reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public List<SalesOrderHeaderSalesReason> getSalesOrderHeaderSalesReasons() {
		return this.salesOrderHeaderSalesReasons;
	}

	public void setSalesOrderHeaderSalesReasons(List<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasons) {
		this.salesOrderHeaderSalesReasons = salesOrderHeaderSalesReasons;
	}

	public SalesOrderHeaderSalesReason addSalesOrderHeaderSalesReason(SalesOrderHeaderSalesReason salesOrderHeaderSalesReason) {
		getSalesOrderHeaderSalesReasons().add(salesOrderHeaderSalesReason);
		salesOrderHeaderSalesReason.setSalesReason(this);

		return salesOrderHeaderSalesReason;
	}

	public SalesOrderHeaderSalesReason removeSalesOrderHeaderSalesReason(SalesOrderHeaderSalesReason salesOrderHeaderSalesReason) {
		getSalesOrderHeaderSalesReasons().remove(salesOrderHeaderSalesReason);
		salesOrderHeaderSalesReason.setSalesReason(null);

		return salesOrderHeaderSalesReason;
	}

}