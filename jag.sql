create database jag;
use jag;
create table Users
( userId varchar(10),
password varchar(10),
firstName varchar(20),
lastName varchar(20),
dob Date,
gender varchar(10),
contactNo varchar(10),
email varchar(20),
category varchar(10)
);

drop table Feedback;
select * from Users;
create table Feedback(
 feedbackId int primary key auto_increment,
feedbackDate date,
orderId varchar(20),
userId varchar(20),
answer1 varchar(20),
tailorId varchar(20)
);

select*from Feedback;
create table SecretQuestions(
usedId varchar(100),
a1 varchar(100),
a2 varchar(100),
a3 varchar(100));

drop table Orders;
select*from Orders;
create table Orders(
orderId int primary key auto_increment,
dressType varchar(100),
fabric varchar(100),
materialType varchar(100),
duration varchar(100),
Toplengths varchar(100),
amount varchar(100),
neck varchar(100),
topwaist varchar(100),
chest varchar(100),
shoulderLength varchar(100),
bottomFabric varchar(100),
bottomMaterialType varchar(100),
bottomDuration varchar(100),
bottomlengths varchar(100),
bottomamout varchar(100),
hip varchar(100),
Kneelength varchar(100),
comments varchar(100),
expectedDate date
);
create table UserMaster
( userId varchar(10) primary key,
password varchar(10),
firstName varchar(20),
lastName varchar(20),
dob Date,
gender varchar(10),
email varchar(200),
contactNo varchar(10),
category varchar(10)
);

create table AdminMaster
( adminId varchar(10) primary key,
password varchar(10));
insert into AdminMaster values("a001","bana123");
create table Help
(
requestId int not null  auto_increment,
issue varchar(100),
description varchar(1000),
dateOfTicket date,
resolution varchar(10000),
primary key(requestId)
);
drop table resolution;
create table SecretQuestions
(
userId varchar(10),
a1 varchar(10),
 a2 varchar(10),
a3 varchar(10));
create table DressCategoryMaster
(
categoryId int primary key,
dressCategory varchar(100)
);
create table resolution(
resolutionId int primary key auto_increment,
resolutions varchar(1000),
foreign key (resolutionId) references Help(requestId));

select * from UserMaster;
select * from SecretQuestions;
select * from AdminMaster;
select * from Help;
select * from resolution;
CREATE TABLE Tailor_Dress(
tailorDressId int  primary key  ,
 tailorId varchar(50),
categoryId int, 
dressType varchar(30),
dressKind varchar(30),
pattern longblob not null,
cost double);
 create table DressTypeMaster(
dressTypeId int primary key auto_increment,
dressType varchar(50),
categoryId int ,
dressKidresscategorymasternd varchar(30),
FOREIGN KEY (categoryId) references DressCategoryMaster(categoryId)
);
 create table DressCategoryMaster(
categoryId INT primary key auto_increment ,
dressCategoery varchar(50)
);
CREATE TABLE Tailor(
userId int  PRIMARY KEY, 
shopName varchar(150), 
address varchar(150) , 
contactNo varchar(10), 
workingHours int, 
courier boolean);
select * from DressTypeMaster;
select * from DressCategoryMaster;
select * from Tailor;
insert into DressTypeMaster values(1,"pant",1,"chirag");
insert into DressCategoryMaster values(1,"men");