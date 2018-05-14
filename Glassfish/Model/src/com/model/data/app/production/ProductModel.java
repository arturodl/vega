package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ProductModel database table.
 * 
 */
@Entity(name="ProductModel")
@Table(name="ProductModel") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductModel extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductModelID")
	@Basic(optional=false)
	private int productModelID;
	
	@Column(name="ProductModelID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	//Columna tipo XML, en JPA la dejamos como String
	@Column(name="CatalogDescription")
	private String catalogDescription;

	//Columna tipo XML, en JPA la dejamos como String
	@Column(name="Instructions")
	private String instructions;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productModel", fetch=FetchType.LAZY)
	private List<Product> products;

	//bi-directional many-to-one association to ProductModelIllustration
	@OneToMany(mappedBy="productModel", fetch=FetchType.LAZY)
	private List<ProductModelIllustration> productModelIllustrations;

	//bi-directional many-to-one association to ProductModelProductDescriptionCulture
	@OneToMany(mappedBy="productModel", fetch=FetchType.LAZY)
	private List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures;

	public ProductModel() {
	}

	public int getProductModelID() {
		return this.productModelID;
	}

	public void setProductModelID(int productModelID) {
		this.productModelID = productModelID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatalogDescription() {
		return this.catalogDescription;
	}

	public void setCatalogDescription(String catalogDescription) {
		this.catalogDescription = catalogDescription;
	}

	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
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
		product.setProductModel(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductModel(null);

		return product;
	}

	public List<ProductModelIllustration> getProductModelIllustrations() {
		return this.productModelIllustrations;
	}

	public void setProductModelIllustrations(List<ProductModelIllustration> productModelIllustrations) {
		this.productModelIllustrations = productModelIllustrations;
	}

	public ProductModelIllustration addProductModelIllustration(ProductModelIllustration productModelIllustration) {
		getProductModelIllustrations().add(productModelIllustration);
		productModelIllustration.setProductModel(this);

		return productModelIllustration;
	}

	public ProductModelIllustration removeProductModelIllustration(ProductModelIllustration productModelIllustration) {
		getProductModelIllustrations().remove(productModelIllustration);
		productModelIllustration.setProductModel(null);

		return productModelIllustration;
	}

	public List<ProductModelProductDescriptionCulture> getProductModelProductDescriptionCultures() {
		return this.productModelProductDescriptionCultures;
	}

	public void setProductModelProductDescriptionCultures(List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures) {
		this.productModelProductDescriptionCultures = productModelProductDescriptionCultures;
	}

	public ProductModelProductDescriptionCulture addProductModelProductDescriptionCulture(ProductModelProductDescriptionCulture productModelProductDescriptionCulture) {
		getProductModelProductDescriptionCultures().add(productModelProductDescriptionCulture);
		productModelProductDescriptionCulture.setProductModel(this);

		return productModelProductDescriptionCulture;
	}

	public ProductModelProductDescriptionCulture removeProductModelProductDescriptionCulture(ProductModelProductDescriptionCulture productModelProductDescriptionCulture) {
		getProductModelProductDescriptionCultures().remove(productModelProductDescriptionCulture);
		productModelProductDescriptionCulture.setProductModel(null);

		return productModelProductDescriptionCulture;
	}

}