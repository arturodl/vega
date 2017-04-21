package com.model.data.app.purchasing;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ShipMethod database table.
 * 
 */
@Entity(name="ShipMethod")
@Table(name="ShipMethod", schema="Purchasing")
@Access(AccessType.FIELD)
public class ShipMethod extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ShipMethodID")
	@Basic(optional=false)
	private int shipMethodID;

	@Column(name="ShipMethodID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;
	
	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	private String rowguid;

	@Column(name="ShipBase")
	private BigDecimal shipBase;

	@Column(name="ShipRate")
	private BigDecimal shipRate;

	//bi-directional many-to-one association to PurchaseOrderHeader
	@OneToMany(mappedBy="shipMethod", fetch=FetchType.LAZY)
	private List<PurchaseOrderHeader> purchaseOrderHeaders;

	public ShipMethod() {
	}

	public int getShipMethodID() {
		return this.shipMethodID;
	}

	public void setShipMethodID(int shipMethodID) {
		this.shipMethodID = shipMethodID;
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

	public BigDecimal getShipBase() {
		return this.shipBase;
	}

	public void setShipBase(BigDecimal shipBase) {
		this.shipBase = shipBase;
	}

	public BigDecimal getShipRate() {
		return this.shipRate;
	}

	public void setShipRate(BigDecimal shipRate) {
		this.shipRate = shipRate;
	}

	public List<PurchaseOrderHeader> getPurchaseOrderHeaders() {
		return this.purchaseOrderHeaders;
	}

	public void setPurchaseOrderHeaders(List<PurchaseOrderHeader> purchaseOrderHeaders) {
		this.purchaseOrderHeaders = purchaseOrderHeaders;
	}

	public PurchaseOrderHeader addPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		getPurchaseOrderHeaders().add(purchaseOrderHeader);
		purchaseOrderHeader.setShipMethod(this);

		return purchaseOrderHeader;
	}

	public PurchaseOrderHeader removePurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		getPurchaseOrderHeaders().remove(purchaseOrderHeader);
		purchaseOrderHeader.setShipMethod(null);

		return purchaseOrderHeader;
	}

}