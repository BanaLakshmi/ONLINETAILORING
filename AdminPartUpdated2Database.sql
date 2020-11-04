
Create database onlineTailoringStoreThree;
use onlineTailoringStoreThree;
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
primary key(requestId),
resolution varchar(10000),
userId varchar(10) 
);

create table SecretQuestions
(
userId varchar(10),
a1 varchar(10),
 a2 varchar(10),
a3 varchar(10));


create table FeedbackQuestion
(
questionId int not null auto_increment,
question varchar(100),
primary key (questionId)
);

select * from UserMaster;
select * from SecretQuestions;
select * from AdminMaster;
select * from Help;

select * from FeedbackQuestion;



