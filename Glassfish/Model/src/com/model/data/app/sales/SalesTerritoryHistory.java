package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the SalesTerritoryHistory database table.
 * 
 */
@Entity(name="SalesTerritoryHistory")
@Table(name="SalesTerritoryHistory", schema="Sales")
@Access(AccessType.FIELD)
public class SalesTerritoryHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalesTerritoryHistoryPK id;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to SalesPerson
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private SalesPerson salesPerson;

	//bi-directional many-to-one association to SalesTerritory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TerritoryID", insertable=false, updatable=false)
	private SalesTerritory salesTerritory;

	public SalesTerritoryHistory() {
	}

	public SalesTerritoryHistoryPK getId() {
		return this.id;
	}

	public void setId(SalesTerritoryHistoryPK id) {
		this.id = id;
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

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public SalesPerson getSalesPerson() {
		return this.salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}

	public SalesTerritory getSalesTerritory() {
		return this.salesTerritory;
	}

	public void setSalesTerritory(SalesTerritory salesTerritory) {
		this.salesTerritory = salesTerritory;
	}

}