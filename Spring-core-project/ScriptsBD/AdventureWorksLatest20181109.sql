-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: adventureworks2014
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for Address records.',
  `AddressLine1` varchar(60) CHARACTER SET utf8mb4 NOT NULL COMMENT 'First street address line.',
  `AddressLine2` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Second street address line.',
  `City` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the city.',
  `StateProvinceID` int(11) NOT NULL COMMENT 'Unique identification number for the state or province. Foreign key to StateProvince table.',
  `PostalCode` varchar(15) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Postal code for the street address.',
  `SpatialLocation` geometry DEFAULT NULL COMMENT 'Latitude and longitude of this address.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`AddressID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_Address_rowguid` (`rowguid`),
  UNIQUE KEY `IX_Address_AddressLine1_AddressLine2_City_StateProvinceID_Post1` (`AddressLine1`,`AddressLine2`,`City`,`StateProvinceID`,`PostalCode`),
  KEY `IX_Address_StateProvinceID` (`StateProvinceID`),
  CONSTRAINT `FK_Address_StateProvince_StateProvinceID` FOREIGN KEY (`StateProvinceID`) REFERENCES `stateprovince` (`StateProvinceID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Street address information for customers, employees, and vendors.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresstype`
--

DROP TABLE IF EXISTS `addresstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresstype` (
  `AddressTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for AddressType records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Address type description. For example, Billing, Home, or Shipping.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`AddressTypeID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_AddressType_rowguid` (`rowguid`),
  UNIQUE KEY `AK_AddressType_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Types of addresses stored in the Address table. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresstype`
--

LOCK TABLES `addresstype` WRITE;
/*!40000 ALTER TABLE `addresstype` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `awbuildversion`
--

DROP TABLE IF EXISTS `awbuildversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `awbuildversion` (
  `SystemInformationID` tinyint(3) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary key for AWBuildVersion records.',
  `Database Version` varchar(25) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Version number of the database in 9.yy.mm.dd.00 format.',
  `VersionDate` datetime(6) NOT NULL COMMENT 'Date and time the record was last updated.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SystemInformationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Current version number of the AdventureWorks 2014 sample database. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `awbuildversion`
--

LOCK TABLES `awbuildversion` WRITE;
/*!40000 ALTER TABLE `awbuildversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `awbuildversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billofmaterials`
--

DROP TABLE IF EXISTS `billofmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billofmaterials` (
  `BillOfMaterialsID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for BillOfMaterials records.',
  `ProductAssemblyID` int(11) DEFAULT NULL COMMENT 'Parent product identification number. Foreign key to Product.ProductID.',
  `ComponentID` int(11) NOT NULL COMMENT 'Component identification number. Foreign key to Product.ProductID.',
  `StartDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date the component started being used in the assembly item.',
  `EndDate` datetime(6) DEFAULT NULL COMMENT 'Date the component stopped being used in the assembly item.',
  `UnitMeasureCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Standard code identifying the unit of measure for the quantity.',
  `BOMLevel` smallint(6) NOT NULL COMMENT 'Indicates the depth the component is from its parent (AssemblyID).',
  `PerAssemblyQty` decimal(8,2) NOT NULL DEFAULT '1.00' COMMENT 'Quantity of the component needed to create the assembly.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BillOfMaterialsID`),
  UNIQUE KEY `AK_BillOfMaterials_ProductAssemblyID_ComponentID_StartDate` (`ProductAssemblyID`,`ComponentID`,`StartDate`),
  KEY `IX_BillOfMaterials_UnitMeasureCode` (`UnitMeasureCode`),
  KEY `FK_BillOfMaterials_Product_ComponentID` (`ComponentID`),
  CONSTRAINT `FK_BillOfMaterials_Product_ComponentID` FOREIGN KEY (`ComponentID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BillOfMaterials_Product_ProductAssemblyID` FOREIGN KEY (`ProductAssemblyID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BillOfMaterials_UnitMeasure_UnitMeasureCode` FOREIGN KEY (`UnitMeasureCode`) REFERENCES `unitmeasure` (`UnitMeasureCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Items required to make bicycles and bicycle subassemblies. It identifies the heirarchical relationship between a parent product and its components.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billofmaterials`
--

LOCK TABLES `billofmaterials` WRITE;
/*!40000 ALTER TABLE `billofmaterials` DISABLE KEYS */;
/*!40000 ALTER TABLE `billofmaterials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businessentity`
--

DROP TABLE IF EXISTS `businessentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businessentity` (
  `BusinessEntityID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for all customers, vendors, and employees.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_BusinessEntity_rowguid` (`rowguid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Source of the ID that connects vendors, customers, and employees with address and contact information.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businessentity`
--

LOCK TABLES `businessentity` WRITE;
/*!40000 ALTER TABLE `businessentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `businessentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businessentityaddress`
--

DROP TABLE IF EXISTS `businessentityaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businessentityaddress` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to BusinessEntity.BusinessEntityID.',
  `AddressID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Address.AddressID.',
  `AddressTypeID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to AddressType.AddressTypeID.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`AddressID`,`AddressTypeID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_BusinessEntityAddress_rowguid` (`rowguid`),
  KEY `IX_BusinessEntityAddress_AddressID` (`AddressID`),
  KEY `IX_BusinessEntityAddress_AddressTypeID` (`AddressTypeID`),
  CONSTRAINT `FK_BusinessEntityAddress_AddressType_AddressTypeID` FOREIGN KEY (`AddressTypeID`) REFERENCES `addresstype` (`AddressTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BusinessEntityAddress_Address_AddressID` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BusinessEntityAddress_BusinessEntity_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `businessentity` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping customers, vendors, and employees to their addresses.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businessentityaddress`
--

LOCK TABLES `businessentityaddress` WRITE;
/*!40000 ALTER TABLE `businessentityaddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `businessentityaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businessentitycontact`
--

DROP TABLE IF EXISTS `businessentitycontact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businessentitycontact` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to BusinessEntity.BusinessEntityID.',
  `PersonID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Person.BusinessEntityID.',
  `ContactTypeID` int(11) NOT NULL COMMENT 'Primary key.  Foreign key to ContactType.ContactTypeID.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`PersonID`,`ContactTypeID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_BusinessEntityContact_rowguid` (`rowguid`),
  KEY `IX_BusinessEntityContact_PersonID` (`PersonID`),
  KEY `IX_BusinessEntityContact_ContactTypeID` (`ContactTypeID`),
  CONSTRAINT `FK_BusinessEntityContact_BusinessEntity_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `businessentity` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BusinessEntityContact_ContactType_ContactTypeID` FOREIGN KEY (`ContactTypeID`) REFERENCES `contacttype` (`ContactTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BusinessEntityContact_Person_PersonID` FOREIGN KEY (`PersonID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping stores, vendors, and employees to people';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businessentitycontact`
--

LOCK TABLES `businessentitycontact` WRITE;
/*!40000 ALTER TABLE `businessentitycontact` DISABLE KEYS */;
/*!40000 ALTER TABLE `businessentitycontact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacttype`
--

DROP TABLE IF EXISTS `contacttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacttype` (
  `ContactTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ContactType records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Contact type description.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ContactTypeID`),
  UNIQUE KEY `AK_ContactType_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Lookup table containing the types of business entity contacts.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacttype`
--

LOCK TABLES `contacttype` WRITE;
/*!40000 ALTER TABLE `contacttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countryregion`
--

DROP TABLE IF EXISTS `countryregion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countryregion` (
  `CountryRegionCode` varchar(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ISO standard code for countries and regions.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Country or region name.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CountryRegionCode`),
  UNIQUE KEY `AK_CountryRegion_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Lookup table containing the ISO standard codes for countries and regions.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countryregion`
--

LOCK TABLES `countryregion` WRITE;
/*!40000 ALTER TABLE `countryregion` DISABLE KEYS */;
/*!40000 ALTER TABLE `countryregion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countryregioncurrency`
--

DROP TABLE IF EXISTS `countryregioncurrency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countryregioncurrency` (
  `CountryRegionCode` varchar(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.',
  `CurrencyCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ISO standard currency code. Foreign key to Currency.CurrencyCode.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CountryRegionCode`,`CurrencyCode`),
  KEY `IX_CountryRegionCurrency_CurrencyCode` (`CurrencyCode`),
  CONSTRAINT `FK_CountryRegionCurrency_CountryRegion_CountryRegionCode` FOREIGN KEY (`CountryRegionCode`) REFERENCES `countryregion` (`CountryRegionCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CountryRegionCurrency_Currency_CurrencyCode` FOREIGN KEY (`CurrencyCode`) REFERENCES `currency` (`CurrencyCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping ISO currency codes to a country or region.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countryregioncurrency`
--

LOCK TABLES `countryregioncurrency` WRITE;
/*!40000 ALTER TABLE `countryregioncurrency` DISABLE KEYS */;
/*!40000 ALTER TABLE `countryregioncurrency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `CreditCardID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for CreditCard records.',
  `CardType` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Credit card name.',
  `CardNumber` varchar(25) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Credit card number.',
  `ExpMonth` tinyint(3) unsigned NOT NULL COMMENT 'Credit card expiration month.',
  `ExpYear` smallint(6) NOT NULL COMMENT 'Credit card expiration year.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CreditCardID`),
  UNIQUE KEY `AK_CreditCard_CardNumber` (`CardNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Customer credit card information.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `culture`
--

DROP TABLE IF EXISTS `culture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `culture` (
  `CultureID` char(6) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Primary key for Culture records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Culture description.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CultureID`),
  UNIQUE KEY `AK_Culture_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Lookup table containing the languages in which some AdventureWorks data is stored.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `culture`
--

LOCK TABLES `culture` WRITE;
/*!40000 ALTER TABLE `culture` DISABLE KEYS */;
/*!40000 ALTER TABLE `culture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `CurrencyCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'The ISO code for the Currency.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Currency name.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CurrencyCode`),
  UNIQUE KEY `AK_Currency_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Lookup table containing standard ISO currencies.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currencyrate`
--

DROP TABLE IF EXISTS `currencyrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currencyrate` (
  `CurrencyRateID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for CurrencyRate records.',
  `CurrencyRateDate` datetime(6) NOT NULL COMMENT 'Date and time the exchange rate was obtained.',
  `FromCurrencyCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Exchange rate was converted from this currency code.',
  `ToCurrencyCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Exchange rate was converted to this currency code.',
  `AverageRate` decimal(19,4) NOT NULL COMMENT 'Average exchange rate for the day.',
  `EndOfDayRate` decimal(19,4) NOT NULL COMMENT 'Final exchange rate for the day.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CurrencyRateID`),
  UNIQUE KEY `AK_CurrencyRate_CurrencyRateDate_FromCurrencyCode_ToCurrencyCode` (`CurrencyRateDate`,`FromCurrencyCode`,`ToCurrencyCode`),
  KEY `FK_CurrencyRate_Currency_FromCurrencyCode` (`FromCurrencyCode`),
  KEY `FK_CurrencyRate_Currency_ToCurrencyCode` (`ToCurrencyCode`),
  CONSTRAINT `FK_CurrencyRate_Currency_FromCurrencyCode` FOREIGN KEY (`FromCurrencyCode`) REFERENCES `currency` (`CurrencyCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CurrencyRate_Currency_ToCurrencyCode` FOREIGN KEY (`ToCurrencyCode`) REFERENCES `currency` (`CurrencyCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Currency exchange rates.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currencyrate`
--

LOCK TABLES `currencyrate` WRITE;
/*!40000 ALTER TABLE `currencyrate` DISABLE KEYS */;
/*!40000 ALTER TABLE `currencyrate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `PersonID` int(11) DEFAULT NULL COMMENT 'Foreign key to Person.BusinessEntityID',
  `StoreID` int(11) DEFAULT NULL COMMENT 'Foreign key to Store.BusinessEntityID',
  `TerritoryID` int(11) DEFAULT NULL COMMENT 'ID of the territory in which the customer is located. Foreign key to SalesTerritory.SalesTerritoryID.',
  `AccountNumber` varchar(10) NOT NULL COMMENT 'Unique number identifying the customer assigned by the accounting system.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_Customer_rowguid` (`rowguid`),
  UNIQUE KEY `AK_Customer_AccountNumber` (`AccountNumber`),
  KEY `IX_Customer_TerritoryID` (`TerritoryID`),
  KEY `FK_Customer_Person_PersonID` (`PersonID`),
  KEY `FK_Customer_Store_StoreID` (`StoreID`),
  CONSTRAINT `FK_Customer_Person_PersonID` FOREIGN KEY (`PersonID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Customer_SalesTerritory_TerritoryID` FOREIGN KEY (`TerritoryID`) REFERENCES `salesterritory` (`TerritoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Customer_Store_StoreID` FOREIGN KEY (`StoreID`) REFERENCES `store` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Current customer information. Also see the Person and Store tables.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databaselog`
--

DROP TABLE IF EXISTS `databaselog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databaselog` (
  `DatabaseLogID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for DatabaseLog records.',
  `PostTime` datetime(6) NOT NULL COMMENT 'The date and time the DDL change occurred.',
  `DatabaseUser` varchar(160) NOT NULL COMMENT 'The user who implemented the DDL change.',
  `Event` varchar(160) NOT NULL COMMENT 'The type of DDL statement that was executed.',
  `Schema` varchar(160) DEFAULT NULL COMMENT 'The schema to which the changed object belongs.',
  `Object` varchar(160) DEFAULT NULL COMMENT 'The object that was changed by the DDL statment.',
  `TSQL` longtext CHARACTER SET utf8mb4 NOT NULL COMMENT 'The exact Transact-SQL statement that was executed.',
  `XmlEvent` text NOT NULL COMMENT 'The raw XML data generated by database trigger.',
  PRIMARY KEY (`DatabaseLogID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Audit table tracking all DDL changes made to the AdventureWorks database. Data is captured by the database trigger ddlDatabaseTriggerLog.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databaselog`
--

LOCK TABLES `databaselog` WRITE;
/*!40000 ALTER TABLE `databaselog` DISABLE KEYS */;
/*!40000 ALTER TABLE `databaselog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `DepartmentID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for Department records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the department.',
  `GroupName` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the group to which the department belongs.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`DepartmentID`),
  UNIQUE KEY `AK_Department_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Lookup table containing the departments within the Adventure Works Cycles company.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `DocumentNode` varchar(255) NOT NULL COMMENT 'Primary key for Document records.',
  `DocumentLevel` smallint(6) DEFAULT NULL COMMENT 'Depth in the document hierarchy.',
  `Title` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Title of the document.',
  `Owner` int(11) NOT NULL COMMENT 'Employee who controls the document.  Foreign key to Employee.BusinessEntityID',
  `FolderFlag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 = This is a folder, 1 = This is a document.',
  `FileName` varchar(400) CHARACTER SET utf8mb4 NOT NULL COMMENT 'File name of the document',
  `FileExtension` varchar(8) CHARACTER SET utf8mb4 NOT NULL COMMENT 'File extension indicating the document type. For example, .doc or .txt.',
  `Revision` char(5) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Revision number of the document. ',
  `ChangeNumber` int(11) NOT NULL DEFAULT '0' COMMENT 'Engineering change approval number.',
  `Status` tinyint(3) unsigned NOT NULL COMMENT '1 = Pending approval, 2 = Approved, 3 = Obsolete',
  `DocumentSummary` longtext CHARACTER SET utf8mb4 COMMENT 'Document abstract.',
  `Document` longblob COMMENT 'Complete document.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Required for FileStream.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`DocumentNode`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `UQ__Document__F73921F763026E5E` (`rowguid`),
  UNIQUE KEY `AK_Document_rowguid` (`rowguid`),
  UNIQUE KEY `AK_Document_DocumentLevel_DocumentNode` (`DocumentLevel`,`DocumentNode`),
  KEY `IX_Document_FileName_Revision` (`FileName`(255),`Revision`),
  KEY `FK_Document_Employee_Owner` (`Owner`),
  CONSTRAINT `FK_Document_Employee_Owner` FOREIGN KEY (`Owner`) REFERENCES `employee` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product maintenance documents.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailaddress`
--

DROP TABLE IF EXISTS `emailaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailaddress` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID',
  `EmailAddressID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key. ID of this email address.',
  `EmailAddress` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'E-mail address for the person.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`EmailAddressID`,`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  KEY `IX_EmailAddress_EmailAddress` (`EmailAddress`),
  KEY `FK_EmailAddress_Person_BusinessEntityID` (`BusinessEntityID`),
  CONSTRAINT `FK_EmailAddress_Person_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Where to send a person email.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailaddress`
--

LOCK TABLES `emailaddress` WRITE;
/*!40000 ALTER TABLE `emailaddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key for Employee records.  Foreign key to BusinessEntity.BusinessEntityID.',
  `NationalIDNumber` varchar(15) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Unique national identification number such as a social security number.',
  `LoginID` varchar(256) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Network login.',
  `OrganizationNode` varchar(255) DEFAULT NULL COMMENT 'Where the employee is located in corporate hierarchy.',
  `OrganizationLevel` smallint(6) DEFAULT NULL COMMENT 'The depth of the employee in the corporate hierarchy.',
  `JobTitle` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Work title such as Buyer or Sales Representative.',
  `BirthDate` date NOT NULL COMMENT 'Date of birth.',
  `MaritalStatus` char(1) CHARACTER SET utf8mb4 NOT NULL COMMENT 'M = Married, S = Single',
  `Gender` char(1) CHARACTER SET utf8mb4 NOT NULL COMMENT 'M = Male, F = Female',
  `HireDate` date NOT NULL COMMENT 'Employee hired on this date.',
  `SalariedFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Job classification. 0 = Hourly, not exempt from collective bargaining. 1 = Salaried, exempt from collective bargaining.',
  `VacationHours` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Number of available vacation hours.',
  `SickLeaveHours` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Number of available sick leave hours.',
  `CurrentFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = Inactive, 1 = Active',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_Employee_NationalIDNumber` (`NationalIDNumber`),
  UNIQUE KEY `AK_Employee_rowguid` (`rowguid`),
  UNIQUE KEY `AK_Employee_LoginID` (`LoginID`(255)),
  KEY `IX_Employee_OrganizationNode` (`OrganizationNode`),
  KEY `IX_Employee_OrganizationLevel_OrganizationNode` (`OrganizationLevel`,`OrganizationNode`),
  CONSTRAINT `FK_Employee_Person_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Employee information such as salary, department, and title.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeedepartmenthistory`
--

DROP TABLE IF EXISTS `employeedepartmenthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeedepartmenthistory` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Employee identification number. Foreign key to Employee.BusinessEntityID.',
  `DepartmentID` smallint(6) NOT NULL COMMENT 'Department in which the employee worked including currently. Foreign key to Department.DepartmentID.',
  `ShiftID` tinyint(3) unsigned NOT NULL COMMENT 'Identifies which 8-hour shift the employee works. Foreign key to Shift.Shift.ID.',
  `StartDate` date NOT NULL COMMENT 'Date the employee started work in the department.',
  `EndDate` date DEFAULT NULL COMMENT 'Date the employee left the department. NULL = Current department.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`StartDate`,`DepartmentID`,`ShiftID`),
  KEY `IX_EmployeeDepartmentHistory_DepartmentID` (`DepartmentID`),
  KEY `IX_EmployeeDepartmentHistory_ShiftID` (`ShiftID`),
  CONSTRAINT `FK_EmployeeDepartmentHistory_Department_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EmployeeDepartmentHistory_Employee_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `employee` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EmployeeDepartmentHistory_Shift_ShiftID` FOREIGN KEY (`ShiftID`) REFERENCES `shift` (`ShiftID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Employee department transfers.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeedepartmenthistory`
--

LOCK TABLES `employeedepartmenthistory` WRITE;
/*!40000 ALTER TABLE `employeedepartmenthistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `employeedepartmenthistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeepayhistory`
--

DROP TABLE IF EXISTS `employeepayhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeepayhistory` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Employee identification number. Foreign key to Employee.BusinessEntityID.',
  `RateChangeDate` datetime(6) NOT NULL COMMENT 'Date the change in pay is effective',
  `Rate` decimal(19,4) NOT NULL COMMENT 'Salary hourly rate.',
  `PayFrequency` tinyint(3) unsigned NOT NULL COMMENT '1 = Salary received monthly, 2 = Salary received biweekly',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`RateChangeDate`),
  CONSTRAINT `FK_EmployeePayHistory_Employee_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `employee` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Employee pay history.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeepayhistory`
--

LOCK TABLES `employeepayhistory` WRITE;
/*!40000 ALTER TABLE `employeepayhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `employeepayhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `errorlog`
--

DROP TABLE IF EXISTS `errorlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `errorlog` (
  `ErrorLogID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ErrorLog records.',
  `ErrorTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'The date and time at which the error occurred.',
  `UserName` varchar(160) NOT NULL COMMENT 'The user who executed the batch in which the error occurred.',
  `ErrorNumber` int(11) NOT NULL COMMENT 'The error number of the error that occurred.',
  `ErrorSeverity` int(11) DEFAULT NULL COMMENT 'The severity of the error that occurred.',
  `ErrorState` int(11) DEFAULT NULL COMMENT 'The state number of the error that occurred.',
  `ErrorProcedure` varchar(126) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'The name of the stored procedure or trigger where the error occurred.',
  `ErrorLine` int(11) DEFAULT NULL COMMENT 'The line number at which the error occurred.',
  `ErrorMessage` varchar(4000) CHARACTER SET utf8mb4 NOT NULL COMMENT 'The message text of the error that occurred.',
  PRIMARY KEY (`ErrorLogID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Audit table tracking errors in the the AdventureWorks database that are caught by the CATCH block of a TRY...CATCH construct. Data is inserted by stored procedure dbo.uspLogError when it is executed from inside the CATCH block of a TRY...CATCH construct.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `errorlog`
--

LOCK TABLES `errorlog` WRITE;
/*!40000 ALTER TABLE `errorlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `errorlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `illustration`
--

DROP TABLE IF EXISTS `illustration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `illustration` (
  `IllustrationID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for Illustration records.',
  `Diagram` text COMMENT 'Illustrations used in manufacturing instructions. Stored as XML.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`IllustrationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Bicycle assembly diagrams.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `illustration`
--

LOCK TABLES `illustration` WRITE;
/*!40000 ALTER TABLE `illustration` DISABLE KEYS */;
/*!40000 ALTER TABLE `illustration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobcandidate`
--

DROP TABLE IF EXISTS `jobcandidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobcandidate` (
  `JobCandidateID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for JobCandidate records.',
  `BusinessEntityID` int(11) DEFAULT NULL COMMENT 'Employee identification number if applicant was hired. Foreign key to Employee.BusinessEntityID.',
  `Resume` text COMMENT 'Résumé in XML format.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`JobCandidateID`),
  KEY `IX_JobCandidate_BusinessEntityID` (`BusinessEntityID`),
  CONSTRAINT `FK_JobCandidate_Employee_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `employee` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Résumés submitted to Human Resources by job applicants.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobcandidate`
--

LOCK TABLES `jobcandidate` WRITE;
/*!40000 ALTER TABLE `jobcandidate` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobcandidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `LocationID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for Location records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Location description.',
  `CostRate` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT 'Standard hourly cost of the manufacturing location.',
  `Availability` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT 'Work capacity (in hours) of the manufacturing location.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`LocationID`),
  UNIQUE KEY `AK_Location_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product inventory and manufacturing locations.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password` (
  `BusinessEntityID` int(11) NOT NULL,
  `PasswordHash` varchar(128) NOT NULL COMMENT 'Password for the e-mail account.',
  `PasswordSalt` varchar(10) NOT NULL COMMENT 'Random value concatenated with the password string before the password is hashed.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  CONSTRAINT `FK_Password_Person_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='One way hashed authentication information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key for Person records.',
  `PersonType` char(2) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact',
  `NameStyle` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 = The data in FirstName and LastName are stored in western style (first name, last name) order.  1 = Eastern style (last name, first name) order.',
  `Title` varchar(8) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'A courtesy title. For example, Mr. or Ms.',
  `FirstName` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'First name of the person.',
  `MiddleName` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Middle name or middle initial of the person.',
  `LastName` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Last name of the person.',
  `Suffix` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Surname suffix. For example, Sr. or Jr.',
  `EmailPromotion` int(11) NOT NULL DEFAULT '0' COMMENT '0 = Contact does not wish to receive e-mail promotions, 1 = Contact does wish to receive e-mail promotions from AdventureWorks, 2 = Contact does wish to receive e-mail promotions from AdventureWorks and selected partners. ',
  `AdditionalContactInfo` text COMMENT 'Additional contact information about the person stored in xml format. ',
  `Demographics` text COMMENT 'Personal information such as hobbies, and income collected from online shoppers. Used for sales analysis.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_Person_rowguid` (`rowguid`),
  KEY `IX_Person_LastName_FirstName_MiddleName` (`LastName`,`FirstName`,`MiddleName`),
  KEY `PXML_Person_AddContact` (`AdditionalContactInfo`(255)),
  KEY `PXML_Person_Demographics` (`Demographics`(255)),
  KEY `XMLPATH_Person_Demographics` (`Demographics`(255)),
  KEY `XMLPROPERTY_Person_Demographics` (`Demographics`(255)),
  KEY `XMLVALUE_Person_Demographics` (`Demographics`(255)),
  CONSTRAINT `FK_Person_BusinessEntity_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `businessentity` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Human beings involved with AdventureWorks: employees, customer contacts, and vendor contacts.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personcreditcard`
--

DROP TABLE IF EXISTS `personcreditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personcreditcard` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Business entity identification number. Foreign key to Person.BusinessEntityID.',
  `CreditCardID` int(11) NOT NULL COMMENT 'Credit card identification number. Foreign key to CreditCard.CreditCardID.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`CreditCardID`),
  KEY `FK_PersonCreditCard_CreditCard_CreditCardID` (`CreditCardID`),
  CONSTRAINT `FK_PersonCreditCard_CreditCard_CreditCardID` FOREIGN KEY (`CreditCardID`) REFERENCES `creditcard` (`CreditCardID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PersonCreditCard_Person_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping people to their credit card information in the CreditCard table. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personcreditcard`
--

LOCK TABLES `personcreditcard` WRITE;
/*!40000 ALTER TABLE `personcreditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `personcreditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personphone`
--

DROP TABLE IF EXISTS `personphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personphone` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Business entity identification number. Foreign key to Person.BusinessEntityID.',
  `PhoneNumber` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Telephone number identification number.',
  `PhoneNumberTypeID` int(11) NOT NULL COMMENT 'Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`PhoneNumber`,`PhoneNumberTypeID`),
  KEY `IX_PersonPhone_PhoneNumber` (`PhoneNumber`),
  KEY `FK_PersonPhone_PhoneNumberType_PhoneNumberTypeID` (`PhoneNumberTypeID`),
  CONSTRAINT `FK_PersonPhone_Person_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `person` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PersonPhone_PhoneNumberType_PhoneNumberTypeID` FOREIGN KEY (`PhoneNumberTypeID`) REFERENCES `phonenumbertype` (`PhoneNumberTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Telephone number and type of a person.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personphone`
--

LOCK TABLES `personphone` WRITE;
/*!40000 ALTER TABLE `personphone` DISABLE KEYS */;
/*!40000 ALTER TABLE `personphone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonenumbertype`
--

DROP TABLE IF EXISTS `phonenumbertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phonenumbertype` (
  `PhoneNumberTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for telephone number type records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the telephone number type',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`PhoneNumberTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Type of phone number of a person.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonenumbertype`
--

LOCK TABLES `phonenumbertype` WRITE;
/*!40000 ALTER TABLE `phonenumbertype` DISABLE KEYS */;
/*!40000 ALTER TABLE `phonenumbertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for Product records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the product.',
  `ProductNumber` varchar(25) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Unique product identification number.',
  `MakeFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = Product is purchased, 1 = Product is manufactured in-house.',
  `FinishedGoodsFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = Product is not a salable item. 1 = Product is salable.',
  `Color` varchar(15) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Product color.',
  `SafetyStockLevel` smallint(6) NOT NULL COMMENT 'Minimum inventory quantity. ',
  `ReorderPoint` smallint(6) NOT NULL COMMENT 'Inventory level that triggers a purchase order or work order. ',
  `StandardCost` decimal(19,4) NOT NULL COMMENT 'Standard cost of the product.',
  `ListPrice` decimal(19,4) NOT NULL COMMENT 'Selling price.',
  `Size` varchar(5) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Product size.',
  `SizeUnitMeasureCode` char(3) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Unit of measure for Size column.',
  `WeightUnitMeasureCode` char(3) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Unit of measure for Weight column.',
  `Weight` decimal(8,2) DEFAULT NULL COMMENT 'Product weight.',
  `DaysToManufacture` int(11) NOT NULL COMMENT 'Number of days required to manufacture the product.',
  `ProductLine` char(2) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'R = Road, M = Mountain, T = Touring, S = Standard',
  `Class` char(2) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'H = High, M = Medium, L = Low',
  `Style` char(2) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'W = Womens, M = Mens, U = Universal',
  `ProductSubcategoryID` int(11) DEFAULT NULL COMMENT 'Product is a member of this product subcategory. Foreign key to ProductSubCategory.ProductSubCategoryID. ',
  `ProductModelID` int(11) DEFAULT NULL COMMENT 'Product is a member of this product model. Foreign key to ProductModel.ProductModelID.',
  `SellStartDate` datetime(6) NOT NULL COMMENT 'Date the product was available for sale.',
  `SellEndDate` datetime(6) DEFAULT NULL COMMENT 'Date the product was no longer available for sale.',
  `DiscontinuedDate` datetime(6) DEFAULT NULL COMMENT 'Date the product was discontinued.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_Product_ProductNumber` (`ProductNumber`),
  UNIQUE KEY `AK_Product_Name` (`Name`),
  UNIQUE KEY `AK_Product_rowguid` (`rowguid`),
  KEY `FK_Product_UnitMeasure_SizeUnitMeasureCode` (`SizeUnitMeasureCode`),
  KEY `FK_Product_UnitMeasure_WeightUnitMeasureCode` (`WeightUnitMeasureCode`),
  KEY `FK_Product_ProductModel_ProductModelID` (`ProductModelID`),
  KEY `FK_Product_ProductSubcategory_ProductSubcategoryID` (`ProductSubcategoryID`),
  CONSTRAINT `FK_Product_ProductModel_ProductModelID` FOREIGN KEY (`ProductModelID`) REFERENCES `productmodel` (`ProductModelID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Product_ProductSubcategory_ProductSubcategoryID` FOREIGN KEY (`ProductSubcategoryID`) REFERENCES `productsubcategory` (`ProductSubcategoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Product_UnitMeasure_SizeUnitMeasureCode` FOREIGN KEY (`SizeUnitMeasureCode`) REFERENCES `unitmeasure` (`UnitMeasureCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Product_UnitMeasure_WeightUnitMeasureCode` FOREIGN KEY (`WeightUnitMeasureCode`) REFERENCES `unitmeasure` (`UnitMeasureCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Products sold or used in the manfacturing of sold products.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcategory` (
  `ProductCategoryID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ProductCategory records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Category description.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductCategoryID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_ProductCategory_Name` (`Name`),
  UNIQUE KEY `AK_ProductCategory_rowguid` (`rowguid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='High-level product categorization.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcosthistory`
--

DROP TABLE IF EXISTS `productcosthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcosthistory` (
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID',
  `StartDate` datetime(6) NOT NULL COMMENT 'Product cost start date.',
  `EndDate` datetime(6) DEFAULT NULL COMMENT 'Product cost end date.',
  `StandardCost` decimal(19,4) NOT NULL COMMENT 'Standard cost of the product.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`,`StartDate`),
  CONSTRAINT `FK_ProductCostHistory_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Changes in the cost of a product over time.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcosthistory`
--

LOCK TABLES `productcosthistory` WRITE;
/*!40000 ALTER TABLE `productcosthistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcosthistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdescription`
--

DROP TABLE IF EXISTS `productdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdescription` (
  `ProductDescriptionID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ProductDescription records.',
  `Description` varchar(400) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Description of the product.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductDescriptionID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_ProductDescription_rowguid` (`rowguid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product descriptions in several languages.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdescription`
--

LOCK TABLES `productdescription` WRITE;
/*!40000 ALTER TABLE `productdescription` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdocument`
--

DROP TABLE IF EXISTS `productdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdocument` (
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `DocumentNode` varchar(255) NOT NULL COMMENT 'Document identification number. Foreign key to Document.DocumentNode.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`,`DocumentNode`),
  KEY `FK_ProductDocument_Document_DocumentNode` (`DocumentNode`),
  CONSTRAINT `FK_ProductDocument_Document_DocumentNode` FOREIGN KEY (`DocumentNode`) REFERENCES `document` (`DocumentNode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductDocument_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping products to related product documents.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdocument`
--

LOCK TABLES `productdocument` WRITE;
/*!40000 ALTER TABLE `productdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productinventory`
--

DROP TABLE IF EXISTS `productinventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productinventory` (
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `LocationID` smallint(6) NOT NULL COMMENT 'Inventory location identification number. Foreign key to Location.LocationID. ',
  `Shelf` varchar(10) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Storage compartment within an inventory location.',
  `Bin` tinyint(3) unsigned NOT NULL COMMENT 'Storage container on a shelf in an inventory location.',
  `Quantity` smallint(6) NOT NULL DEFAULT '0' COMMENT 'Quantity of products in the inventory location.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`,`LocationID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  KEY `FK_ProductInventory_Location_LocationID` (`LocationID`),
  CONSTRAINT `FK_ProductInventory_Location_LocationID` FOREIGN KEY (`LocationID`) REFERENCES `location` (`LocationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductInventory_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product inventory information.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productinventory`
--

LOCK TABLES `productinventory` WRITE;
/*!40000 ALTER TABLE `productinventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productinventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productlistpricehistory`
--

DROP TABLE IF EXISTS `productlistpricehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productlistpricehistory` (
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID',
  `StartDate` datetime(6) NOT NULL COMMENT 'List price start date.',
  `EndDate` datetime(6) DEFAULT NULL COMMENT 'List price end date',
  `ListPrice` decimal(19,4) NOT NULL COMMENT 'Product list price.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`,`StartDate`),
  CONSTRAINT `FK_ProductListPriceHistory_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Changes in the list price of a product over time.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productlistpricehistory`
--

LOCK TABLES `productlistpricehistory` WRITE;
/*!40000 ALTER TABLE `productlistpricehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productlistpricehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmodel`
--

DROP TABLE IF EXISTS `productmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productmodel` (
  `ProductModelID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ProductModel records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Product model description.',
  `CatalogDescription` text COMMENT 'Detailed product catalog information in xml format.',
  `Instructions` text COMMENT 'Manufacturing instructions in xml format.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductModelID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_ProductModel_Name` (`Name`),
  UNIQUE KEY `AK_ProductModel_rowguid` (`rowguid`),
  KEY `PXML_ProductModel_CatalogDescription` (`CatalogDescription`(255)),
  KEY `PXML_ProductModel_Instructions` (`Instructions`(255))
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product model classification.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmodel`
--

LOCK TABLES `productmodel` WRITE;
/*!40000 ALTER TABLE `productmodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `productmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmodelillustration`
--

DROP TABLE IF EXISTS `productmodelillustration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productmodelillustration` (
  `ProductModelID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to ProductModel.ProductModelID.',
  `IllustrationID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Illustration.IllustrationID.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductModelID`,`IllustrationID`),
  KEY `FK_ProductModelIllustration_Illustration_IllustrationID` (`IllustrationID`),
  CONSTRAINT `FK_ProductModelIllustration_Illustration_IllustrationID` FOREIGN KEY (`IllustrationID`) REFERENCES `illustration` (`IllustrationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductModelIllustration_ProductModel_ProductModelID` FOREIGN KEY (`ProductModelID`) REFERENCES `productmodel` (`ProductModelID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping product models and illustrations.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmodelillustration`
--

LOCK TABLES `productmodelillustration` WRITE;
/*!40000 ALTER TABLE `productmodelillustration` DISABLE KEYS */;
/*!40000 ALTER TABLE `productmodelillustration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmodelproductdescriptionculture`
--

DROP TABLE IF EXISTS `productmodelproductdescriptionculture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productmodelproductdescriptionculture` (
  `ProductModelID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to ProductModel.ProductModelID.',
  `ProductDescriptionID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to ProductDescription.ProductDescriptionID.',
  `CultureID` char(6) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Culture identification number. Foreign key to Culture.CultureID.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductModelID`,`ProductDescriptionID`,`CultureID`),
  KEY `FK_ProductModelProductDescriptionCulture_ProductDescription_Pr3` (`ProductDescriptionID`),
  KEY `FK_ProductModelProductDescriptionCulture_Culture_CultureID` (`CultureID`),
  CONSTRAINT `FK_ProductModelProductDescriptionCulture_Culture_CultureID` FOREIGN KEY (`CultureID`) REFERENCES `culture` (`CultureID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductModelProductDescriptionCulture_ProductDescription_Pr3` FOREIGN KEY (`ProductDescriptionID`) REFERENCES `productdescription` (`ProductDescriptionID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductModelProductDescriptionCulture_ProductModel_ProductM4` FOREIGN KEY (`ProductModelID`) REFERENCES `productmodel` (`ProductModelID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping product descriptions and the language the description is written in.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmodelproductdescriptionculture`
--

LOCK TABLES `productmodelproductdescriptionculture` WRITE;
/*!40000 ALTER TABLE `productmodelproductdescriptionculture` DISABLE KEYS */;
/*!40000 ALTER TABLE `productmodelproductdescriptionculture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productphoto`
--

DROP TABLE IF EXISTS `productphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productphoto` (
  `ProductPhotoID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ProductPhoto records.',
  `ThumbNailPhoto` longblob COMMENT 'Small image of the product.',
  `ThumbnailPhotoFileName` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Small image file name.',
  `LargePhoto` longblob COMMENT 'Large image of the product.',
  `LargePhotoFileName` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Large image file name.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductPhotoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product images.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productphoto`
--

LOCK TABLES `productphoto` WRITE;
/*!40000 ALTER TABLE `productphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `productphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productproductphoto`
--

DROP TABLE IF EXISTS `productproductphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productproductphoto` (
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `ProductPhotoID` int(11) NOT NULL COMMENT 'Product photo identification number. Foreign key to ProductPhoto.ProductPhotoID.',
  `Primary` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 = Photo is not the principal image. 1 = Photo is the principal image.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`,`ProductPhotoID`),
  KEY `FK_ProductProductPhoto_ProductPhoto_ProductPhotoID` (`ProductPhotoID`),
  CONSTRAINT `FK_ProductProductPhoto_ProductPhoto_ProductPhotoID` FOREIGN KEY (`ProductPhotoID`) REFERENCES `productphoto` (`ProductPhotoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductProductPhoto_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping products and product photos.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productproductphoto`
--

LOCK TABLES `productproductphoto` WRITE;
/*!40000 ALTER TABLE `productproductphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `productproductphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productreview`
--

DROP TABLE IF EXISTS `productreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productreview` (
  `ProductReviewID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ProductReview records.',
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `ReviewerName` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the reviewer.',
  `ReviewDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date review was submitted.',
  `EmailAddress` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Reviewer''s e-mail address.',
  `Rating` int(11) NOT NULL COMMENT 'Product rating given by the reviewer. Scale is 1 to 5 with 5 as the highest rating.',
  `Comments` varchar(3850) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Reviewer''s comments',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductReviewID`),
  KEY `IX_ProductReview_ProductID_Name` (`ProductID`,`ReviewerName`,`Comments`(255)),
  CONSTRAINT `FK_ProductReview_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Customer reviews of products they have purchased.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productreview`
--

LOCK TABLES `productreview` WRITE;
/*!40000 ALTER TABLE `productreview` DISABLE KEYS */;
/*!40000 ALTER TABLE `productreview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsubcategory`
--

DROP TABLE IF EXISTS `productsubcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsubcategory` (
  `ProductSubcategoryID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ProductSubcategory records.',
  `ProductCategoryID` int(11) NOT NULL COMMENT 'Product category identification number. Foreign key to ProductCategory.ProductCategoryID.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Subcategory description.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductSubcategoryID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_ProductSubcategory_Name` (`Name`),
  UNIQUE KEY `AK_ProductSubcategory_rowguid` (`rowguid`),
  KEY `FK_ProductSubcategory_ProductCategory_ProductCategoryID` (`ProductCategoryID`),
  CONSTRAINT `FK_ProductSubcategory_ProductCategory_ProductCategoryID` FOREIGN KEY (`ProductCategoryID`) REFERENCES `productcategory` (`ProductCategoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Product subcategories. See ProductCategory table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsubcategory`
--

LOCK TABLES `productsubcategory` WRITE;
/*!40000 ALTER TABLE `productsubcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsubcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productvendor`
--

DROP TABLE IF EXISTS `productvendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productvendor` (
  `ProductID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Product.ProductID.',
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Vendor.BusinessEntityID.',
  `AverageLeadTime` int(11) NOT NULL COMMENT 'The average span of time (in days) between placing an order with the vendor and receiving the purchased product.',
  `StandardPrice` decimal(19,4) NOT NULL COMMENT 'The vendor''s usual selling price.',
  `LastReceiptCost` decimal(19,4) DEFAULT NULL COMMENT 'The selling price when last purchased.',
  `LastReceiptDate` datetime(6) DEFAULT NULL COMMENT 'Date the product was last received by the vendor.',
  `MinOrderQty` int(11) NOT NULL COMMENT 'The maximum quantity that should be ordered.',
  `MaxOrderQty` int(11) NOT NULL COMMENT 'The minimum quantity that should be ordered.',
  `OnOrderQty` int(11) DEFAULT NULL COMMENT 'The quantity currently on order.',
  `UnitMeasureCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'The product''s unit of measure.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ProductID`,`BusinessEntityID`),
  KEY `IX_ProductVendor_UnitMeasureCode` (`UnitMeasureCode`),
  KEY `IX_ProductVendor_BusinessEntityID` (`BusinessEntityID`),
  CONSTRAINT `FK_ProductVendor_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductVendor_UnitMeasure_UnitMeasureCode` FOREIGN KEY (`UnitMeasureCode`) REFERENCES `unitmeasure` (`UnitMeasureCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductVendor_Vendor_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `vendor` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping vendors with the products they supply.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productvendor`
--

LOCK TABLES `productvendor` WRITE;
/*!40000 ALTER TABLE `productvendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `productvendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseorderdetail`
--

DROP TABLE IF EXISTS `purchaseorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorderdetail` (
  `PurchaseOrderID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to PurchaseOrderHeader.PurchaseOrderID.',
  `PurchaseOrderDetailID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key. One line number per purchased product.',
  `DueDate` datetime(6) NOT NULL COMMENT 'Date the product is expected to be received.',
  `OrderQty` smallint(6) NOT NULL COMMENT 'Quantity ordered.',
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `UnitPrice` decimal(19,4) NOT NULL COMMENT 'Vendor''s selling price of a single product.',
  `LineTotal` decimal(19,4) NOT NULL COMMENT 'Per product subtotal. Computed as OrderQty * UnitPrice.',
  `ReceivedQty` decimal(8,2) NOT NULL COMMENT 'Quantity actually received from the vendor.',
  `RejectedQty` decimal(8,2) NOT NULL COMMENT 'Quantity rejected during inspection.',
  `StockedQty` decimal(9,2) NOT NULL COMMENT 'Quantity accepted into inventory. Computed as ReceivedQty - RejectedQty.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`PurchaseOrderDetailID`,`PurchaseOrderID`),
  KEY `IX_PurchaseOrderDetail_ProductID` (`ProductID`),
  KEY `FK_PurchaseOrderDetail_PurchaseOrderHeader_PurchaseOrderID` (`PurchaseOrderID`),
  CONSTRAINT `FK_PurchaseOrderDetail_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PurchaseOrderDetail_PurchaseOrderHeader_PurchaseOrderID` FOREIGN KEY (`PurchaseOrderID`) REFERENCES `purchaseorderheader` (`PurchaseOrderID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Individual products associated with a specific purchase order. See PurchaseOrderHeader.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseorderdetail`
--

LOCK TABLES `purchaseorderdetail` WRITE;
/*!40000 ALTER TABLE `purchaseorderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseorderheader`
--

DROP TABLE IF EXISTS `purchaseorderheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorderheader` (
  `PurchaseOrderID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `RevisionNumber` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT 'Incremental number to track changes to the purchase order over time.',
  `Status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT 'Order current status. 1 = Pending; 2 = Approved; 3 = Rejected; 4 = Complete',
  `EmployeeID` int(11) NOT NULL COMMENT 'Employee who created the purchase order. Foreign key to Employee.BusinessEntityID.',
  `VendorID` int(11) NOT NULL COMMENT 'Vendor with whom the purchase order is placed. Foreign key to Vendor.BusinessEntityID.',
  `ShipMethodID` int(11) NOT NULL COMMENT 'Shipping method. Foreign key to ShipMethod.ShipMethodID.',
  `OrderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Purchase order creation date.',
  `ShipDate` datetime(6) DEFAULT NULL COMMENT 'Estimated shipment date from the vendor.',
  `SubTotal` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Purchase order subtotal. Computed as SUM(PurchaseOrderDetail.LineTotal)for the appropriate PurchaseOrderID.',
  `TaxAmt` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Tax amount.',
  `Freight` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Shipping cost.',
  `TotalDue` decimal(19,4) NOT NULL COMMENT 'Total due to vendor. Computed as Subtotal + TaxAmt + Freight.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`PurchaseOrderID`),
  KEY `IX_PurchaseOrderHeader_VendorID` (`VendorID`),
  KEY `IX_PurchaseOrderHeader_EmployeeID` (`EmployeeID`),
  KEY `FK_PurchaseOrderHeader_ShipMethod_ShipMethodID` (`ShipMethodID`),
  CONSTRAINT `FK_PurchaseOrderHeader_Employee_EmployeeID` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PurchaseOrderHeader_ShipMethod_ShipMethodID` FOREIGN KEY (`ShipMethodID`) REFERENCES `shipmethod` (`ShipMethodID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PurchaseOrderHeader_Vendor_VendorID` FOREIGN KEY (`VendorID`) REFERENCES `vendor` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='General purchase order information. See PurchaseOrderDetail.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseorderheader`
--

LOCK TABLES `purchaseorderheader` WRITE;
/*!40000 ALTER TABLE `purchaseorderheader` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseorderheader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderdetail`
--

DROP TABLE IF EXISTS `salesorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorderdetail` (
  `SalesOrderID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to SalesOrderHeader.SalesOrderID.',
  `SalesOrderDetailID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key. One incremental unique number per product sold.',
  `CarrierTrackingNumber` varchar(25) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Shipment tracking number supplied by the shipper.',
  `OrderQty` smallint(6) NOT NULL COMMENT 'Quantity ordered per product.',
  `ProductID` int(11) NOT NULL COMMENT 'Product sold to customer. Foreign key to Product.ProductID.',
  `SpecialOfferID` int(11) NOT NULL COMMENT 'Promotional code. Foreign key to SpecialOffer.SpecialOfferID.',
  `UnitPrice` decimal(19,4) NOT NULL COMMENT 'Selling price of a single product.',
  `UnitPriceDiscount` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Discount amount.',
  `LineTotal` decimal(38,6) NOT NULL COMMENT 'Per product subtotal. Computed as UnitPrice * (1 - UnitPriceDiscount) * OrderQty.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SalesOrderDetailID`,`SalesOrderID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesOrderDetail_rowguid` (`rowguid`),
  KEY `IX_SalesOrderDetail_ProductID` (`ProductID`),
  KEY `FK_SalesOrderDetail_SalesOrderHeader_SalesOrderID` (`SalesOrderID`),
  KEY `FK_SalesOrderDetail_SpecialOfferProduct_SpecialOfferIDProductID` (`SpecialOfferID`,`ProductID`),
  CONSTRAINT `FK_SalesOrderDetail_SalesOrderHeader_SalesOrderID` FOREIGN KEY (`SalesOrderID`) REFERENCES `salesorderheader` (`SalesOrderID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderDetail_SpecialOfferProduct_SpecialOfferIDProductID` FOREIGN KEY (`SpecialOfferID`, `ProductID`) REFERENCES `specialofferproduct` (`SpecialOfferID`, `ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Individual products associated with a specific sales order. See SalesOrderHeader.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderdetail`
--

LOCK TABLES `salesorderdetail` WRITE;
/*!40000 ALTER TABLE `salesorderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderheader`
--

DROP TABLE IF EXISTS `salesorderheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorderheader` (
  `SalesOrderID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
  `RevisionNumber` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT 'Incremental number to track changes to the sales order over time.',
  `OrderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Dates the sales order was created.',
  `DueDate` datetime(6) NOT NULL COMMENT 'Date the order is due to the customer.',
  `ShipDate` datetime(6) DEFAULT NULL COMMENT 'Date the order was shipped to the customer.',
  `Status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT 'Order current status. 1 = In process; 2 = Approved; 3 = Backordered; 4 = Rejected; 5 = Shipped; 6 = Cancelled',
  `OnlineOrderFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = Order placed by sales person. 1 = Order placed online by customer.',
  `SalesOrderNumber` varchar(25) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Unique sales order identification number.',
  `PurchaseOrderNumber` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Customer purchase order number reference. ',
  `AccountNumber` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Financial accounting number reference.',
  `CustomerID` int(11) NOT NULL COMMENT 'Customer identification number. Foreign key to Customer.BusinessEntityID.',
  `SalesPersonID` int(11) DEFAULT NULL COMMENT 'Sales person who created the sales order. Foreign key to SalesPerson.BusinessEntityID.',
  `TerritoryID` int(11) DEFAULT NULL COMMENT 'Territory in which the sale was made. Foreign key to SalesTerritory.SalesTerritoryID.',
  `BillToAddressID` int(11) NOT NULL COMMENT 'Customer billing address. Foreign key to Address.AddressID.',
  `ShipToAddressID` int(11) NOT NULL COMMENT 'Customer shipping address. Foreign key to Address.AddressID.',
  `ShipMethodID` int(11) NOT NULL COMMENT 'Shipping method. Foreign key to ShipMethod.ShipMethodID.',
  `CreditCardID` int(11) DEFAULT NULL COMMENT 'Credit card identification number. Foreign key to CreditCard.CreditCardID.',
  `CreditCardApprovalCode` varchar(15) DEFAULT NULL COMMENT 'Approval code provided by the credit card company.',
  `CurrencyRateID` int(11) DEFAULT NULL COMMENT 'Currency exchange rate used. Foreign key to CurrencyRate.CurrencyRateID.',
  `SubTotal` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal)for the appropriate SalesOrderID.',
  `TaxAmt` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Tax amount.',
  `Freight` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Shipping cost.',
  `TotalDue` decimal(19,4) NOT NULL COMMENT 'Total due from customer. Computed as Subtotal + TaxAmt + Freight.',
  `Comment` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Sales representative comments.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SalesOrderID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesOrderHeader_rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesOrderHeader_SalesOrderNumber` (`SalesOrderNumber`),
  KEY `IX_SalesOrderHeader_CustomerID` (`CustomerID`),
  KEY `IX_SalesOrderHeader_SalesPersonID` (`SalesPersonID`),
  KEY `FK_SalesOrderHeader_Address_BillToAddressID` (`BillToAddressID`),
  KEY `FK_SalesOrderHeader_Address_ShipToAddressID` (`ShipToAddressID`),
  KEY `FK_SalesOrderHeader_CreditCard_CreditCardID` (`CreditCardID`),
  KEY `FK_SalesOrderHeader_CurrencyRate_CurrencyRateID` (`CurrencyRateID`),
  KEY `FK_SalesOrderHeader_ShipMethod_ShipMethodID` (`ShipMethodID`),
  KEY `FK_SalesOrderHeader_SalesTerritory_TerritoryID` (`TerritoryID`),
  CONSTRAINT `FK_SalesOrderHeader_Address_BillToAddressID` FOREIGN KEY (`BillToAddressID`) REFERENCES `address` (`AddressID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_Address_ShipToAddressID` FOREIGN KEY (`ShipToAddressID`) REFERENCES `address` (`AddressID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_CreditCard_CreditCardID` FOREIGN KEY (`CreditCardID`) REFERENCES `creditcard` (`CreditCardID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_CurrencyRate_CurrencyRateID` FOREIGN KEY (`CurrencyRateID`) REFERENCES `currencyrate` (`CurrencyRateID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_Customer_CustomerID` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_SalesPerson_SalesPersonID` FOREIGN KEY (`SalesPersonID`) REFERENCES `salesperson` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_SalesTerritory_TerritoryID` FOREIGN KEY (`TerritoryID`) REFERENCES `salesterritory` (`TerritoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeader_ShipMethod_ShipMethodID` FOREIGN KEY (`ShipMethodID`) REFERENCES `shipmethod` (`ShipMethodID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='General sales order information.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderheader`
--

LOCK TABLES `salesorderheader` WRITE;
/*!40000 ALTER TABLE `salesorderheader` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorderheader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderheadersalesreason`
--

DROP TABLE IF EXISTS `salesorderheadersalesreason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorderheadersalesreason` (
  `SalesOrderID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to SalesOrderHeader.SalesOrderID.',
  `SalesReasonID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to SalesReason.SalesReasonID.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SalesOrderID`,`SalesReasonID`),
  KEY `FK_SalesOrderHeaderSalesReason_SalesReason_SalesReasonID` (`SalesReasonID`),
  CONSTRAINT `FK_SalesOrderHeaderSalesReason_SalesOrderHeader_SalesOrderID` FOREIGN KEY (`SalesOrderID`) REFERENCES `salesorderheader` (`SalesOrderID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesOrderHeaderSalesReason_SalesReason_SalesReasonID` FOREIGN KEY (`SalesReasonID`) REFERENCES `salesreason` (`SalesReasonID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping sales orders to sales reason codes.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderheadersalesreason`
--

LOCK TABLES `salesorderheadersalesreason` WRITE;
/*!40000 ALTER TABLE `salesorderheadersalesreason` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorderheadersalesreason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesperson`
--

DROP TABLE IF EXISTS `salesperson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesperson` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key for SalesPerson records. Foreign key to Employee.BusinessEntityID',
  `TerritoryID` int(11) DEFAULT NULL COMMENT 'Territory currently assigned to. Foreign key to SalesTerritory.SalesTerritoryID.',
  `SalesQuota` decimal(19,4) DEFAULT NULL COMMENT 'Projected yearly sales.',
  `Bonus` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Bonus due if quota is met.',
  `CommissionPct` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT 'Commision percent received per sale.',
  `SalesYTD` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Sales total year to date.',
  `SalesLastYear` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Sales total of previous year.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesPerson_rowguid` (`rowguid`),
  KEY `FK_SalesPerson_SalesTerritory_TerritoryID` (`TerritoryID`),
  CONSTRAINT `FK_SalesPerson_Employee_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `employee` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesPerson_SalesTerritory_TerritoryID` FOREIGN KEY (`TerritoryID`) REFERENCES `salesterritory` (`TerritoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Sales representative current information.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesperson`
--

LOCK TABLES `salesperson` WRITE;
/*!40000 ALTER TABLE `salesperson` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesperson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salespersonquotahistory`
--

DROP TABLE IF EXISTS `salespersonquotahistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salespersonquotahistory` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Sales person identification number. Foreign key to SalesPerson.BusinessEntityID.',
  `QuotaDate` datetime(6) NOT NULL COMMENT 'Sales quota date.',
  `SalesQuota` decimal(19,4) NOT NULL COMMENT 'Sales quota amount.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`QuotaDate`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesPersonQuotaHistory_rowguid` (`rowguid`),
  CONSTRAINT `FK_SalesPersonQuotaHistory_SalesPerson_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `salesperson` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Sales performance tracking.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salespersonquotahistory`
--

LOCK TABLES `salespersonquotahistory` WRITE;
/*!40000 ALTER TABLE `salespersonquotahistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `salespersonquotahistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesreason`
--

DROP TABLE IF EXISTS `salesreason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesreason` (
  `SalesReasonID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for SalesReason records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Sales reason description.',
  `ReasonType` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Category the sales reason belongs to.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SalesReasonID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Lookup table of customer purchase reasons.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesreason`
--

LOCK TABLES `salesreason` WRITE;
/*!40000 ALTER TABLE `salesreason` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesreason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salestaxrate`
--

DROP TABLE IF EXISTS `salestaxrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salestaxrate` (
  `SalesTaxRateID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for SalesTaxRate records.',
  `StateProvinceID` int(11) NOT NULL COMMENT 'State, province, or country/region the sales tax applies to.',
  `TaxType` tinyint(3) unsigned NOT NULL COMMENT '1 = Tax applied to retail transactions, 2 = Tax applied to wholesale transactions, 3 = Tax applied to all sales (retail and wholesale) transactions.',
  `TaxRate` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT 'Tax rate amount.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Tax rate description.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SalesTaxRateID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesTaxRate_StateProvinceID_TaxType` (`StateProvinceID`,`TaxType`),
  UNIQUE KEY `AK_SalesTaxRate_rowguid` (`rowguid`),
  CONSTRAINT `FK_SalesTaxRate_StateProvince_StateProvinceID` FOREIGN KEY (`StateProvinceID`) REFERENCES `stateprovince` (`StateProvinceID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tax rate lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salestaxrate`
--

LOCK TABLES `salestaxrate` WRITE;
/*!40000 ALTER TABLE `salestaxrate` DISABLE KEYS */;
/*!40000 ALTER TABLE `salestaxrate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesterritory`
--

DROP TABLE IF EXISTS `salesterritory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesterritory` (
  `TerritoryID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for SalesTerritory records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Sales territory description',
  `CountryRegionCode` varchar(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode. ',
  `Group` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Geographic area to which the sales territory belong.',
  `SalesYTD` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Sales in the territory year to date.',
  `SalesLastYear` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Sales in the territory the previous year.',
  `CostYTD` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Business costs in the territory year to date.',
  `CostLastYear` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Business costs in the territory the previous year.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`TerritoryID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesTerritory_Name` (`Name`),
  UNIQUE KEY `AK_SalesTerritory_rowguid` (`rowguid`),
  KEY `FK_SalesTerritory_CountryRegion_CountryRegionCode` (`CountryRegionCode`),
  CONSTRAINT `FK_SalesTerritory_CountryRegion_CountryRegionCode` FOREIGN KEY (`CountryRegionCode`) REFERENCES `countryregion` (`CountryRegionCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Sales territory lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesterritory`
--

LOCK TABLES `salesterritory` WRITE;
/*!40000 ALTER TABLE `salesterritory` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesterritory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesterritoryhistory`
--

DROP TABLE IF EXISTS `salesterritoryhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesterritoryhistory` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key. The sales rep.  Foreign key to SalesPerson.BusinessEntityID.',
  `TerritoryID` int(11) NOT NULL COMMENT 'Primary key. Territory identification number. Foreign key to SalesTerritory.SalesTerritoryID.',
  `StartDate` datetime(6) NOT NULL COMMENT 'Primary key. Date the sales representive started work in the territory.',
  `EndDate` datetime(6) DEFAULT NULL COMMENT 'Date the sales representative left work in the territory.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`,`StartDate`,`TerritoryID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SalesTerritoryHistory_rowguid` (`rowguid`),
  KEY `FK_SalesTerritoryHistory_SalesTerritory_TerritoryID` (`TerritoryID`),
  CONSTRAINT `FK_SalesTerritoryHistory_SalesPerson_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `salesperson` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesTerritoryHistory_SalesTerritory_TerritoryID` FOREIGN KEY (`TerritoryID`) REFERENCES `salesterritory` (`TerritoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Sales representative transfers to other sales territories.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesterritoryhistory`
--

LOCK TABLES `salesterritoryhistory` WRITE;
/*!40000 ALTER TABLE `salesterritoryhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesterritoryhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scrapreason`
--

DROP TABLE IF EXISTS `scrapreason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scrapreason` (
  `ScrapReasonID` smallint(6) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ScrapReason records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Failure description.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ScrapReasonID`),
  UNIQUE KEY `AK_ScrapReason_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Manufacturing failure reasons lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scrapreason`
--

LOCK TABLES `scrapreason` WRITE;
/*!40000 ALTER TABLE `scrapreason` DISABLE KEYS */;
/*!40000 ALTER TABLE `scrapreason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift`
--

DROP TABLE IF EXISTS `shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shift` (
  `ShiftID` tinyint(3) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary key for Shift records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Shift description.',
  `StartTime` time(6) NOT NULL COMMENT 'Shift start time.',
  `EndTime` time(6) NOT NULL COMMENT 'Shift end time.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ShiftID`),
  UNIQUE KEY `AK_Shift_Name` (`Name`),
  UNIQUE KEY `AK_Shift_StartTime_EndTime` (`StartTime`,`EndTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Work shift lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift`
--

LOCK TABLES `shift` WRITE;
/*!40000 ALTER TABLE `shift` DISABLE KEYS */;
/*!40000 ALTER TABLE `shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipmethod`
--

DROP TABLE IF EXISTS `shipmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipmethod` (
  `ShipMethodID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ShipMethod records.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Shipping company name.',
  `ShipBase` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Minimum shipping charge.',
  `ShipRate` decimal(19,4) NOT NULL DEFAULT '0.0000' COMMENT 'Shipping charge per pound.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ShipMethodID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_ShipMethod_Name` (`Name`),
  UNIQUE KEY `AK_ShipMethod_rowguid` (`rowguid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Shipping company lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipmethod`
--

LOCK TABLES `shipmethod` WRITE;
/*!40000 ALTER TABLE `shipmethod` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcartitem`
--

DROP TABLE IF EXISTS `shoppingcartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcartitem` (
  `ShoppingCartItemID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for ShoppingCartItem records.',
  `ShoppingCartID` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Shopping cart identification number.',
  `Quantity` int(11) NOT NULL DEFAULT '1' COMMENT 'Product quantity ordered.',
  `ProductID` int(11) NOT NULL COMMENT 'Product ordered. Foreign key to Product.ProductID.',
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date the time the record was created.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`ShoppingCartItemID`),
  KEY `IX_ShoppingCartItem_ShoppingCartID_ProductID` (`ShoppingCartID`,`ProductID`),
  KEY `FK_ShoppingCartItem_Product_ProductID` (`ProductID`),
  CONSTRAINT `FK_ShoppingCartItem_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains online customer orders until the order is submitted or cancelled.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcartitem`
--

LOCK TABLES `shoppingcartitem` WRITE;
/*!40000 ALTER TABLE `shoppingcartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialoffer`
--

DROP TABLE IF EXISTS `specialoffer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialoffer` (
  `SpecialOfferID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for SpecialOffer records.',
  `Description` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Discount description.',
  `DiscountPct` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT 'Discount precentage.',
  `Type` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Discount type category.',
  `Category` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Group the discount applies to such as Reseller or Customer.',
  `StartDate` datetime(6) NOT NULL COMMENT 'Discount start date.',
  `EndDate` datetime(6) NOT NULL COMMENT 'Discount end date.',
  `MinQty` int(11) NOT NULL DEFAULT '0' COMMENT 'Minimum discount percent allowed.',
  `MaxQty` int(11) DEFAULT NULL COMMENT 'Maximum discount percent allowed.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SpecialOfferID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SpecialOffer_rowguid` (`rowguid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Sale discounts lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialoffer`
--

LOCK TABLES `specialoffer` WRITE;
/*!40000 ALTER TABLE `specialoffer` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialoffer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialofferproduct`
--

DROP TABLE IF EXISTS `specialofferproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialofferproduct` (
  `SpecialOfferID` int(11) NOT NULL COMMENT 'Primary key for SpecialOfferProduct records.',
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`SpecialOfferID`,`ProductID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_SpecialOfferProduct_rowguid` (`rowguid`),
  KEY `IX_SpecialOfferProduct_ProductID` (`ProductID`),
  CONSTRAINT `FK_SpecialOfferProduct_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SpecialOfferProduct_SpecialOffer_SpecialOfferID` FOREIGN KEY (`SpecialOfferID`) REFERENCES `specialoffer` (`SpecialOfferID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Cross-reference table mapping products to special offer discounts.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialofferproduct`
--

LOCK TABLES `specialofferproduct` WRITE;
/*!40000 ALTER TABLE `specialofferproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialofferproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stateprovince`
--

DROP TABLE IF EXISTS `stateprovince`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stateprovince` (
  `StateProvinceID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for StateProvince records.',
  `StateProvinceCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ISO standard state or province code.',
  `CountryRegionCode` varchar(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode. ',
  `IsOnlyStateProvinceFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'State or province description.',
  `TerritoryID` int(11) NOT NULL COMMENT 'ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`StateProvinceID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_StateProvince_Name` (`Name`),
  UNIQUE KEY `AK_StateProvince_StateProvinceCode_CountryRegionCode` (`StateProvinceCode`,`CountryRegionCode`),
  UNIQUE KEY `AK_StateProvince_rowguid` (`rowguid`),
  KEY `FK_StateProvince_CountryRegion_CountryRegionCode` (`CountryRegionCode`),
  KEY `FK_StateProvince_SalesTerritory_TerritoryID` (`TerritoryID`),
  CONSTRAINT `FK_StateProvince_CountryRegion_CountryRegionCode` FOREIGN KEY (`CountryRegionCode`) REFERENCES `countryregion` (`CountryRegionCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_StateProvince_SalesTerritory_TerritoryID` FOREIGN KEY (`TerritoryID`) REFERENCES `salesterritory` (`TerritoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='State and province lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stateprovince`
--

LOCK TABLES `stateprovince` WRITE;
/*!40000 ALTER TABLE `stateprovince` DISABLE KEYS */;
/*!40000 ALTER TABLE `stateprovince` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Customer.BusinessEntityID.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Name of the store.',
  `SalesPersonID` int(11) DEFAULT NULL COMMENT 'ID of the sales person assigned to the customer. Foreign key to SalesPerson.BusinessEntityID.',
  `Demographics` text COMMENT 'Demographic informationg about the store such as the number of employees, annual sales and store type.',
  `rowguid` varchar(64) NOT NULL COMMENT 'ROWGUIDCOL number uniquely identifying the record. Used to support a merge replication sample.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `rowguid` (`rowguid`),
  UNIQUE KEY `AK_Store_rowguid` (`rowguid`),
  KEY `IX_Store_SalesPersonID` (`SalesPersonID`),
  KEY `PXML_Store_Demographics` (`Demographics`(255)),
  CONSTRAINT `FK_Store_BusinessEntity_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `businessentity` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Store_SalesPerson_SalesPersonID` FOREIGN KEY (`SalesPersonID`) REFERENCES `salesperson` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Customers (resellers) of Adventure Works products.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionhistory`
--

DROP TABLE IF EXISTS `transactionhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionhistory` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for TransactionHistory records.',
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `ReferenceOrderID` int(11) NOT NULL COMMENT 'Purchase order, sales order, or work order identification number.',
  `ReferenceOrderLineID` int(11) NOT NULL DEFAULT '0' COMMENT 'Line number associated with the purchase order, sales order, or work order.',
  `TransactionDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time of the transaction.',
  `TransactionType` char(1) CHARACTER SET utf8mb4 NOT NULL COMMENT 'W = WorkOrder, S = SalesOrder, P = PurchaseOrder',
  `Quantity` int(11) NOT NULL COMMENT 'Product quantity.',
  `ActualCost` decimal(19,4) NOT NULL COMMENT 'Product cost.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`TransactionID`),
  KEY `IX_TransactionHistory_ProductID` (`ProductID`),
  KEY `IX_TransactionHistory_ReferenceOrderID_ReferenceOrderLineID` (`ReferenceOrderID`,`ReferenceOrderLineID`),
  CONSTRAINT `FK_TransactionHistory_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Record of each purchase order, sales order, or work order transaction year to date.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionhistory`
--

LOCK TABLES `transactionhistory` WRITE;
/*!40000 ALTER TABLE `transactionhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionhistoryarchive`
--

DROP TABLE IF EXISTS `transactionhistoryarchive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionhistoryarchive` (
  `TransactionID` int(11) NOT NULL COMMENT 'Primary key for TransactionHistoryArchive records.',
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `ReferenceOrderID` int(11) NOT NULL COMMENT 'Purchase order, sales order, or work order identification number.',
  `ReferenceOrderLineID` int(11) NOT NULL DEFAULT '0' COMMENT 'Line number associated with the purchase order, sales order, or work order.',
  `TransactionDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time of the transaction.',
  `TransactionType` char(1) CHARACTER SET utf8mb4 NOT NULL COMMENT 'W = Work Order, S = Sales Order, P = Purchase Order',
  `Quantity` int(11) NOT NULL COMMENT 'Product quantity.',
  `ActualCost` decimal(19,4) NOT NULL COMMENT 'Product cost.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`TransactionID`),
  KEY `IX_TransactionHistoryArchive_ProductID` (`ProductID`),
  KEY `IX_TransactionHistoryArchive_ReferenceOrderID_ReferenceOrderLi2` (`ReferenceOrderID`,`ReferenceOrderLineID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Transactions for previous years.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionhistoryarchive`
--

LOCK TABLES `transactionhistoryarchive` WRITE;
/*!40000 ALTER TABLE `transactionhistoryarchive` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionhistoryarchive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unitmeasure`
--

DROP TABLE IF EXISTS `unitmeasure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unitmeasure` (
  `UnitMeasureCode` char(3) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Primary key.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Unit of measure description.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`UnitMeasureCode`),
  UNIQUE KEY `AK_UnitMeasure_Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Unit of measure lookup table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unitmeasure`
--

LOCK TABLES `unitmeasure` WRITE;
/*!40000 ALTER TABLE `unitmeasure` DISABLE KEYS */;
/*!40000 ALTER TABLE `unitmeasure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','admin',1),('arturo','arturo',1),('santiago','santiago',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,'admin','ROLE_ADMIN'),(1,'arturo','ROLE_USUARIO'),(3,'santiago','ROLE_USUARIO');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `BusinessEntityID` int(11) NOT NULL COMMENT 'Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID',
  `AccountNumber` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Vendor account (identification) number.',
  `Name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Company name.',
  `CreditRating` tinyint(3) unsigned NOT NULL COMMENT '1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average',
  `PreferredVendorStatus` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product.',
  `ActiveFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 = Vendor no longer used. 1 = Vendor is actively used.',
  `PurchasingWebServiceURL` varchar(1024) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'Vendor URL.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`BusinessEntityID`),
  UNIQUE KEY `AK_Vendor_AccountNumber` (`AccountNumber`),
  CONSTRAINT `FK_Vendor_BusinessEntity_BusinessEntityID` FOREIGN KEY (`BusinessEntityID`) REFERENCES `businessentity` (`BusinessEntityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Companies from whom Adventure Works Cycles purchases parts or other goods.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workorder`
--

DROP TABLE IF EXISTS `workorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workorder` (
  `WorkOrderID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key for WorkOrder records.',
  `ProductID` int(11) NOT NULL COMMENT 'Product identification number. Foreign key to Product.ProductID.',
  `OrderQty` int(11) NOT NULL COMMENT 'Product quantity to build.',
  `StockedQty` int(11) NOT NULL COMMENT 'Quantity built and put in inventory.',
  `ScrappedQty` smallint(6) NOT NULL COMMENT 'Quantity that failed inspection.',
  `StartDate` datetime(6) NOT NULL COMMENT 'Work order start date.',
  `EndDate` datetime(6) DEFAULT NULL COMMENT 'Work order end date.',
  `DueDate` datetime(6) NOT NULL COMMENT 'Work order due date.',
  `ScrapReasonID` smallint(6) DEFAULT NULL COMMENT 'Reason for inspection failure.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`WorkOrderID`),
  KEY `IX_WorkOrder_ScrapReasonID` (`ScrapReasonID`),
  KEY `IX_WorkOrder_ProductID` (`ProductID`),
  CONSTRAINT `FK_WorkOrder_Product_ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_WorkOrder_ScrapReason_ScrapReasonID` FOREIGN KEY (`ScrapReasonID`) REFERENCES `scrapreason` (`ScrapReasonID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Manufacturing work orders.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workorder`
--

LOCK TABLES `workorder` WRITE;
/*!40000 ALTER TABLE `workorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `workorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workorderrouting`
--

DROP TABLE IF EXISTS `workorderrouting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workorderrouting` (
  `WorkOrderID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to WorkOrder.WorkOrderID.',
  `ProductID` int(11) NOT NULL COMMENT 'Primary key. Foreign key to Product.ProductID.',
  `OperationSequence` smallint(6) NOT NULL COMMENT 'Primary key. Indicates the manufacturing process sequence.',
  `LocationID` smallint(6) NOT NULL COMMENT 'Manufacturing location where the part is processed. Foreign key to Location.LocationID.',
  `ScheduledStartDate` datetime(6) NOT NULL COMMENT 'Planned manufacturing start date.',
  `ScheduledEndDate` datetime(6) NOT NULL COMMENT 'Planned manufacturing end date.',
  `ActualStartDate` datetime(6) DEFAULT NULL COMMENT 'Actual start date.',
  `ActualEndDate` datetime(6) DEFAULT NULL COMMENT 'Actual end date.',
  `ActualResourceHrs` decimal(9,4) DEFAULT NULL COMMENT 'Number of manufacturing hours used.',
  `PlannedCost` decimal(19,4) NOT NULL COMMENT 'Estimated manufacturing cost.',
  `ActualCost` decimal(19,4) DEFAULT NULL COMMENT 'Actual manufacturing cost.',
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date and time the record was last updated.',
  PRIMARY KEY (`WorkOrderID`,`ProductID`,`OperationSequence`),
  KEY `IX_WorkOrderRouting_ProductID` (`ProductID`),
  KEY `FK_WorkOrderRouting_Location_LocationID` (`LocationID`),
  CONSTRAINT `FK_WorkOrderRouting_Location_LocationID` FOREIGN KEY (`LocationID`) REFERENCES `location` (`LocationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_WorkOrderRouting_WorkOrder_WorkOrderID` FOREIGN KEY (`WorkOrderID`) REFERENCES `workorder` (`WorkOrderID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Work order details.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workorderrouting`
--

LOCK TABLES `workorderrouting` WRITE;
/*!40000 ALTER TABLE `workorderrouting` DISABLE KEYS */;
/*!40000 ALTER TABLE `workorderrouting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-09 10:35:46
