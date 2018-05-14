package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlRootElement(name="Vendor")
@Entity(name="Vendor")
@Table(name="Vendor") //, schema="Purchasing")
@Access(AccessType.FIELD)
public class Vendor extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name = "businessEntityId", referencedColumnName="businessEntityId")
	private BusinessEntity businessEntity;

	@Column(name="AccountNumber") 
	private String accountNumber;

	@Column(name="ActiveFlag")
	private Integer activeFlag;

	@Column(name="CreditRating")
	private Integer creditRating;

	@Column(name="ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name="Name")
	private String name;

	@Column(name="PreferredVendorStatus")
	private Integer preferredVendorStatus;

	@Column(name="PurchasingWebServiceURL")
	@Basic(optional = true)
	private String purchasingWebServiceURL;

	//bi-directional many-to-one association to ProductVendor
	@JoinColumn(name="businessEntityId", referencedColumnName="businessEntityId")
	@OneToMany(fetch=FetchType.EAGER)
	private List<ProductVendor> productVendors;	
	
	public Vendor() {
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Integer getCreditRating() {
		return this.creditRating;
	}

	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPreferredVendorStatus() {
		return this.preferredVendorStatus;
	}

	public void setPreferredVendorStatus(Integer preferredVendorStatus) {
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