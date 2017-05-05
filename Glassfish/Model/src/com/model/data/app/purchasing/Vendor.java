package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.core.app.modelo.Entidad;
import com.model.data.app.person.BusinessEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Vendor database table.
 * 
 */
@Entity(name="Vendor")
@Table(name="Vendor", schema="Purchasing")
@Access(AccessType.FIELD)
public class Vendor extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="AccountNumber") 
	private String accountNumber;

	@Column(name="ActiveFlag")
	private boolean activeFlag;

	@Column(name="CreditRating")
	private short creditRating;

	@Column(name="ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name="Name")
	private String name;

	@Column(name="PreferredVendorStatus")
	private boolean preferredVendorStatus;

	@Column(name="PurchasingWebServiceURL")
	private String purchasingWebServiceURL;

	//bi-directional many-to-one association to ProductVendor
	@JoinColumn(name="businessEntityId", referencedColumnName="businessEntityId")
	@OneToMany(fetch=FetchType.LAZY)
	private List<ProductVendor> productVendors;
	
	
	
	@Id
	@OneToOne
	@JoinColumn(name = "businessEntityId",referencedColumnName="businessEntityId")
	private BusinessEntity businessEntity;
	
	public Vendor() {
	}
	
	
	




	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public short getCreditRating() {
		return this.creditRating;
	}

	public void setCreditRating(short creditRating) {
		this.creditRating = creditRating;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getPreferredVendorStatus() {
		return this.preferredVendorStatus;
	}

	public void setPreferredVendorStatus(boolean preferredVendorStatus) {
		this.preferredVendorStatus = preferredVendorStatus;
	}

	public String getPurchasingWebServiceURL() {
		return this.purchasingWebServiceURL;
	}

	public void setPurchasingWebServiceURL(String purchasingWebServiceURL) {
		this.purchasingWebServiceURL = purchasingWebServiceURL;
	}

	public List<ProductVendor> getProductVendors() {
		return this.productVendors;
	}

	public void setProductVendors(List<ProductVendor> productVendors) {
		this.productVendors = productVendors;
	}

	public ProductVendor addProductVendor(ProductVendor productVendor) {
		getProductVendors().add(productVendor);
		productVendor.setVendor(this);

		return productVendor;
	}

	public ProductVendor removeProductVendor(ProductVendor productVendor) {
		getProductVendors().remove(productVendor);
		productVendor.setVendor(null);

		return productVendor;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}



	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	
	}

}