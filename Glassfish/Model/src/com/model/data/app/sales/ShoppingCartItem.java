package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the ShoppingCartItem database table.
 * 
 */
@Entity(name="ShoppingCartItem")
@Table(name="ShoppingCartItem") //, schema="Sales")
@Access(AccessType.FIELD)
public class ShoppingCartItem extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ShoppingCartItemID")
	@Basic(optional=false)
	private int shoppingCartItemID;
	
	@Column(name="ShoppingCartItemID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="DateCreated")
	private Timestamp dateCreated;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="ProductID")
	private int productID;

	@Column(name="Quantity")
	private int quantity;

	@Column(name="ShoppingCartID")
	private String shoppingCartID;

	public ShoppingCartItem() {
	}

	public int getShoppingCartItemID() {
		return this.shoppingCartItemID;
	}

	public void setShoppingCartItemID(int shoppingCartItemID) {
		this.shoppingCartItemID = shoppingCartItemID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShoppingCartID() {
		return this.shoppingCartID;
	}

	public void setShoppingCartID(String shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

}