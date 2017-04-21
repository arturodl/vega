package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the ProductModelIllustration database table.
 * 
 */
@Entity(name="ProductModelIllustration")
@Table(name="ProductModelIllustration", schema="Production")
@Access(AccessType.FIELD)
public class ProductModelIllustration extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductModelIllustrationPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Illustration
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IllustrationID", insertable=false, updatable=false)
	private Illustration illustration;

	//bi-directional many-to-one association to ProductModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductModelID", insertable=false, updatable=false)
	private ProductModel productModel;

	public ProductModelIllustration() {
	}

	public ProductModelIllustrationPK getId() {
		return this.id;
	}

	public void setId(ProductModelIllustrationPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Illustration getIllustration() {
		return this.illustration;
	}

	public void setIllustration(Illustration illustration) {
		this.illustration = illustration;
	}

	public ProductModel getProductModel() {
		return this.productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

}