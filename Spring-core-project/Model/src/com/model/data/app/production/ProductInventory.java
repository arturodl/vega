package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the ProductInventory database table.
 * 
 */
@Entity(name="ProductInventory")
@Table(name="ProductInventory") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductInventory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductInventoryPK id;

	@Column(name="Bin")
	private short bin;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Quantity")
	private short quantity;

	private String rowguid;

	@Column(name="Shelf")
	private String shelf;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LocationID", insertable=false, updatable=false)
	private Location location;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID", insertable=false, updatable=false)
	private Product product;

	public ProductInventory() {
	}

	public ProductInventoryPK getId() {
		return this.id;
	}

	public void setId(ProductInventoryPK id) {
		this.id = id;
	}

	public short getBin() {
		return this.bin;
	}

	public void setBin(short bin) {
		this.bin = bin;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public String getShelf() {
		return this.shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}