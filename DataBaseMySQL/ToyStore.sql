CREATE DATABASE toy_store;

USE toy_store;

CREATE TABLE Staff (
  StaffId nchar(10) NOT NULL PRIMARY KEY,
  FristName nvarchar(50) NOT NULL,
  LastName nvarchar(50) NOT NULL,
  Email nvarchar(255) NOT NULL,
  Phone nvarchar(20),
  Gender nvarchar(10),
  Address nvarchar(255),
  UserName nvarchar(20),
  Password nvarchar(20),
  Birthday date
);

CREATE TABLE Customer (
  CustomerId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FristName nvarchar(50) NOT NULL,
  LastName nvarchar(50) NOT NULL,
  Email nvarchar(255) NOT NULL,
  Phone nvarchar(20),
  Gender nvarchar(10),
  Address nvarchar(255),
  UserName nvarchar(20),
  Password nvarchar(20),
  Birthday date NOT NULL
);

CREATE TABLE Supplier (
  SupplierId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name nvarchar(255) NOT NULL,
  Address nvarchar(255),
  Email nvarchar(255) NOT NULL,
  Phone nvarchar(20)
);

CREATE TABLE Brand (
  BrandId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name nvarchar(255) NOT NULL,
  Website nvarchar(255),
  Phone nvarchar(20),
  Address nvarchar(255)
);

CREATE TABLE Category (
  CategoryId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name nvarchar(255) NOT NULL
);

CREATE TABLE Toy (
  SKU nchar(10) NOT NULL PRIMARY KEY,
  Name nvarchar(255) NOT NULL,
  Status nvarchar(50) NOT NULL,
  Description nvarchar(255),
  InventoryNumber int,
  Image BLOB,
  BrandId int NOT NULL,
  SupplierId int NOT NULL,
  Is_new BOOLEAN,
  CONSTRAINT FK_Toy_Brand FOREIGN KEY (BrandId) REFERENCES Brand(BrandId),
  CONSTRAINT FK_Toy_Supplier FOREIGN KEY (SupplierId) REFERENCES Supplier(SupplierId)
);

CREATE TABLE ProductPrice (
  StaffId nchar(10) NOT NULL,
  SKU nchar(10) NOT NULL,
  Price DOUBLE NOT NULL,
  UpdatedDate datetime NOT NULL,
  PRIMARY KEY (StaffId, SKU, UpdatedDate),
  CONSTRAINT FK_ProductPrice_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId),
  CONSTRAINT FK_ProductPrice_Toy FOREIGN KEY (SKU) REFERENCES Toy(SKU)
);

CREATE TABLE CategoryDetail (
  SKU nchar(10) NOT NULL,
  CategoryId int NOT NULL,
  PRIMARY KEY (SKU, CategoryId),
  CONSTRAINT FK_CategoryDetail_Toy FOREIGN KEY (SKU) REFERENCES Toy(SKU) ON UPDATE CASCADE ,
  CONSTRAINT FK_CategoryDetail_Category FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId)
);

CREATE TABLE StoreOrder (
  StoreOrderId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Status nvarchar(50) NOT NULL,
  OrderDate date NOT NULL,
  StaffId nchar(10) NOT NULL,
  SupplierId int NOT NULL,
  CONSTRAINT FK_StoreOrder_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE,
  CONSTRAINT FK_StoreOrder_Supplier FOREIGN KEY (SupplierId) REFERENCES Supplier(SupplierId)
);

CREATE TABLE StoreOrderDetail (
  StoreOrderId int NOT NULL,
  SKU nchar(10) NOT NULL,
  Quantity int NOT NULL,
  Price DOUBLE NOT NULL,
  PRIMARY KEY (StoreOrderId, SKU),
  CONSTRAINT FK_StoreOrderDetail_StoreOrder FOREIGN KEY (StoreOrderId) REFERENCES StoreOrder(StoreOrderId),
  CONSTRAINT FK_StoreOrderDetail_Toy FOREIGN KEY (SKU) REFERENCES Toy(SKU) ON UPDATE CASCADE
);

CREATE TABLE Receipt (
  ReceiptId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CreateDate date NOT NULL,
  Status nvarchar(50) NOT NULL,
  StoreOrderId int UNIQUE NOT NULL,
  StaffId nchar(10) NOT NULL,
  CONSTRAINT FK_Receipt_StoreOrder FOREIGN KEY (StoreOrderId) REFERENCES StoreOrder(StoreOrderId),
  CONSTRAINT FK_Receipt_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE
);

