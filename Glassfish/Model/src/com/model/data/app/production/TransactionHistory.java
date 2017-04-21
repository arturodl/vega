package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the TransactionHistory database table.
 * 
 */
@Entity(name="TransactionHistory")
@Table(name="TransactionHistory", schema="Production")
@Access(AccessType.FIELD)
public class TransactionHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TransactionID")
	@Basic(optional=false)
	private int transactionID;
	
	@Column(name="TransactionID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="ActualCost")
	private BigDecimal actualCost;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Quantity")
	private int quantity;

	@Column(name="ReferenceOrderID")
	private int referenceOrderID;

	@Column(name="ReferenceOrderLineID")
	private int referenceOrderLineID;

	@Column(name="TransactionDate")
	private Timestamp transactionDate;

	@Column(name="TransactionType")
	private String transactionType;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID")
	private Product product;

	public TransactionHistory() {
	}

	public int getTransactionID() {
		return this.transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getActualCost() {
		return this.actualCost;
	}

	public void setActualCost(BigDecimal actualCost) {
		this.actualCost = actualCost;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReferenceOrderID() {
		return this.referenceOrderID;
	}

	public void setReferenceOrderID(int referenceOrderID) {
		this.referenceOrderID = referenceOrderID;
	}

	public int getReferenceOrderLineID() {
		return this.referenceOrderLineID;
	}

	public void setReferenceOrderLineID(int referenceOrderLineID) {
		this.referenceOrderLineID = referenceOrderLineID;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}