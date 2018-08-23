package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the SalesTaxRate database table.
 * 
 */
@Entity(name="SalesTaxRate")
@Table(name="SalesTaxRate") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesTaxRate extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SalesTaxRateID")
	@Basic(optional=false)
	private int salesTaxRateID;
	
	@Column(name="SalesTaxRateID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	@Column(name="StateProvinceID")
	private int stateProvinceID;

	@Column(name="TaxRate")
	private BigDecimal taxRate;

	@Column(name="TaxType")
	private short taxType;

	public SalesTaxRate() {
	}

	public int getSalesTaxRateID() {
		return this.salesTaxRateID;
	}

	public void setSalesTaxRateID(int salesTaxRateID) {
		this.salesTaxRateID = salesTaxRateID;
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

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public int getStateProvinceID() {
		return this.stateProvinceID;
	}

	public void setStateProvinceID(int stateProvinceID) {
		this.stateProvinceID = stateProvinceID;
	}

	public BigDecimal getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public short getTaxType() {
		return this.taxType;
	}

	public void setTaxType(short taxType) {
		this.taxType = taxType;
	}

}