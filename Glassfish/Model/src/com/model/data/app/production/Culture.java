package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Culture database table.
 * 
 */
@Entity(name="Culture")
@Table(name="Culture") //, schema="Production")
@Access(AccessType.FIELD)
public class Culture extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CultureID")
	@Basic(optional=false)
	private String cultureID;
	
	@Column(name="CultureID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to ProductModelProductDescriptionCulture
	@OneToMany(mappedBy="culture", fetch=FetchType.LAZY)
	private List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures;

	public Culture() {
	}

	public String getCultureID() {
		return this.cultureID;
	}

	public void setCultureID(String cultureID) {
		this.cultureID = cultureID;
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

	public List<ProductModelProductDescriptionCulture> getProductModelProductDescriptionCultures() {
		return this.productModelProductDescriptionCultures;
	}

	public void setProductModelProductDescriptionCultures(List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures) {
		this.productModelProductDescriptionCultures = productModelProductDescriptionCultures;
	}

	public ProductModelProductDescriptionCulture addProductModelProductDescriptionCulture(ProductModelProductDescriptionCulture productModelProductDescriptionCulture) {
		getProductModelProductDescriptionCultures().add(productModelProductDescriptionCulture);
		productModelProductDescriptionCulture.setCulture(this);

		return productModelProductDescriptionCulture;
	}

	public ProductModelProductDescriptionCulture removeProductModelProductDescriptionCulture(ProductModelProductDescriptionCulture productModelProductDescriptionCulture) {
		getProductModelProductDescriptionCultures().remove(productModelProductDescriptionCulture);
		productModelProductDescriptionCulture.setCulture(null);

		return productModelProductDescriptionCulture;
	}

}