package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the ProductProductPhoto database table.
 * 
 */
@Entity(name="ProductProductPhoto")
@Table(name="ProductProductPhoto") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductProductPhoto extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductProductPhotoPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Primary")
	private boolean primary;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID", insertable=false, updatable=false)
	private Product product;

	//bi-directional many-to-one association to ProductPhoto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductPhotoID", insertable=false, updatable=false)
	private ProductPhoto productPhoto;

	public ProductProductPhoto() {
	}

	public ProductProductPhotoPK getId() {
		return this.id;
	}

	public void setId(ProductProductPhotoPK id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean getPrimary() {
		return this.primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductPhoto getProductPhoto() {
		return this.productPhoto;
	}

	public void setProductPhoto(ProductPhoto productPhoto) {
		this.productPhoto = productPhoto;
	}

}