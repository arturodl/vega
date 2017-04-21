package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the SalesPersonQuotaHistory database table.
 * 
 */
@Entity(name="SalesPersonQuotaHistory")
@Table(name="SalesPersonQuotaHistory", schema="Sales")
@Access(AccessType.FIELD)
public class SalesPersonQuotaHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesPersonQuotaHistoryPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	@Column(name="SalesQuota")
	private BigDecimal salesQuota;

	//bi-directional many-to-one association to SalesPerson
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private SalesPerson salesPerson;

	public SalesPersonQuotaHistory() {
	}

	public SalesPersonQuotaHistoryPK getId() {
		return this.id;
	}

	public void setId(SalesPersonQuotaHistoryPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public BigDecimal getSalesQuota() {
		return this.salesQuota;
	}

	public void setSalesQuota(BigDecimal salesQuota) {
		this.salesQuota = salesQuota;
	}

	public SalesPerson getSalesPerson() {
		return this.salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}

}