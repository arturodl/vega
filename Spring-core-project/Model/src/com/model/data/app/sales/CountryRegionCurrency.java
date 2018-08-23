package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the CountryRegionCurrency database table.
 * 
 */
@Entity(name="CountryRegionCurrency")
@Table(name="CountryRegionCurrency") //, schema="Sales")
@Access(AccessType.FIELD)
public class CountryRegionCurrency extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountryRegionCurrencyPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CurrencyCode", insertable=false, updatable=false)
	private Currency currency;

	public CountryRegionCurrency() {
	}

	public CountryRegionCurrencyPK getId() {
		return this.id;
	}

	public void setId(CountryRegionCurrencyPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}