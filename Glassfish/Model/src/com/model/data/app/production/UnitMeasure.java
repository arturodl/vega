package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the UnitMeasure database table.
 * 
 */
@Entity(name="UnitMeasure")
@Table(name="UnitMeasure") //, schema="Production")
@Access(AccessType.FIELD)
public class UnitMeasure extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	//Llave primaria del catalogo de unidades de medida
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UnitMeasureCode")
	@Basic(optional=false)
	private String unitMeasureCode;

	@Column(name="ModifiedDate")
	@Basic(optional=false)
	private Timestamp modifiedDate;

	@Column(name="Name")
	@Basic(optional=false)
	private String name;

	//bi-directional many-to-one association to BillOfMaterial
	@OneToMany(mappedBy="unitMeasure", fetch=FetchType.LAZY)
	private List<BillOfMaterials> billOfMaterials;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="unitMeasure1", fetch=FetchType.LAZY)
	private List<Product> products1;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="unitMeasure2", fetch=FetchType.LAZY)
	private List<Product> products2;

	public UnitMeasure() {
	}

	public String getUnitMeasureCode() {
		return this.unitMeasureCode;
	}

	public void setUnitMeasureCode(String unitMeasureCode) {
		this.unitMeasureCode = unitMeasureCode;
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

	public List<BillOfMaterials> getBillOfMaterials() {
		return this.billOfMaterials;
	}

	public void setBillOfMaterials(List<BillOfMaterials> billOfMaterials) {
		this.billOfMaterials = billOfMaterials;
	}

	public BillOfMaterials addBillOfMaterial(BillOfMaterials billOfMaterial) {
		getBillOfMaterials().add(billOfMaterial);
		billOfMaterial.setUnitMeasure(this);

		return billOfMaterial;
	}

	public BillOfMaterials removeBillOfMaterial(BillOfMaterials billOfMaterial) {
		getBillOfMaterials().remove(billOfMaterial);
		billOfMaterial.setUnitMeasure(null);

		return billOfMaterial;
	}

	public List<Product> getProducts1() {
		return this.products1;
	}

	public void setProducts1(List<Product> products1) {
		this.products1 = products1;
	}

	public Product addProducts1(Product products1) {
		getProducts1().add(products1);
		products1.setUnitMeasure1(this);

		return products1;
	}

	public Product removeProducts1(Product products1) {
		getProducts1().remove(products1);
		products1.setUnitMeasure1(null);

		return products1;
	}

	public List<Product> getProducts2() {
		return this.products2;
	}

	public void setProducts2(List<Product> products2) {
		this.products2 = products2;
	}

	public Product addProducts2(Product products2) {
		getProducts2().add(products2);
		products2.setUnitMeasure2(this);

		return products2;
	}

	public Product removeProducts2(Product products2) {
		getProducts2().remove(products2);
		products2.setUnitMeasure2(null);

		return products2;
	}

}