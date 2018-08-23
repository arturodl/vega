package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ProductPhoto database table.
 * 
 */
@Entity(name="ProductPhoto")
@Table(name="ProductPhoto") //, schema="Production")
@Access(AccessType.FIELD)
public class ProductPhoto extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductPhotoID")
	@Basic(optional=false)
	private int productPhotoID;
	
	@Column(name="ProductPhotoID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="LargePhoto")
	private byte[] largePhoto;

	@Column(name="LargePhotoFileName")
	private String largePhotoFileName;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="ThumbNailPhoto")
	private byte[] thumbNailPhoto;

	@Column(name="ThumbnailPhotoFileName")
	private String thumbnailPhotoFileName;

	//bi-directional many-to-one association to ProductProductPhoto
	@OneToMany(mappedBy="productPhoto", fetch=FetchType.LAZY)
	private List<ProductProductPhoto> productProductPhotos;

	public ProductPhoto() {
	}

	public int getProductPhotoID() {
		return this.productPhotoID;
	}

	public void setProductPhotoID(int productPhotoID) {
		this.productPhotoID = productPhotoID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getLargePhoto() {
		return this.largePhoto;
	}

	public void setLargePhoto(byte[] largePhoto) {
		this.largePhoto = largePhoto;
	}

	public String getLargePhotoFileName() {
		return this.largePhotoFileName;
	}

	public void setLargePhotoFileName(String largePhotoFileName) {
		this.largePhotoFileName = largePhotoFileName;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public byte[] getThumbNailPhoto() {
		return this.thumbNailPhoto;
	}

	public void setThumbNailPhoto(byte[] thumbNailPhoto) {
		this.thumbNailPhoto = thumbNailPhoto;
	}

	public String getThumbnailPhotoFileName() {
		return this.thumbnailPhotoFileName;
	}

	public void setThumbnailPhotoFileName(String thumbnailPhotoFileName) {
		this.thumbnailPhotoFileName = thumbnailPhotoFileName;
	}

	public List<ProductProductPhoto> getProductProductPhotos() {
		return this.productProductPhotos;
	}

	public void setProductProductPhotos(List<ProductProductPhoto> productProductPhotos) {
		this.productProductPhotos = productProductPhotos;
	}

	public ProductProductPhoto addProductProductPhoto(ProductProductPhoto productProductPhoto) {
		getProductProductPhotos().add(productProductPhoto);
		productProductPhoto.setProductPhoto(this);

		return productProductPhoto;
	}

	public ProductProductPhoto removeProductProductPhoto(ProductProductPhoto productProductPhoto) {
		getProductProductPhotos().remove(productProductPhoto);
		productProductPhoto.setProductPhoto(null);

		return productProductPhoto;
	}

}