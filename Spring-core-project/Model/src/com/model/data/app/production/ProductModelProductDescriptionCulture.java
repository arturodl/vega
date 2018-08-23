package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the ProductModelProductDescriptionCulture database table.
 * 
 */
@Entity(name="ProductModelProductDescriptionCulture")
@Table(name="ProductModelProductDescriptionCulture") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductModelProductDescriptionCulture extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductModelProductDescriptionCulturePK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Culture
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CultureID", insertable=false, updatable=false)
	private Culture culture;

	//bi-directional many-to-one association to ProductDescription
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductDescriptionID", insertable=false, updatable=false)
	private ProductDescription productDescription;

	//bi-directional many-to-one association to ProductModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductModelID", insertable=false, updatable=false)
	private ProductModel productModel;

	public ProductModelProductDescriptionCulture() {
	}

	public ProductModelProductDescriptionCulturePK getId() {
		return this.id;
	}

	public void setId(ProductModelProductDescriptionCulturePK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Culture getCulture() {
		return this.culture;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

	public ProductDescription getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}

	public ProductModel getProductModel() {
		return this.productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

}