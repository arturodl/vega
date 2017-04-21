package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProductDocument database table.
 * 
 */
@Embeddable
public class ProductDocumentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ProductID", insertable=false, updatable=false)
	private int productID;

	@Column(name="DocumentNode", insertable=false, updatable=false)
	private String documentNode;

	public ProductDocumentPK() {
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getDocumentNode() {
		return this.documentNode;
	}
	public void setDocumentNode(String documentNode) {
		this.documentNode = documentNode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductDocumentPK)) {
			return false;
		}
		ProductDocumentPK castOther = (ProductDocumentPK)other;
		return 
			(this.productID == castOther.productID)
			&& this.documentNode.equals(castOther.documentNode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productID;
		hash = hash * prime + this.documentNode.hashCode();
		
		return hash;
	}
}