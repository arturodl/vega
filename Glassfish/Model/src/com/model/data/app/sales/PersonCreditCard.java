package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the PersonCreditCard database table.
 * 
 */
@Entity(name="PersonCreditCard")
@Table(name="PersonCreditCard", schema="Sales")
@Access(AccessType.FIELD)
public class PersonCreditCard extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonCreditCardPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to CreditCard
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CreditCardID", insertable=false, updatable=false)
	private CreditCard creditCard;

	public PersonCreditCard() {
	}

	public PersonCreditCardPK getId() {
		return this.id;
	}

	public void setId(PersonCreditCardPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}