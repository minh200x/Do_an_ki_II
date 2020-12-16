create database QuanLyKhachSan
go
use QuanLyKhachSan
go

create table tblRoom(
	roomId int identity(1,1) primary key not null,
	type int not null,
	price float not null,
	image nvarchar(255) null,
	descript text null,
	status tinyint default(0)
)
go


create table tblLevel(
	id int identity(1,1) primary key not null,
	name nvarchar(255) not null
)
go

create table tblUser(
	id int primary key not null,
	username nvarchar(255) not null,
	password nvarchar(255) not null,
	levelId int foreign key references tblLevel(id) not null,
	fullname nvarchar(255) not null,
	phone nvarchar(255) null,
	address nvarchar(255) null,
	image nvarchar(255) null,
	gender bit null,
	birthday date null,
	descript text null,
	status tinyint default(0),
	startDate date not null,
	endDate date not null
)
go

create table tblCustomer(
	phone nvarchar(255) primary key not null,
	fullname nvarchar(255) not null,
	email nvarchar(255) null,
	address nvarchar(255) null,
	gender bit null,
	numIdentityCard int not null,
	descrip text null,
	createdAt date not null,
	updatedAt date not null
)
go

create table tblCupon(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	discount float not null,
	maxQuantity int null,
	status tinyint default(0) not null,
	createdAt date not null,
	updatedAt date not null
)
go

create table tblCheckin(
	id int identity(1,1) primary key not null,
	cusPhone nvarchar(255) foreign key references tblCustomer(phone) not null,
	totalPeople int not null,
	cuponId int foreign key references tblCupon(id) not null,
	totalMoney float not null,
	totalServicePrice float not null,
	descript text null,
)
go

create table tblCheckinDetails(
	detailId int identity(1,1) primary key not null,
	checkinId int foreign key references tblCheckin(id),
	roomId int foreign key references tblRoom(roomId) not null,
	totalServicePrice float default(0) not null,
	price float not null,
	startDate date not null,
	endDate date not null,
	status tinyint default(1) not null
)
go

create table tblCategoryService(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null
)
go


create table tblUnit(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null
)
go

create table tblService(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	price float not null,
	unit int foreign key references tblUnit(id) not null,
	catService int foreign key references tblCategoryService(id) not null
)
go

create table tblCheckinServiceDetails(
	idServicee int foreign key references tblService(id) not null,
	idCheckinDetails int foreign key references tblCheckinDetails(detailId),
	quantity int not null,
	price float not null
)
go

create table tblProduct(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	quantity int not null
)
go

create table tblCheckoutProductDetails(
	model nvarchar(255) primary key not null,
	proId int foreign key references tblProduct(id) not null,
	roomId int foreign key references tblRoom(roomId) not null,
	descript text null,
	status tinyint default(0)
)
go
