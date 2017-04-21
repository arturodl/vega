package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Store database table.
 * 
 */
@Entity(name="Store")
@Table(name="Store", schema="Sales")
@Access(AccessType.FIELD)
public class Store extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID")
	private int businessEntityID;

	//Columna tipo XML, en JPA la dejamos como String
	@Column(name="Demographics")
	private String demographics;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="store", fetch=FetchType.LAZY)
	private List<Customer> customers;

	//bi-directional many-to-one association to SalesPerson
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SalesPersonID")
	private SalesPerson salesPerson;

	public Store() {
	}

	public int getBusinessEntityID() {
		return this.businessEntityID;
	}

	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}

	public String getDemographics() {
		return this.demographics;
	}

	public void setDemographics(String demographics) {
		this.demographics = demographics;
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

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setStore(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setStore(null);

		return customer;
	}

	public SalesPerson getSalesPerson() {
		return this.salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}

}