package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ProductSubcategory database table.
 * 
 */
@Entity(name="ProductSubcategory")
@Table(name="ProductSubcategory") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductSubcategory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductSubcategoryID")
	@Basic(optional=false)
	private int productSubcategoryID;
	
	@Column(name="ProductSubcategoryID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productSubcategory", fetch=FetchType.LAZY)
	private List<Product> products;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductCategoryID")
	private ProductCategory productCategory;

	public ProductSubcategory() {
	}

	public int getProductSubcategoryID() {
		return this.productSubcategoryID;
	}

	public void setProductSubcategoryID(int productSubcategoryID) {
		this.productSubcategoryID = productSubcategoryID;
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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductSubcategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductSubcategory(null);

		return product;
	}

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

}