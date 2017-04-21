package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Document database table.
 * 
 */
@Entity(name="Document")
@Table(name="Document", schema="Production")
@Access(AccessType.FIELD)
public class Document extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DocumentNode")
	private String documentNode;

	@Column(name="ChangeNumber")
	private int changeNumber;

	@Column(name="Document")
	private byte[] document;

	@Column(name="DocumentLevel")
	private short documentLevel;

	@Column(name="DocumentSummary")
	private String documentSummary;

	@Column(name="FileExtension")
	private String fileExtension;

	@Column(name="FileName")
	private String fileName;

	@Column(name="FolderFlag")
	private boolean folderFlag;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Owner")
	private int owner;

	@Column(name="Revision")
	private String revision;

	private String rowguid;

	@Column(name="Status")
	private short status;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-one association to ProductDocument
	@OneToMany(mappedBy="document", fetch=FetchType.LAZY)
	private List<ProductDocument> productDocuments;

	public Document() {
	}

	public String getDocumentNode() {
		return this.documentNode;
	}

	public void setDocumentNode(String documentNode) {
		this.documentNode = documentNode;
	}

	public int getChangeNumber() {
		return this.changeNumber;
	}

	public void setChangeNumber(int changeNumber) {
		this.changeNumber = changeNumber;
	}

	public byte[] getDocument() {
		return this.document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public short getDocumentLevel() {
		return this.documentLevel;
	}

	public void setDocumentLevel(short documentLevel) {
		this.documentLevel = documentLevel;
	}

	public String getDocumentSummary() {
		return this.documentSummary;
	}

	public void setDocumentSummary(String documentSummary) {
		this.documentSummary = documentSummary;
	}

	public String getFileExtension() {
		return this.fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean getFolderFlag() {
		return this.folderFlag;
	}

	public void setFolderFlag(boolean folderFlag) {
		this.folderFlag = folderFlag;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getOwner() {
		return this.owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getRevision() {
		return this.revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ProductDocument> getProductDocuments() {
		return this.productDocuments;
	}

	public void setProductDocuments(List<ProductDocument> productDocuments) {
		this.productDocuments = productDocuments;
	}

	public ProductDocument addProductDocument(ProductDocument productDocument) {
		getProductDocuments().add(productDocument);
		productDocument.setDocument(this);

		return productDocument;
	}

	public ProductDocument removeProductDocument(ProductDocument productDocument) {
		getProductDocuments().remove(productDocument);
		productDocument.setDocument(null);

		return productDocument;
	}

}