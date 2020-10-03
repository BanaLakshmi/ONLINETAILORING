CREATE DATABASE mydb124;
USE mydb124;
create table DressCategoryMaster(
categoryId INT primary key ,
dressCategoery varchar(50)
);
create table DressKindMaster(
dressKindId int primary key,
dressKind varchar(50)
);
 create table DressTypeMaster(
dressTypeId int primary key,
dressType varchar(50),
dressCategory varchar(50) ,
dressKind varchar(50),
pattern varchar(50),
FOREIGN KEY (dressCategory) refrences DressCategoryMaster(dressCategoery),
FOREIGN KEY (dressKind) refrences DressKindMaster(dressKind),
FOREIGN KEY (pattern) refrences Pattern(pattern)
);