package com.model.data.app.production;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Product database table.
 * 
 */
@Entity(name="Product")
@Table(name="Product") //, schema="Production")
@Access(AccessType.FIELD)
public class Product extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductID")
	@Basic(optional=false)
	private int productID;
	
	@Column(name="ProductID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="Class")
	private String class_;

	@Column(name="Color")
	private String color;

	@Column(name="DaysToManufacture")
	private int daysToManufacture;

	@Column(name="DiscontinuedDate")
	private Timestamp discontinuedDate;

	@Column(name="FinishedGoodsFlag")
	private boolean finishedGoodsFlag;

	@Column(name="ListPrice")
	private BigDecimal listPrice;

	@Column(name="MakeFlag")
	private boolean makeFlag;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="Name")
	private String name;

	@Column(name="ProductLine")
	private String productLine;

	@Column(name="ProductNumber")
	private String productNumber;

	@Column(name="ReorderPoint")
	private short reorderPoint;

	private String rowguid;

	@Column(name="SafetyStockLevel")
	private short safetyStockLevel;

	@Column(name="SellEndDate")
	private Timestamp sellEndDate;

	@Column(name="SellStartDate")
	private Timestamp sellStartDate;

	@Column(name="Size")
	private String size;

	@Column(name="StandardCost")
	private BigDecimal standardCost;

	@Column(name="Style")
	private String style;

	@Column(name="Weight")
	private BigDecimal weight;

	//bi-directional many-to-one association to BillOfMaterial
	@OneToMany(mappedBy="product1", fetch=FetchType.LAZY)
	private List<BillOfMaterials> billOfMaterials1;

	//bi-directional many-to-one association to BillOfMaterial
	@OneToMany(mappedBy="product2", fetch=FetchType.LAZY)
	private List<BillOfMaterials> billOfMaterials2;

	//bi-directional many-to-one association to ProductModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductModelID")
	private ProductModel productModel;

	//bi-directional many-to-one association to ProductSubcategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProductSubcategoryID")
	private ProductSubcategory productSubcategory;

	//bi-directional many-to-one association to UnitMeasure
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SizeUnitMeasureCode")
	private UnitMeasure unitMeasure1;

	//bi-directional many-to-one association to UnitMeasure
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WeightUnitMeasureCode")
	private UnitMeasure unitMeasure2;

	//bi-directional many-to-one association to ProductCostHistory
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<ProductCostHistory> productCostHistories;

	//bi-directional many-to-one association to ProductDocument
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<ProductDocument> productDocuments;

	//bi-directional many-to-one association to ProductInventory
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<ProductInventory> productInventories;

	//bi-directional many-to-one association to ProductListPriceHistory
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<ProductListPriceHistory> productListPriceHistories;

	//bi-directional many-to-one association to ProductProductPhoto
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY)
	private List<ProductProductPhoto> productProductPhotos;

	//bi-directional many-to-one association to ProductReview
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<ProductReview> productReviews;

	//bi-directional many-to-one association to TransactionHistory
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<TransactionHistory> transactionHistories;

	//bi-directional many-to-one association to WorkOrder
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
	private List<WorkOrder> workOrders;

	public Product() {
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDaysToManufacture() {
		return this.daysToManufacture;
	}

	public void setDaysToManufacture(int daysToManufacture) {
		this.daysToManufacture = daysToManufacture;
	}

	public Timestamp getDiscontinuedDate() {
		return this.discontinuedDate;
	}

	public void setDiscontinuedDate(Timestamp discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public boolean getFinishedGoodsFlag() {
		return this.finishedGoodsFlag;
	}

	public void setFinishedGoodsFlag(boolean finishedGoodsFlag) {
		this.finishedGoodsFlag = finishedGoodsFlag;
	}

	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public boolean getMakeFlag() {
		return this.makeFlag;
	}

	public void setMakeFlag(boolean makeFlag) {
		this.makeFlag = makeFlag;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public short getReorderPoint() {
		return this.reorderPoint;
	}

	public void setReorderPoint(short reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public short getSafetyStockLevel() {
		return this.safetyStockLevel;
	}

	public void setSafetyStockLevel(short safetyStockLevel) {
		this.safetyStockLevel = safetyStockLevel;
	}

	public Timestamp getSellEndDate() {
		return this.sellEndDate;
	}

	public void setSellEndDate(Timestamp sellEndDate) {
		this.sellEndDate = sellEndDate;
	}

	public Timestamp getSellStartDate() {
		return this.sellStartDate;
	}

	public void setSellStartDate(Timestamp sellStartDate) {
		this.sellStartDate = sellStartDate;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getStandardCost() {
		return this.standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public List<BillOfMaterials> getBillOfMaterials1() {
		return this.billOfMaterials1;
	}

	public void setBillOfMaterials1(List<BillOfMaterials> billOfMaterials1) {
		this.billOfMaterials1 = billOfMaterials1;
	}

	public BillOfMaterials addBillOfMaterials1(BillOfMaterials billOfMaterials1) {
		getBillOfMaterials1().add(billOfMaterials1);
		billOfMaterials1.setProduct1(this);

		return billOfMaterials1;
	}

	public BillOfMaterials removeBillOfMaterials1(BillOfMaterials billOfMaterials1) {
		getBillOfMaterials1().remove(billOfMaterials1);
		billOfMaterials1.setProduct1(null);

		return billOfMaterials1;
	}

	public List<BillOfMaterials> getBillOfMaterials2() {
		return this.billOfMaterials2;
	}

	public void setBillOfMaterials2(List<BillOfMaterials> billOfMaterials2) {
		this.billOfMaterials2 = billOfMaterials2;
	}

	public BillOfMaterials addBillOfMaterials2(BillOfMaterials billOfMaterials2) {
		getBillOfMaterials2().add(billOfMaterials2);
		billOfMaterials2.setProduct2(this);

		return billOfMaterials2;
	}

	public BillOfMaterials removeBillOfMaterials2(BillOfMaterials billOfMaterials2) {
		getBillOfMaterials2().remove(billOfMaterials2);
		billOfMaterials2.setProduct2(null);

		return billOfMaterials2;
	}

	public ProductModel getProductModel() {
		return this.productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public ProductSubcategory getProductSubcategory() {
		return this.productSubcategory;
	}

	public void setProductSubcategory(ProductSubcategory productSubcategory) {
		this.productSubcategory = productSubcategory;
	}

	public UnitMeasure getUnitMeasure1() {
		return this.unitMeasure1;
	}

	public void setUnitMeasure1(UnitMeasure unitMeasure1) {
		this.unitMeasure1 = unitMeasure1;
	}

	public UnitMeasure getUnitMeasure2() {
		return this.unitMeasure2;
	}

	public void setUnitMeasure2(UnitMeasure unitMeasure2) {
		this.unitMeasure2 = unitMeasure2;
	}

	public List<ProductCostHistory> getProductCostHistories() {
		return this.productCostHistories;
	}

	public void setProductCostHistories(List<ProductCostHistory> productCostHistories) {
		this.productCostHistories = productCostHistories;
	}

	public ProductCostHistory addProductCostHistory(ProductCostHistory productCostHistory) {
		getProductCostHistories().add(productCostHistory);
		productCostHistory.setProduct(this);

		return productCostHistory;
	}

	public ProductCostHistory removeProductCostHistory(ProductCostHistory productCostHistory) {
		getProductCostHistories().remove(productCostHistory);
		productCostHistory.setProduct(null);

		return productCostHistory;
	}

	public List<ProductDocument> getProductDocuments() {
		return this.productDocuments;
	}

	public void setProductDocuments(List<ProductDocument> productDocuments) {
		this.productDocuments = productDocuments;
	}

	public ProductDocument addProductDocument(ProductDocument productDocument) {
		getProductDocuments().add(productDocument);
		productDocument.setProduct(this);

		return productDocument;
	}

	public ProductDocument removeProductDocument(ProductDocument productDocument) {
		getProductDocuments().remove(productDocument);
		productDocument.setProduct(null);

		return productDocument;
	}

	public List<ProductInventory> getProductInventories() {
		return this.productInventories;
	}

	public void setProductInventories(List<ProductInventory> productInventories) {
		this.productInventories = productInventories;
	}

	public ProductInventory addProductInventory(ProductInventory productInventory) {
		getProductInventories().add(productInventory);
		productInventory.setProduct(this);

		return productInventory;
	}

	public ProductInventory removeProductInventory(ProductInventory productInventory) {
		getProductInventories().remove(productInventory);
		productInventory.setProduct(null);

		return productInventory;
	}

	public List<ProductListPriceHistory> getProductListPriceHistories() {
		return this.productListPriceHistories;
	}

	public void setProductListPriceHistories(List<ProductListPriceHistory> productListPriceHistories) {
		this.productListPriceHistories = productListPriceHistories;
	}

	public ProductListPriceHistory addProductListPriceHistory(ProductListPriceHistory productListPriceHistory) {
		getProductListPriceHistories().add(productListPriceHistory);
		productListPriceHistory.setProduct(this);

		return productListPriceHistory;
	}

	public ProductListPriceHistory removeProductListPriceHistory(ProductListPriceHistory productListPriceHistory) {
		getProductListPriceHistories().remove(productListPriceHistory);
		productListPriceHistory.setProduct(null);

		return productListPriceHistory;
	}

	public List<ProductProductPhoto> getProductProductPhotos() {
		return this.productProductPhotos;
	}

	public void setProductProductPhotos(List<ProductProductPhoto> productProductPhotos) {
		this.productProductPhotos = productProductPhotos;
	}

	public ProductProductPhoto addProductProductPhoto(ProductProductPhoto productProductPhoto) {
		getProductProductPhotos().add(productProductPhoto);
		productProductPhoto.setProduct(this);

		return productProductPhoto;
	}

	public ProductProductPhoto removeProductProductPhoto(ProductProductPhoto productProductPhoto) {
		getProductProductPhotos().remove(productProductPhoto);
		productProductPhoto.setProduct(null);

		return productProductPhoto;
	}

	public List<ProductReview> getProductReviews() {
		return this.productReviews;
	}

	public void setProductReviews(List<ProductReview> productReviews) {
		this.productReviews = productReviews;
	}

	public ProductReview addProductReview(ProductReview productReview) {
		getProductReviews().add(productReview);
		productReview.setProduct(this);

		return productReview;
	}

	public ProductReview removeProductReview(ProductReview productReview) {
		getProductReviews().remove(productReview);
		productReview.setProduct(null);

		return productReview;
	}

	public List<TransactionHistory> getTransactionHistories() {
		return this.transactionHistories;
	}

	public void setTransactionHistories(List<TransactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}

	public TransactionHistory addTransactionHistory(TransactionHistory transactionHistory) {
		getTransactionHistories().add(transactionHistory);
		transactionHistory.setProduct(this);

		return transactionHistory;
	}

	public TransactionHistory removeTransactionHistory(TransactionHistory transactionHistory) {
		getTransactionHistories().remove(transactionHistory);
		transactionHistory.setProduct(null);

		return transactionHistory;
	}

	public List<WorkOrder> getWorkOrders() {
		return this.workOrders;
	}

	public void setWorkOrders(List<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}

	public WorkOrder addWorkOrder(WorkOrder workOrder) {
		getWorkOrders().add(workOrder);
		workOrder.setProduct(this);

		return workOrder;
	}

	public WorkOrder removeWorkOrder(WorkOrder workOrder) {
		getWorkOrders().remove(workOrder);
		workOrder.setProduct(null);

		return workOrder;
	}

}