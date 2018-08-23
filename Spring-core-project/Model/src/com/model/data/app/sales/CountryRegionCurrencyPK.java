package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CountryRegionCurrency database table.
 * 
 */
@Embeddable
public class CountryRegionCurrencyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CountryRegionCode", insertable=false, updatable=false)
	private String countryRegionCode;

	@Column(name="CurrencyCode", insertable=false, updatable=false)
	private String currencyCode;

	public CountryRegionCurrencyPK() {
	}
	public String getCountryRegionCode() {
		return this.countryRegionCode;
	}
	public void setCountryRegionCode(String countryRegionCode) {
		this.countryRegionCode = countryRegionCode;
	}
	public String getCurrencyCode() {
		return this.currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CountryRegionCurrencyPK)) {
			return false;
		}
		CountryRegionCurrencyPK castOther = (CountryRegionCurrencyPK)other;
		return 
			this.countryRegionCode.equals(castOther.countryRegionCode)
			&& this.currencyCode.equals(castOther.currencyCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.countryRegionCode.hashCode();
		hash = hash * prime + this.currencyCode.hashCode();
		
		return hash;
	}
}