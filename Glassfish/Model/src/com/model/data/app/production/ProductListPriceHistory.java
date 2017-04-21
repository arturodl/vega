package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the ProductListPriceHistory database table.
 * 
 */
@Entity(name="ProductListPriceHistory")
@Table(name="ProductListPriceHistory", schema="Production")
@Access(AccessType.FIELD)
public class ProductListPriceHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductListPriceHistoryPK id;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="ListPrice")
	private BigDecimal listPrice;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID", insertable=false, updatable=false)
	private Product product;

	public ProductListPriceHistory() {
	}

	public ProductListPriceHistoryPK getId() {
		return this.id;
	}

	public void setId(ProductListPriceHistoryPK id) {
		this.id = id;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}