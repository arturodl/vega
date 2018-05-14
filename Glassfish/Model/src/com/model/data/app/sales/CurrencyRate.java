package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the CurrencyRate database table.
 * 
 */
@Entity(name="CurrencyRate")
@Table(name="CurrencyRate") //, schema="Sales")
@Access(AccessType.FIELD)
public class CurrencyRate extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CurrencyRateID")
	@Basic(optional=false)
	private int currencyRateID;

	@Column(name="CurrencyRateID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;
	
	@Column(name="AverageRate")
	private BigDecimal averageRate;

	@Column(name="CurrencyRateDate")
	private Timestamp currencyRateDate;

	@Column(name="EndOfDayRate")
	private BigDecimal endOfDayRate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FromCurrencyCode")
	private Currency currency1;

	//bi-directional many-to-one association to Currency
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ToCurrencyCode")
	private Currency currency2;

	public CurrencyRate() {
	}

	public int getCurrencyRateID() {
		return this.currencyRateID;
	}

	public void setCurrencyRateID(int currencyRateID) {
		this.currencyRateID = currencyRateID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAverageRate() {
		return this.averageRate;
	}

	public void setAverageRate(BigDecimal averageRate) {
		this.averageRate = averageRate;
	}

	public Timestamp getCurrencyRateDate() {
		return this.currencyRateDate;
	}

	public void setCurrencyRateDate(Timestamp currencyRateDate) {
		this.currencyRateDate = currencyRateDate;
	}

	public BigDecimal getEndOfDayRate() {
		return this.endOfDayRate;
	}

	public void setEndOfDayRate(BigDecimal endOfDayRate) {
		this.endOfDayRate = endOfDayRate;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Currency getCurrency1() {
		return this.currency1;
	}

	public void setCurrency1(Currency currency1) {
		this.currency1 = currency1;
	}

	public Currency getCurrency2() {
		return this.currency2;
	}

	public void setCurrency2(Currency currency2) {
		this.currency2 = currency2;
	}

}