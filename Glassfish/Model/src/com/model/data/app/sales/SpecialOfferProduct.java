package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the SpecialOfferProduct database table.
 * 
 */
@Entity(name="SpecialOfferProduct")
@Table(name="SpecialOfferProduct") //, schema="Sales")
@Access(AccessType.FIELD)
public class SpecialOfferProduct extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SpecialOfferProductPK id;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	private String rowguid;

	//bi-directional many-to-one association to SpecialOffer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SpecialOfferID", insertable=false, updatable=false)
	private SpecialOffer specialOffer;

	public SpecialOfferProduct() {
	}

	public SpecialOfferProductPK getId() {
		return this.id;
	}

	public void setId(SpecialOfferProductPK id) {
		this.id = id;
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

	public SpecialOffer getSpecialOffer() {
		return this.specialOffer;
	}

	public void setSpecialOffer(SpecialOffer specialOffer) {
		this.specialOffer = specialOffer;
	}

}