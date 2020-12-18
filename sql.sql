create database QuanLyKhachSan
go
use QuanLyKhachSan
go

create table tblRoomPrice(
	id int identity(1,1) primary key not null,
	price float not null
)

create table tblRoom(
	roomId int identity(1,1) primary key not null,
	typeId int foreign key references tblRoomPrice(id) not null,
	image nvarchar(255) null,
	descript text null,
	status tinyint default(0)
)
go

ALTER TABLE tblRoom
ADD UNIQUE (roomId);


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
	descript text null,
	createdAt date not null,
	updatedAt date not null
)
go

ALTER TABLE tblCustomer
ADD UNIQUE (phone);


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

--------------------------------
-- CREATE PROCEDURE 
--------------------------------



-- PROC tblCategoryService

create proc categoryService_findAll
as
begin
	select * from tblCategoryService
end
go

create proc categoryService_insert(@name nvarchar(255))
as
begin
	insert into tblCategoryService(name) values(@name)
end
go

create proc categoryService_delete(@id int)
as
begin
	delete from tblCategoryService where id = @id
end
go

create proc categoryService_update(@id int, @name nvarchar(255))
as
begin
	update tblCategoryService set name=@name where id = @id
end
go


-- PROC tblUser

create proc user_insert(@username nvarchar(255),
						@password nvarchar(255),
						@fullname nvarchar(255),
						@levelId int,
						@phone nvarchar(255),
						@address nvarchar(255),
						@image nvarchar(255),
						@gender bit,
						@birthday date,
						@descript text,
						@startDate date,
						@endDate date,
						@status tinyint)
as
begin
	insert into tblUser(username, password, fullname, levelId, phone, address, image, gender, birthday, descript, startDate, endDate, status)
	values(@username, @password, @fullname, @levelId, @phone, @address, @image, @gender, @birthday, @descript, @startDate, @endDate, @status)
end
go


create proc user_update(@id int,
						@username nvarchar(255),
						@password nvarchar(255),
						@fullname nvarchar(255),
						@levelId int,
						@phone nvarchar(255),
						@address nvarchar(255),
						@image nvarchar(255),
						@gender bit,
						@birthday date,
						@descript text,
						@startDate date,
						@endDate date,
						@status tinyint)
as
begin
	update tblUser set username=@username, password=@password, fullname=@fullname, levelId=@levelId, phone=@phone, address=@address, image=@image, 
	gender=@gender, birthday=@birthday, descript=@descript, startDate=@startDate, endDate=@endDate, status=@status
	where id=@id
end
go


create proc user_delete(@id int)
as
begin
	delete from tblUser where id=@id
end
go


create proc user_findAll
as
begin
	select * from tblUser
end
go


create proc user_findByUsername(@username nvarchar(255))
as
begin
	select * from tblUser where username like '%' + @username + '%'
end
go


create proc user_findByFullname(@fullname nvarchar(255))
as
begin
	select * from tblUser where username like '%' + @fullname + '%'
end
go


create proc user_findByPhone(@phone nvarchar(255))
as
begin
	select * from tblUser where username like '%' + @phone + '%'
end
go



-- PROC tblRoom

create proc room_insert(@roomId int,
						@typeId int,
						@image nvarchar(255),
						@descript text,
						@status tinyint)
as
begin
	insert into tblRoom(roomId, typeId, image, descript, status) 
	values(@roomId, @typeId, @image, @descript, @status)
end
go


create proc room_delete(@roomId int)
as
begin
	delete from tblRoom where roomId=@roomId
end
go

create proc room_update(@roomId int,
						@typeId int,
						@image nvarchar(255),
						@descript text,
						@status tinyint)
as
begin
	update tblRoom set typeId=@typeId, image=@image, descript=@descript, status=@status
	where roomId=@roomId
end
go

create proc room_findAll
as
begin
	select * from tblRoom
end
go



-- PROC tblProduct

create proc product_insert(	@name nvarchar(255),
							@quantity int)
as
begin
	insert into tblProduct(name, quantity) values(@name, @quantity)
end
go


create proc product_delete(@id int)
as
begin
	delete from tblProduct where id=@id
end
go

create proc product_update(@id int,
							@name nvarchar(255),
							@quantity int)
as
begin
	update tblProduct set name=@name, quantity=@quantity where id=@id
end
go

create proc product_findAll
as
begin
	select * from tblProduct
end
go



-- PROC tblCustomer

create proc customer_insert(@phone nvarchar(255),
							@fullname nvarchar(255),
							@email nvarchar(255),
							@address nvarchar(255),
							@gender bit,
							@numIdentityCard int,
							@descript text,
							@createdAt date,
							@updatedAt date)
