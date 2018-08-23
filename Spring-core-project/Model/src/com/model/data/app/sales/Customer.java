package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the Customer database table.
 * 
 */
@Entity(name="Customer")
@Table(name="Customer") //, schema="Sales")
@Access(AccessType.FIELD)
public class Customer extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CustomerID")
	@Basic(optional=false)
	private int customerID;
	
	@Column(name="CustomerID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="AccountNumber")
	private String accountNumber;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="PersonID")
	private int personID;

	private String rowguid;

	//bi-directional many-to-one association to SalesTerritory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TerritoryID")
	private SalesTerritory salesTerritory;

	//bi-directional many-to-one association to Store
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="StoreID")
	private Store store;

	public Customer() {
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getPersonID() {
		return this.personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public SalesTerritory getSalesTerritory() {
		return this.salesTerritory;
	}

	public void setSalesTerritory(SalesTerritory salesTerritory) {
		this.salesTerritory = salesTerritory;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}