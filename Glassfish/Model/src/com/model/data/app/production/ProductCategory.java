package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ProductCategory database table.
 * 
 */
@Entity(name="ProductCategory")
@Table(name="ProductCategory", schema="Production")
@Access(AccessType.FIELD)
public class ProductCategory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductCategoryID")
	@Basic(optional=false)
	private int productCategoryID;
	
	@Column(name="ProductCategoryID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	//bi-directional many-to-one association to ProductSubcategory
	@OneToMany(mappedBy="productCategory", fetch=FetchType.LAZY)
	private List<ProductSubcategory> productSubcategories;

	public ProductCategory() {
	}

	public int getProductCategoryID() {
		return this.productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public List<ProductSubcategory> getProductSubcategories() {
		return this.productSubcategories;
	}

	public void setProductSubcategories(List<ProductSubcategory> productSubcategories) {
		this.productSubcategories = productSubcategories;
	}

	public ProductSubcategory addProductSubcategory(ProductSubcategory productSubcategory) {
		getProductSubcategories().add(productSubcategory);
		productSubcategory.setProductCategory(this);

		return productSubcategory;
	}

	public ProductSubcategory removeProductSubcategory(ProductSubcategory productSubcategory) {
		getProductSubcategories().remove(productSubcategory);
		productSubcategory.setProductCategory(null);

		return productSubcategory;
	}

}