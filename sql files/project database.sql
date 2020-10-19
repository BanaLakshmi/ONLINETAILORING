create database projectDatabase;
use projectDatabase;


CREATE TABLE Pattern(
patternId int PRIMARY KEY, 
pattern varchar(200),  
cost double);
          
      




CREATE TABLE Tailor(tailorId int AUTO_INCREMENT PRIMARY KEY, 
shopName varchar(150), 
address varchar(150) , 
contactNo varchar(10), 
workingHours int, 
courier boolean);



 CREATE TABLE TopMeasurement(topId int AUTO_INCREMENT PRIMARY KEY, 
 patternId int,
 fabric varchar(100),   
 materialType varchar(100), 
 duration int, 
 topLength double, 
 amount double,
 neck double, 
 topWaist double,  
 chest double, 
 shoulderLength double,
 FOREIGN KEY(patternId) references Pattern(patternId)
 );
 create table Resolution(
resolutionId int primary key auto_increment,
resolutionDate date,
adminId int,
resolution varchar(100),
requestId varchar(10),
Foreign key (requestId) references Help(requestId),
Foreign key (adminId) references AdminMaster(adminId)
);

create table FeedbackQuestion(
questionId int primary key auto_increment,
question varchar(45)
);

create table Feedback(
 feedbackId int primary key auto_increment,
feedbackDate date,
orderId int,
userId int,
questionId int,
answer int,
foreign key(questionId) references FeedbackQuestion(questionId),
foreign key (orderId) references Orders(orderId),
foreign key (userId) references UserMaster(userId)
);

create table UserMaster
( userId int primary key auto_increment,
 username varchar(20),
password varchar(10),
firstName varchar(20),
lastName varchar(20),
dob Date,
gender varchar(10),
contactNo varchar(10),
email varchar(20),
userCategory varchar(10)
);

create table AdminMaster
(
adminId int primary key,
adminName varchar(30),
 password varchar(10)
);

create table Help
(
requestId varchar(10) primary key,
issue varchar(100),
description varchar(1000),
dateOfTicket Date
);
CREATE TABLE BottomMeasurement (
    bottomId int AUTO_INCREMENT PRIMARY KEY,
patternId int,
    fabric varchar(100),
    materialType varchar(100),
    durationInDays int,
    amount double,
    bottomLength double,
    hip double,
    kneeLength double,
    FOREIGN KEY (patternId) references Pattern(patternId)
);

CREATE TABLE Orders (
userId int,
    orderId int PRIMARY KEY AUTO_INCREMENT  ,
    orderDate date,
    billAmount float,
    acceptedDate date,
    expectedDelivery date,
    status varchar(200),
    paymentOption varchar(255),
    typeOfDelivery varchar(255),
    paymentStatus varchar(100),
    actualDelivary date,
    FOREIGN KEY (userId) references UserMaster(userId)
);


CREATE TABLE Bill (
orderId int,
    billId int AUTO_INCREMENT PRIMARY KEY,
    billDate date,
    billAmount double,
   FOREIGN KEY (orderId) references Orders(orderId)
);
create table DressCategoryMaster(
categoryId INT primary key auto_increment ,
dressCategoery varchar(50)
);
create table DressKindMaster(
dressKindId int primary key auto_increment,
dressKind varchar(50)
);
 create table DressTypeMaster(
dressTypeId int primary key auto_increment,
dressType varchar(50),
categoryId int ,
dressKindId int,
patternId int,
FOREIGN KEY (categoryId) references DressCategoryMaster(categoryId),
FOREIGN KEY (dressKindId) references DressKindMaster(dressKindId),
FOREIGN KEY (patternId) references Pattern(patternId)
);
create table SecretQuestions(
sqId int primary key auto_increment,
usedId int,
answer1 varchar(100),
answer2 varchar(100),
answer3 varchar(100));

