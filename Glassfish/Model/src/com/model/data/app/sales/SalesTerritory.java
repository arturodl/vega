package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SalesTerritory database table.
 * 
 */
@Entity(name="SalesTerritory")
@Table(name="SalesTerritory") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesTerritory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TerritoryID")
	@Basic(optional=false)
	private int territoryID;
	
	@Column(name="TerritoryID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="CostLastYear")
	private BigDecimal costLastYear;

	@Column(name="CostYTD")
	private BigDecimal costYTD;

	@Column(name="CountryRegionCode")
	private String countryRegionCode;

	@Column(name="Group")
	private String group;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	@Column(name="SalesLastYear")
	private BigDecimal salesLastYear;

	@Column(name="SalesYTD")
	private BigDecimal salesYTD;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="salesTerritory", fetch=FetchType.LAZY)
	private List<Customer> customers;

	//bi-directional many-to-one association to SalesPerson
	@OneToMany(mappedBy="salesTerritory", fetch=FetchType.LAZY)
	private List<SalesPerson> salesPersons;

	//bi-directional many-to-one association to SalesTerritoryHistory
	@OneToMany(mappedBy="salesTerritory", fetch=FetchType.LAZY)
	private List<SalesTerritoryHistory> salesTerritoryHistories;

	public SalesTerritory() {
	}

	public int getTerritoryID() {
		return this.territoryID;
	}

	public void setTerritoryID(int territoryID) {
		this.territoryID = territoryID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCostLastYear() {
		return this.costLastYear;
	}

	public void setCostLastYear(BigDecimal costLastYear) {
		this.costLastYear = costLastYear;
	}

	public BigDecimal getCostYTD() {
		return this.costYTD;
	}

	public void setCostYTD(BigDecimal costYTD) {
		this.costYTD = costYTD;
	}

	public String getCountryRegionCode() {
		return this.countryRegionCode;
	}

	public void setCountryRegionCode(String countryRegionCode) {
		this.countryRegionCode = countryRegionCode;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public BigDecimal getSalesYTD() {
		return this.salesYTD;
	}

	public void setSalesYTD(BigDecimal salesYTD) {
		this.salesYTD = salesYTD;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setSalesTerritory(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setSalesTerritory(null);

		return customer;
	}

	public List<SalesPerson> getSalesPersons() {
		return this.salesPersons;
	}

	public void setSalesPersons(List<SalesPerson> salesPersons) {
		this.salesPersons = salesPersons;
	}

	public SalesPerson addSalesPerson(SalesPerson salesPerson) {
		getSalesPersons().add(salesPerson);
		salesPerson.setSalesTerritory(this);

		return salesPerson;
	}

	public SalesPerson removeSalesPerson(SalesPerson salesPerson) {
		getSalesPersons().remove(salesPerson);
		salesPerson.setSalesTerritory(null);

		return salesPerson;
	}

	public List<SalesTerritoryHistory> getSalesTerritoryHistories() {
		return this.salesTerritoryHistories;
	}

	public void setSalesTerritoryHistories(List<SalesTerritoryHistory> salesTerritoryHistories) {
		this.salesTerritoryHistories = salesTerritoryHistories;
	}

	public SalesTerritoryHistory addSalesTerritoryHistory(SalesTerritoryHistory salesTerritoryHistory) {
		getSalesTerritoryHistories().add(salesTerritoryHistory);
		salesTerritoryHistory.setSalesTerritory(this);

		return salesTerritoryHistory;
	}

	public SalesTerritoryHistory removeSalesTerritoryHistory(SalesTerritoryHistory salesTerritoryHistory) {
		getSalesTerritoryHistories().remove(salesTerritoryHistory);
		salesTerritoryHistory.setSalesTerritory(null);

		return salesTerritoryHistory;
	}

}