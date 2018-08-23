package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Location database table.
 * 
 */
@Entity(name="Location")
@Table(name="Location") //, schema="Production")
@Access(AccessType.FIELD)
public class Location extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LocationID")
	@Basic(optional=false)
	private short locationID;
	
	@Column(name="LocationID", insertable=false, updatable=false)
	@Basic(optional=false)
	private short id;

	@Column(name="Availability")
	private BigDecimal availability;

	@Column(name="CostRate")
	private BigDecimal costRate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to ProductInventory
	@OneToMany(mappedBy="location")
	private List<ProductInventory> productInventories;

	//bi-directional many-to-one association to WorkOrderRouting
	@OneToMany(mappedBy="location")
	private List<WorkOrderRouting> workOrderRoutings;

	public Location() {
	}

	public short getLocationID() {
		return this.locationID;
	}

	public void setLocationID(short locationID) {
		this.locationID = locationID;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public BigDecimal getAvailability() {
		return this.availability;
	}

	public void setAvailability(BigDecimal availability) {
		this.availability = availability;
	}

	public BigDecimal getCostRate() {
		return this.costRate;
	}

	public void setCostRate(BigDecimal costRate) {
		this.costRate = costRate;
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

	public List<ProductInventory> getProductInventories() {
		return this.productInventories;
	}

	public void setProductInventories(List<ProductInventory> productInventories) {
		this.productInventories = productInventories;
	}

	public ProductInventory addProductInventory(ProductInventory productInventory) {
		getProductInventories().add(productInventory);
		productInventory.setLocation(this);

		return productInventory;
	}

	public ProductInventory removeProductInventory(ProductInventory productInventory) {
		getProductInventories().remove(productInventory);
		productInventory.setLocation(null);

		return productInventory;
	}

	public List<WorkOrderRouting> getWorkOrderRoutings() {
		return this.workOrderRoutings;
	}

	public void setWorkOrderRoutings(List<WorkOrderRouting> workOrderRoutings) {
		this.workOrderRoutings = workOrderRoutings;
	}

	public WorkOrderRouting addWorkOrderRouting(WorkOrderRouting workOrderRouting) {
		getWorkOrderRoutings().add(workOrderRouting);
		workOrderRouting.setLocation(this);

		return workOrderRouting;
	}

	public WorkOrderRouting removeWorkOrderRouting(WorkOrderRouting workOrderRouting) {
		getWorkOrderRoutings().remove(workOrderRouting);
		workOrderRouting.setLocation(null);

		return workOrderRouting;
	}

}