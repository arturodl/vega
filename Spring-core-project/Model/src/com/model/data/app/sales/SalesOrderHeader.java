package com.model.data.app.sales;

import java.io.Serializable;
import javax.persistence.*;

import com.core.app.modelo.Entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SalesOrderHeader database table.
 * 
 */
@Entity(name="SalesOrderHeader")
@Table(name="SalesOrderHeader") //, schema="Sales")
@Access(AccessType.FIELD)
public class SalesOrderHeader extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SalesOrderID")
	@Basic(optional=false)
	private int salesOrderID;
	
	@Column(name="SalesOrderID", insertable=false, updatable=false)
	@Basic(optional=false)
	private int id;

	@Column(name="AccountNumber")
	private String accountNumber;

	@Column(name="BillToAddressID")
	private int billToAddressID;

	@Column(name="Comment")
	private String comment;

	@Column(name="CreditCardApprovalCode")
	private String creditCardApprovalCode;

	@Column(name="CreditCardID")
	private int creditCardID;

	@Column(name="CurrencyRateID")
	private int currencyRateID;

	@Column(name="CustomerID")
	private int customerID;

	@Column(name="DueDate")
	private Timestamp dueDate;

	@Column(name="Freight")
	private BigDecimal freight;

	@Column(name="ModifiedDate")
	private Timestamp modifiedDate;

	@Column(name="OnlineOrderFlag")
	private boolean onlineOrderFlag;

	@Column(name="OrderDate")
	private Timestamp orderDate;

	@Column(name="PurchaseOrderNumber")
	private String purchaseOrderNumber;

	@Column(name="RevisionNumber")
	private short revisionNumber;

	private String rowguid;

	@Column(name="SalesOrderNumber")
	private String salesOrderNumber;

	@Column(name="SalesPersonID")
	private int salesPersonID;

	@Column(name="ShipDate")
	private Timestamp shipDate;

	@Column(name="ShipMethodID")
	private int shipMethodID;

	@Column(name="ShipToAddressID")
	private int shipToAddressID;

	@Column(name="Status")
	private short status;

	@Column(name="SubTotal")
	private BigDecimal subTotal;

	@Column(name="TaxAmt")
	private BigDecimal taxAmt;

	@Column(name="TerritoryID")
	private int territoryID;

	@Column(name="TotalDue")
	private BigDecimal totalDue;

	//bi-directional many-to-one association to SalesOrderDetail
	@OneToMany(mappedBy="salesOrderHeader", fetch=FetchType.LAZY)
	private List<SalesOrderDetail> salesOrderDetails;

	//bi-directional many-to-one association to SalesOrderHeaderSalesReason
	@OneToMany(mappedBy="salesOrderHeader", fetch=FetchType.LAZY)
	private List<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasons;

	public SalesOrderHeader() {
	}

	public int getSalesOrderID() {
		return this.salesOrderID;
	}

	public void setSalesOrderID(int salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBillToAddressID() {
		return this.billToAddressID;
	}

	public void setBillToAddressID(int billToAddressID) {
		this.billToAddressID = billToAddressID;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreditCardApprovalCode() {
		return this.creditCardApprovalCode;
	}

	public void setCreditCardApprovalCode(String creditCardApprovalCode) {
		this.creditCardApprovalCode = creditCardApprovalCode;
	}

	public int getCreditCardID() {
		return this.creditCardID;
	}

	public void setCreditCardID(int creditCardID) {
		this.creditCardID = creditCardID;
	}

	public int getCurrencyRateID() {
		return this.currencyRateID;
	}

	public void setCurrencyRateID(int currencyRateID) {
		this.currencyRateID = currencyRateID;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getFreight() {
		return this.freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean getOnlineOrderFlag() {
		return this.onlineOrderFlag;
	}

	public void setOnlineOrderFlag(boolean onlineOrderFlag) {
		this.onlineOrderFlag = onlineOrderFlag;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getPurchaseOrderNumber() {
		return this.purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public short getRevisionNumber() {
		return this.revisionNumber;
	}

	public void setRevisionNumber(short revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public String getRowguid() {
		return this.rowguid;
	}

	public void setRowguid(String rowguid) {
		this.rowguid = rowguid;
	}

	public String getSalesOrderNumber() {
		return this.salesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber) {
		this.salesOrderNumber = salesOrderNumber;
	}

	public int getSalesPersonID() {
		return this.salesPersonID;
	}

	public void setSalesPersonID(int salesPersonID) {
		this.salesPersonID = salesPersonID;
	}

	public Timestamp getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Timestamp shipDate) {
		this.shipDate = shipDate;
	}

	public int getShipMethodID() {
		return this.shipMethodID;
	}

	public void setShipMethodID(int shipMethodID) {
		this.shipMethodID = shipMethodID;
	}

	public int getShipToAddressID() {
		return this.shipToAddressID;
	}

	public void setShipToAddressID(int shipToAddressID) {
		this.shipToAddressID = shipToAddressID;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTaxAmt() {
		return this.taxAmt;
	}

	public void setTaxAmt(BigDecimal taxAmt) {
		this.taxAmt = taxAmt;
	}

	public int getTerritoryID() {
		return this.territoryID;
	}

	public void setTerritoryID(int territoryID) {
		this.territoryID = territoryID;
	}

	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	public List<SalesOrderDetail> getSalesOrderDetails() {
		return this.salesOrderDetails;
	}

	public void setSalesOrderDetails(List<SalesOrderDetail> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	public SalesOrderDetail addSalesOrderDetail(SalesOrderDetail salesOrderDetail) {
		getSalesOrderDetails().add(salesOrderDetail);
		salesOrderDetail.setSalesOrderHeader(this);

		return salesOrderDetail;
	}

	public SalesOrderDetail removeSalesOrderDetail(SalesOrderDetail salesOrderDetail) {
		getSalesOrderDetails().remove(salesOrderDetail);
		salesOrderDetail.setSalesOrderHeader(null);

		return salesOrderDetail;
	}

	public List<SalesOrderHeaderSalesReason> getSalesOrderHeaderSalesReasons() {
		return this.salesOrderHeaderSalesReasons;
	}

	public void setSalesOrderHeaderSalesReasons(List<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasons) {
		this.salesOrderHeaderSalesReasons = salesOrderHeaderSalesReasons;
	}

	public SalesOrderHeaderSalesReason addSalesOrderHeaderSalesReason(SalesOrderHeaderSalesReason salesOrderHeaderSalesReason) {
		getSalesOrderHeaderSalesReasons().add(salesOrderHeaderSalesReason);
		salesOrderHeaderSalesReason.setSalesOrderHeader(this);

		return salesOrderHeaderSalesReason;
	}

	public SalesOrderHeaderSalesReason removeSalesOrderHeaderSalesReason(SalesOrderHeaderSalesReason salesOrderHeaderSalesReason) {
		getSalesOrderHeaderSalesReasons().remove(salesOrderHeaderSalesReason);
		salesOrderHeaderSalesReason.setSalesOrderHeader(null);

		return salesOrderHeaderSalesReason;
	}

}