CREATE TABLE ReceiptDetail (
  ReceiptId int NOT NULL,
  SKU nchar(10) NOT NULL,
  Price DOUBLE NOT NULL,
  Quantity int NOT NULL,
  PRIMARY KEY (ReceiptId, SKU),
  CONSTRAINT FK_ReceiptDetail_Receipt FOREIGN KEY (ReceiptId) REFERENCES Receipt(ReceiptId),
  CONSTRAINT FK_ReceiptDetail_Toy FOREIGN KEY (SKU) REFERENCES Toy(SKU) ON UPDATE CASCADE
);

CREATE TABLE CustomerOrder (
  CustomerOrderId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Status nvarchar(50) NOT NULL,
  OrderDate date NOT NULL,
  FristName nvarchar(50) NOT NULL,
  LastName nvarchar(50) NOT NULL,
  Phone nvarchar(20) NOT NULL,
  Address nvarchar(255) NOT NULL,
  StaffId nchar(10) NOT NULL,
  StaffIdDeliver nchar(10),
  CustomerId int NOT NULL,
  CONSTRAINT FK_CustomerOrder_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE,
  CONSTRAINT FK_CustomerOrder_Staff_Deliver FOREIGN KEY (StaffIdDeliver) REFERENCES Staff(StaffId) ON UPDATE CASCADE,
  CONSTRAINT FK_CustomerOrder_Customer FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId)
);

CREATE TABLE CustomerOrderDetail (
  CustomerOrderId int NOT NULL,
  SKU nchar(10) NOT NULL,
  Quantity int NOT NULL,
  Price DOUBLE NOT NULL,
  PRIMARY KEY (CustomerOrderId, SKU),
  CONSTRAINT FK_CustomerOrderDetail_CustomerOrder FOREIGN KEY (CustomerOrderId) REFERENCES CustomerOrder(CustomerOrderId),
  CONSTRAINT FK_CustomerOrderDetail_Toy FOREIGN KEY (SKU) REFERENCES Toy(SKU) ON UPDATE CASCADE
);

CREATE TABLE Bill (
  BillId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CreateDate date NOT NULL,
  Tax decimal(10, 2),
  FristName nvarchar(50) NOT NULL,
  LastName nvarchar(50) NOT NULL,
  CustomerOrderId int UNIQUE NOT NULL,
  StaffId nchar(10) NOT NULL,
  CONSTRAINT FK_Bill_CustomerOrder FOREIGN KEY (CustomerOrderId) REFERENCES CustomerOrder(CustomerOrderId),
  CONSTRAINT FK_Bill_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE
);

CREATE TABLE Promotion (
  PromotionId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name nvarchar(255) NOT NULL,
  DateStart date NOT NULL,
  DateEnd date NOT NULL,
  StaffId nchar(10) NOT NULL,
  CONSTRAINT FK_Promotion_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE
);

CREATE TABLE PromotionDetail (
  PromotionId int NOT NULL,
  SKU nchar(10) NOT NULL,
  PercentDiscount double NOT NULL,
  PRIMARY KEY (PromotionId, SKU),
  CONSTRAINT FK_PromotionDetail_Promotion FOREIGN KEY (PromotionId) REFERENCES Promotion(PromotionId),
  CONSTRAINT FK_PromotionDetail_Toy FOREIGN KEY (SKU) REFERENCES Toy(SKU) ON UPDATE CASCADE
);

CREATE TABLE ReturnOrder (
  ReturnOrderId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Date date NOT NULL,
  Reason nvarchar(255) NOT NULL,
  CustomerOrderId int NOT NULL,
  StaffId nchar(10) NOT NULL,
  CONSTRAINT FK_ReturnOrder_CustomerOrder FOREIGN KEY (CustomerOrderId) REFERENCES CustomerOrder(CustomerOrderId),
  CONSTRAINT FK_ReturnOrder_Staff FOREIGN KEY (StaffId) REFERENCES Staff(StaffId) ON UPDATE CASCADE
);

CREATE TABLE ReturnOrderDetail (
  ReturnOrderId int NOT NULL,
  CustomerOrderId int NOT NULL,
  SKU nchar(10) NOT NULL,
  Quantity int,
  PRIMARY KEY (ReturnOrderId, CustomerOrderId, SKU),
  CONSTRAINT FK_ReturnOrderDetail_ReturnOrder FOREIGN KEY (ReturnOrderId) REFERENCES ReturnOrder(ReturnOrderId),
  CONSTRAINT FK_ReturnOrderDetail_CustomerOrder FOREIGN KEY (CustomerOrderId, SKU) REFERENCES CustomerOrderDetail(CustomerOrderId, SKU)
);