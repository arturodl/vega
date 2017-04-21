package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the BillOfMaterials database table.
 * 
 */
@Entity(name="BillOfMaterials")
@Table(name="BillOfMaterials", schema="Production")
@Access(AccessType.FIELD)
public class BillOfMaterials extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BillOfMaterialsID")
	@Basic(optional=false)
	private int billOfMaterialsID;
	
	@Column(name="BillOfMaterialsID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	private short BOMLevel;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="PerAssemblyQty")
	private BigDecimal perAssemblyQty;

	@Column(name="StartDate")
	private Timestamp startDate;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductAssemblyID")
	private Product product1;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ComponentID")
	private Product product2;

	//bi-directional many-to-one association to UnitMeasure
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UnitMeasureCode")
	private UnitMeasure unitMeasure;

	public BillOfMaterials() {
	}

	public int getBillOfMaterialsID() {
		return this.billOfMaterialsID;
	}

	public void setBillOfMaterialsID(int billOfMaterialsID) {
		this.billOfMaterialsID = billOfMaterialsID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getBOMLevel() {
		return this.BOMLevel;
	}

	public void setBOMLevel(short BOMLevel) {
		this.BOMLevel = BOMLevel;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigDecimal getPerAssemblyQty() {
		return this.perAssemblyQty;
	}

	public void setPerAssemblyQty(BigDecimal perAssemblyQty) {
		this.perAssemblyQty = perAssemblyQty;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Product getProduct1() {
		return this.product1;
	}

	public void setProduct1(Product product1) {
		this.product1 = product1;
	}

	public Product getProduct2() {
		return this.product2;
	}

	public void setProduct2(Product product2) {
		this.product2 = product2;
	}

	public UnitMeasure getUnitMeasure() {
		return this.unitMeasure;
	}

	public void setUnitMeasure(UnitMeasure unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

}