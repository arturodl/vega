package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CreditCard database table.
 * 
 */
@Entity(name="CreditCard")
@Table(name="CreditCard") //, schema="Sales")
@Access(AccessType.FIELD)
public class CreditCard extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CreditCardID")
	@Basic(optional=false)
	private int creditCardID;
	
	@Column(name="CreditCardID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="CardNumber")
	private String cardNumber;

	@Column(name="CardType")
	private String cardType;

	@Column(name="ExpMonth")
	private short expMonth;

	@Column(name="ExpYear")
	private short expYear;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to PersonCreditCard
	@OneToMany(mappedBy="creditCard", fetch=FetchType.LAZY)
	private List<PersonCreditCard> personCreditCards;

	public CreditCard() {
	}

	public int getCreditCardID() {
		return this.creditCardID;
	}

	public void setCreditCardID(int creditCardID) {
		this.creditCardID = creditCardID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public short getExpMonth() {
		return this.expMonth;
	}

	public void setExpMonth(short expMonth) {
		this.expMonth = expMonth;
	}

	public short getExpYear() {
		return this.expYear;
	}

	public void setExpYear(short expYear) {
		this.expYear = expYear;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<PersonCreditCard> getPersonCreditCards() {
		return this.personCreditCards;
	}

	public void setPersonCreditCards(List<PersonCreditCard> personCreditCards) {
		this.personCreditCards = personCreditCards;
	}

	public PersonCreditCard addPersonCreditCard(PersonCreditCard personCreditCard) {
		getPersonCreditCards().add(personCreditCard);
		personCreditCard.setCreditCard(this);

		return personCreditCard;
	}

	public PersonCreditCard removePersonCreditCard(PersonCreditCard personCreditCard) {
		getPersonCreditCards().remove(personCreditCard);
		personCreditCard.setCreditCard(null);

		return personCreditCard;
	}

}