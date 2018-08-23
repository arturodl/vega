package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;


/**
 * The persistent class for the ProductReview database table.
 * 
 */
@Entity(name="ProductReview")
@Table(name="ProductReview") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductReview extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductReviewID")
	@Basic(optional=false)
	private int productReviewID;
	
	@Column(name="ProductReviewID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="Comments")
	private String comments;

	@Column(name="EmailAddress")
	private String emailAddress;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Rating")
	private int rating;

	@Column(name="ReviewDate")
	private Timestamp reviewDate;

	@Column(name="ReviewerName")
	private String reviewerName;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductID")
	private Product product;

	public ProductReview() {
	}

	public int getProductReviewID() {
		return this.productReviewID;
	}

	public void setProductReviewID(int productReviewID) {
		this.productReviewID = productReviewID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Timestamp getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewerName() {
		return this.reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}