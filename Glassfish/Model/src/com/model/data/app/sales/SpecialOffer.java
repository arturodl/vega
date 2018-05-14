package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SpecialOffer database table.
 * 
 */
@Entity(name="SpecialOffer")
@Table(name="SpecialOffer") //, schema="Sales")
@Access(AccessType.FIELD)
public class SpecialOffer extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SpecialOfferID")
	@Basic(optional=false)
	private int specialOfferID;
	
	@Column(name="SpecialOfferID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="Category")
	private String category;

	@Column(name="Description")
	private String description;

	@Column(name="DiscountPct")
	private BigDecimal discountPct;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="MaxQty")
	private int maxQty;

	@Column(name="MinQty")
	private int minQty;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	@Column(name="StartDate")
	private Timestamp startDate;

	@Column(name="Type")
	private String type;

	//bi-directional many-to-one association to SpecialOfferProduct
	@OneToMany(mappedBy="specialOffer", fetch=FetchType.LAZY)
	private List<SpecialOfferProduct> specialOfferProducts;

	public SpecialOffer() {
	}

	public int getSpecialOfferID() {
		return this.specialOfferID;
	}

	public void setSpecialOfferID(int specialOfferID) {
		this.specialOfferID = specialOfferID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDiscountPct() {
		return this.discountPct;
	}

	public void setDiscountPct(BigDecimal discountPct) {
		this.discountPct = discountPct;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getMaxQty() {
		return this.maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public int getMinQty() {
		return this.minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SpecialOfferProduct> getSpecialOfferProducts() {
		return this.specialOfferProducts;
	}

	public void setSpecialOfferProducts(List<SpecialOfferProduct> specialOfferProducts) {
		this.specialOfferProducts = specialOfferProducts;
	}

	public SpecialOfferProduct addSpecialOfferProduct(SpecialOfferProduct specialOfferProduct) {
		getSpecialOfferProducts().add(specialOfferProduct);
		specialOfferProduct.setSpecialOffer(this);

		return specialOfferProduct;
	}

	public SpecialOfferProduct removeSpecialOfferProduct(SpecialOfferProduct specialOfferProduct) {
		getSpecialOfferProducts().remove(specialOfferProduct);
		specialOfferProduct.setSpecialOffer(null);

		return specialOfferProduct;
	}

}