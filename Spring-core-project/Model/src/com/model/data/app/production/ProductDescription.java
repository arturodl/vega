package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ProductDescription database table.
 * 
 */
@Entity(name="ProductDescription")
@Table(name="ProductDescription") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductDescription extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductDescriptionID")
	@Basic(optional=false)
	private int productDescriptionID;

	@Column(name="ProductDescriptionID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;
	
	@Column(name="Description")
	private String description;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to ProductModelProductDescriptionCulture
	@OneToMany(mappedBy="productDescription", fetch=FetchType.LAZY)
	private List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures;

	public ProductDescription() {
	}

	public int getProductDescriptionID() {
		return this.productDescriptionID;
	}

	public void setProductDescriptionID(int productDescriptionID) {
		this.productDescriptionID = productDescriptionID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public List<ProductModelProductDescriptionCulture> getProductModelProductDescriptionCultures() {
		return this.productModelProductDescriptionCultures;
	}

	public void setProductModelProductDescriptionCultures(List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures) {
		this.productModelProductDescriptionCultures = productModelProductDescriptionCultures;
	}

	public ProductModelProductDescriptionCulture addProductModelProductDescriptionCulture(ProductModelProductDescriptionCulture productModelProductDescriptionCulture) {
		getProductModelProductDescriptionCultures().add(productModelProductDescriptionCulture);
		productModelProductDescriptionCulture.setProductDescription(this);

		return productModelProductDescriptionCulture;
	}

	public ProductModelProductDescriptionCulture removeProductModelProductDescriptionCulture(ProductModelProductDescriptionCulture productModelProductDescriptionCulture) {
		getProductModelProductDescriptionCultures().remove(productModelProductDescriptionCulture);
		productModelProductDescriptionCulture.setProductDescription(null);

		return productModelProductDescriptionCulture;
	}

}