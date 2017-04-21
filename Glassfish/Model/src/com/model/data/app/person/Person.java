package com.model.data.app.person;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Person database table.
 * 
 */
@Entity(name="Person")
@Table(name="Person", schema="Person")
@Access(AccessType.FIELD)
public class Person extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusinessEntityID")
	private int businessEntityID;

	//En base de datos es de tipo XML, se ha mapeado en JPA como String
	@Column(name="AdditionalContactInfo")
	private String additionalContactInfo;

	//En base de datos es de tipo XML, se ha mapeado en JPA como String
	@Column(name="Demographics")
	private String demographics;

	@Column(name="EmailPromotion")
	private int emailPromotion;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="MiddleName")
	private String middleName;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="NameStyle")
	private boolean nameStyle;

	@Column(name="PersonType")
	private String personType;

	private String rowguid;

	@Column(name="Suffix")
	private String suffix;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-one association to BusinessEntityContact
	@OneToMany(mappedBy="person", fetch=FetchType.LAZY)
	private List<BusinessEntityContact> businessEntityContacts;

	//bi-directional many-to-one association to EmailAddress
	@OneToMany(mappedBy="person", fetch=FetchType.LAZY)
	private List<EmailAddress> emailAddresses;

	//bi-directional one-to-one association to Password
	@OneToOne(mappedBy="person", fetch=FetchType.LAZY)
	private Password password;

	//bi-directional one-to-one association to BusinessEntity
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BusinessEntityID", insertable=false, updatable=false)
	private BusinessEntity businessEntity;

	//bi-directional many-to-one association to PersonPhone
	@OneToMany(mappedBy="person", fetch=FetchType.LAZY)
	private List<PersonPhone> personPhones;

	public Person() {
	}

	public int getBusinessEntityID() {
		return this.businessEntityID;
	}

	public void setBusinessEntityID(int businessEntityID) {
		this.businessEntityID = businessEntityID;
	}

	public String getAdditionalContactInfo() {
		return this.additionalContactInfo;
	}

	public void setAdditionalContactInfo(String additionalContactInfo) {
		this.additionalContactInfo = additionalContactInfo;
	}

	public String getDemographics() {
		return this.demographics;
	}

	public void setDemographics(String demographics) {
		this.demographics = demographics;
	}

	public int getEmailPromotion() {
		return this.emailPromotion;
	}

	public void setEmailPromotion(int emailPromotion) {
		this.emailPromotion = emailPromotion;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean getNameStyle() {
		return this.nameStyle;
	}

	public void setNameStyle(boolean nameStyle) {
		this.nameStyle = nameStyle;
	}

	public String getPersonType() {
		return this.personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<BusinessEntityContact> getBusinessEntityContacts() {
		return this.businessEntityContacts;
	}

	public void setBusinessEntityContacts(List<BusinessEntityContact> businessEntityContacts) {
		this.businessEntityContacts = businessEntityContacts;
	}

	public BusinessEntityContact addBusinessEntityContact(BusinessEntityContact businessEntityContact) {
		getBusinessEntityContacts().add(businessEntityContact);
		businessEntityContact.setPerson(this);

		return businessEntityContact;
	}

	public BusinessEntityContact removeBusinessEntityContact(BusinessEntityContact businessEntityContact) {
		getBusinessEntityContacts().remove(businessEntityContact);
		businessEntityContact.setPerson(null);

		return businessEntityContact;
	}

	public List<EmailAddress> getEmailAddresses() {
		return this.emailAddresses;
	}

	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public EmailAddress addEmailAddress(EmailAddress emailAddress) {
		getEmailAddresses().add(emailAddress);
		emailAddress.setPerson(this);

		return emailAddress;
	}

	public EmailAddress removeEmailAddress(EmailAddress emailAddress) {
		getEmailAddresses().remove(emailAddress);
		emailAddress.setPerson(null);

		return emailAddress;
	}

	public Password getPassword() {
		return this.password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	public List<PersonPhone> getPersonPhones() {
		return this.personPhones;
	}

	public void setPersonPhones(List<PersonPhone> personPhones) {
		this.personPhones = personPhones;
	}

	public PersonPhone addPersonPhone(PersonPhone personPhone) {
		getPersonPhones().add(personPhone);
		personPhone.setPerson(this);

		return personPhone;
	}

	public PersonPhone removePersonPhone(PersonPhone personPhone) {
		getPersonPhones().remove(personPhone);
		personPhone.setPerson(null);

		return personPhone;
	}

}