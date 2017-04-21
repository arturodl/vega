package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Illustration database table.
 * 
 */
@Entity(name="Illustration")
@Table(name="Illustration", schema="Production")
@Access(AccessType.FIELD)
public class Illustration extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IllustrationID")
	@Basic(optional=false)
	private int illustrationID;
	
	@Column(name="IllustrationID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	// Column tipo XML, en JPA la dejamos como String
	@Column(name="Diagram")
	private String diagram;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to ProductModelIllustration
	@OneToMany(mappedBy="illustration")
	private List<ProductModelIllustration> productModelIllustrations;

	public Illustration() {
	}

	public int getIllustrationID() {
		return this.illustrationID;
	}

	public void setIllustrationID(int illustrationID) {
		this.illustrationID = illustrationID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagram() {
		return this.diagram;
	}

	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<ProductModelIllustration> getProductModelIllustrations() {
		return this.productModelIllustrations;
	}

	public void setProductModelIllustrations(List<ProductModelIllustration> productModelIllustrations) {
		this.productModelIllustrations = productModelIllustrations;
	}

	public ProductModelIllustration addProductModelIllustration(ProductModelIllustration productModelIllustration) {
		getProductModelIllustrations().add(productModelIllustration);
		productModelIllustration.setIllustration(this);

		return productModelIllustration;
	}

	public ProductModelIllustration removeProductModelIllustration(ProductModelIllustration productModelIllustration) {
		getProductModelIllustrations().remove(productModelIllustration);
		productModelIllustration.setIllustration(null);

		return productModelIllustration;
	}

}