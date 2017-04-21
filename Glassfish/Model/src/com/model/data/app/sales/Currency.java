package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Currency database table.
 * Catalogo that controlls all currencies by country
 * 
 * Catalogo que contiene todas las monedas de todos los paises
 */
@Entity(name="Currency")
@Table(name="Currency", schema="Sales")
@Access(AccessType.FIELD)
public class Currency extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CurrencyCode")
	@Basic(optional=false)
	private String currencyCode;

	@Column(name="ModifiedDate")
	@Basic(optional=false)
	private Timestamp modifiedDate;

	@Column(name="Name")
	@Basic(optional=false)
	private String name;

	//bi-directional many-to-one association to CountryRegionCurrency
	@OneToMany(mappedBy="currency", fetch=FetchType.LAZY)
	private List<CountryRegionCurrency> countryRegionCurrencies;

	//bi-directional many-to-one association to CurrencyRate
	@OneToMany(mappedBy="currency1", fetch=FetchType.LAZY)
	private List<CurrencyRate> currencyRates1;

	//bi-directional many-to-one association to CurrencyRate
	@OneToMany(mappedBy="currency2", fetch=FetchType.LAZY)
	private List<CurrencyRate> currencyRates2;

	public Currency() {
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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

	public List<CountryRegionCurrency> getCountryRegionCurrencies() {
		return this.countryRegionCurrencies;
	}

	public void setCountryRegionCurrencies(List<CountryRegionCurrency> countryRegionCurrencies) {
		this.countryRegionCurrencies = countryRegionCurrencies;
	}

	public CountryRegionCurrency addCountryRegionCurrency(CountryRegionCurrency countryRegionCurrency) {
		getCountryRegionCurrencies().add(countryRegionCurrency);
		countryRegionCurrency.setCurrency(this);

		return countryRegionCurrency;
	}

	public CountryRegionCurrency removeCountryRegionCurrency(CountryRegionCurrency countryRegionCurrency) {
		getCountryRegionCurrencies().remove(countryRegionCurrency);
		countryRegionCurrency.setCurrency(null);

		return countryRegionCurrency;
	}

	public List<CurrencyRate> getCurrencyRates1() {
		return this.currencyRates1;
	}

	public void setCurrencyRates1(List<CurrencyRate> currencyRates1) {
		this.currencyRates1 = currencyRates1;
	}

	public CurrencyRate addCurrencyRates1(CurrencyRate currencyRates1) {
		getCurrencyRates1().add(currencyRates1);
		currencyRates1.setCurrency1(this);

		return currencyRates1;
	}

	public CurrencyRate removeCurrencyRates1(CurrencyRate currencyRates1) {
		getCurrencyRates1().remove(currencyRates1);
		currencyRates1.setCurrency1(null);

		return currencyRates1;
	}

	public List<CurrencyRate> getCurrencyRates2() {
		return this.currencyRates2;
	}

	public void setCurrencyRates2(List<CurrencyRate> currencyRates2) {
		this.currencyRates2 = currencyRates2;
	}

	public CurrencyRate addCurrencyRates2(CurrencyRate currencyRates2) {
		getCurrencyRates2().add(currencyRates2);
		currencyRates2.setCurrency2(this);

		return currencyRates2;
	}

	public CurrencyRate removeCurrencyRates2(CurrencyRate currencyRates2) {
		getCurrencyRates2().remove(currencyRates2);
		currencyRates2.setCurrency2(null);

		return currencyRates2;
	}

}