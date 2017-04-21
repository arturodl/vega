package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the ProductCostHistory database table.
 * 
 */
@Entity(name="ProductCostHistory")
@Table(name="ProductCostHistory", schema="Production")
@Access(AccessType.FIELD)
public class ProductCostHistory extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductCostHistoryPK id;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="StandardCost")
	private BigDecimal standardCost;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID", insertable=false, updatable=false)
	private Product product;

	public ProductCostHistory() {
	}

	public ProductCostHistoryPK getId() {
		return this.id;
	}

	public void setId(ProductCostHistoryPK id) {
		this.id = id;
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

	public BigDecimal getStandardCost() {
		return this.standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}