as
begin
	insert into tblCustomer(phone, fullname, email, address, gender, numIdentityCard, descript, createdAt, updatedAt)
	values(@phone, @fullname, @email, @address, @gender, @numIdentityCard, @descript, @createdAt, @updatedAt)
end
go


create proc customer_delete(@phone nvarchar)
as
begin
	delete from tblCustomer where phone=@phone
end
go

create proc customer_update(@phone nvarchar(255),
							@fullname nvarchar(255),
							@email nvarchar(255),
							@address nvarchar(255),
							@gender bit,
							@numIdentityCard int,
							@descript text,
							@createdAt date,
							@updatedAt date)
as
begin
	update tblCustomer set phone=@phone, fullname=@fullname, email=@email, address=@address, gender=@gender, numIdentityCard=@numIdentityCard,
							descript=@descript, createdAt=@createdAt, updatedAt=@updatedAt
	where phone=@phone
end
go


create proc customer_findAll
as
begin
	select * from tblCustomer
end
go


create proc customer_findByPhone(@phone nvarchar(255))
as
begin
	select * from tblCustomer where phone like '%' + @phone + '%'
end
go



-- PROC tblCupon

create proc cupon_insert(@name nvarchar(255),
						@discount float,
						@maxQuantity int,
						@status bit,
						@createdAt date,
						@updatedAt date)
as
begin
	insert into tblCupon(name, discount, maxQuantity, status, createdAt, updatedAt)
	values(@name, @discount, @maxQuantity, @status, @createdAt, @updatedAt)
end
go


create proc cupon_update(@id int,
						@name nvarchar(255),
						@discount float,
						@maxQuantity int,
						@status bit,
						@createdAt date,
						@updatedAt date)
as
begin
	update tblCupon set name=@name, discount=@discount, maxQuantity=@maxQuantity, status=@status, createdAt=@createdAt, updatedAt=@updatedAt
	where id=@id
end
go


create proc cupon_delete(@id int)
as
begin
	delete from tblCupon where id=@id
end
go


create proc cupon_findAll
as
begin
	select * from tblCupon
end
go


create proc cupon_findByPhone(@id int)
as
begin
	select * from tblCupon where id like '%' + @id + '%'
end
go



-- PROC tblCheckin

create proc checkin_insert(@cusPhone nvarchar(255),
							@totalPeople int,
							@cuponId int,
							@totalMoney float,
							@totalServicePrice float,
							@descript text)
as
begin
	insert into tblCheckin(cusPhone, totalPeople, cuponId, totalMoney, totalServicePrice, descript)
	values(@cusPhone, @totalPeople, @cuponId, @totalMoney, @totalServicePrice, @descript)
end
go


create proc checkin_delete(@id int)
as
begin
	delete from tblCheckin where id=@id
end
go

create proc checkin_findAll
as
begin
	select * from tblCheckin
end
go



-- PROC tblService

create proc service_insert(@name nvarchar(255),
							@price float,
							@unit int,
							@catService int)
as
begin
	insert into tblService(name, price, unit, catService) values(@name, @price, @unit, @catService)
end
go


create proc service_delete(@id int)
as
begin
	delete from tblService where id=@id
end
go


create proc service_update(@id int,
							@name nvarchar(255),
							@price float,
							@unit int,
							@catService int)
as
begin
	update tblService set name=@name, price=@price, unit=@unit, catService=@catService where id=@id
end
go


create proc service_findAll
as
begin
	select * from tblService
end
go




-- PROC tblCheckinDetails

create proc checkinDetails_insert(@detailId int,
									@checkinId int,
									@roomId int,
									@totalServicePricee float,
									@price float,
									@startDate date,
									@endDate date,
									@status int)
as
begin
	insert into tblCheckinDetails(detailId, checkinId, roomId, totalServicePrice, price, startDate, endDate, status)
	values(@detailId, @checkinId, @roomId, @totalServicePricee, @price, @startDate, @endDate, @status)
end
go


create proc checkinDetails_delete(@detailId int)
as
begin
	delete from tblCheckinDetails where detailId=@detailId
end
go


create proc checkinDetails_findByDetailId(@detailId int)
as
begin
	select * from tblCheckinDetails where detailId=@detailId
end
go



-- PROC tblLevel

create proc level_findAll
as
begin
	select * from tblLevel
end
go



-- PROC tblUnit

create proc lunit_findAll
as
begin
	select * from tblUnit
end
go
