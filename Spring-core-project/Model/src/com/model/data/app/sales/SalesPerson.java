package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SalesPerson database table.
 * 
 */
@Entity(name="SalesPerson")
@Table(name="SalesPerson") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesPerson extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID")
	private int businessEntityID;

	@Column(name="Bonus")
	private BigDecimal bonus;

	@Column(name="CommissionPct")
	private BigDecimal commissionPct;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	@Column(name="SalesLastYear")
	private BigDecimal salesLastYear;

	@Column(name="SalesQuota")
	private BigDecimal salesQuota;

	@Column(name="SalesYTD")
	private BigDecimal salesYTD;

	//bi-directional many-to-one association to SalesTerritory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TerritoryID")
	private SalesTerritory salesTerritory;

	//bi-directional many-to-one association to SalesPersonQuotaHistory
	@OneToMany(mappedBy="salesPerson", fetch=FetchType.LAZY)
	private List<SalesPersonQuotaHistory> salesPersonQuotaHistories;

	//bi-directional many-to-one association to SalesTerritoryHistory
	@OneToMany(mappedBy="salesPerson", fetch=FetchType.LAZY)
	private List<SalesTerritoryHistory> salesTerritoryHistories;

	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="salesPerson", fetch=FetchType.LAZY)
	private List<Store> stores;

	public SalesPerson() {
	}

	public int getBusinessEntityID() {
		return this.businessEntityID;
	}

	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}

	public BigDecimal getBonus() {
		return this.bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
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

	public BigDecimal getSalesLastYear() {
		return this.salesLastYear;
	}

	public void setSalesLastYear(BigDecimal salesLastYear) {
		this.salesLastYear = salesLastYear;
	}

	public BigDecimal getSalesQuota() {
		return this.salesQuota;
	}

	public void setSalesQuota(BigDecimal salesQuota) {
		this.salesQuota = salesQuota;
	}

	public BigDecimal getSalesYTD() {
		return this.salesYTD;
	}

	public void setSalesYTD(BigDecimal salesYTD) {
		this.salesYTD = salesYTD;
	}

	public SalesTerritory getSalesTerritory() {
		return this.salesTerritory;
	}

	public void setSalesTerritory(SalesTerritory salesTerritory) {
		this.salesTerritory = salesTerritory;
	}

	public List<SalesPersonQuotaHistory> getSalesPersonQuotaHistories() {
		return this.salesPersonQuotaHistories;
	}

	public void setSalesPersonQuotaHistories(List<SalesPersonQuotaHistory> salesPersonQuotaHistories) {
		this.salesPersonQuotaHistories = salesPersonQuotaHistories;
	}

	public SalesPersonQuotaHistory addSalesPersonQuotaHistory(SalesPersonQuotaHistory salesPersonQuotaHistory) {
		getSalesPersonQuotaHistories().add(salesPersonQuotaHistory);
		salesPersonQuotaHistory.setSalesPerson(this);

		return salesPersonQuotaHistory;
	}

	public SalesPersonQuotaHistory removeSalesPersonQuotaHistory(SalesPersonQuotaHistory salesPersonQuotaHistory) {
		getSalesPersonQuotaHistories().remove(salesPersonQuotaHistory);
		salesPersonQuotaHistory.setSalesPerson(null);

		return salesPersonQuotaHistory;
	}

	public List<SalesTerritoryHistory> getSalesTerritoryHistories() {
		return this.salesTerritoryHistories;
	}

	public void setSalesTerritoryHistories(List<SalesTerritoryHistory> salesTerritoryHistories) {
		this.salesTerritoryHistories = salesTerritoryHistories;
	}

	public SalesTerritoryHistory addSalesTerritoryHistory(SalesTerritoryHistory salesTerritoryHistory) {
		getSalesTerritoryHistories().add(salesTerritoryHistory);
		salesTerritoryHistory.setSalesPerson(this);

		return salesTerritoryHistory;
	}

	public SalesTerritoryHistory removeSalesTerritoryHistory(SalesTerritoryHistory salesTerritoryHistory) {
		getSalesTerritoryHistories().remove(salesTerritoryHistory);
		salesTerritoryHistory.setSalesPerson(null);

		return salesTerritoryHistory;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setSalesPerson(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setSalesPerson(null);

		return store;
	}

}