Create database onlineTailoringStore;
use onlineTailoringStore;
create table UserMaster
( userId varchar(10) primary key,
 username varchar(20),
password varchar(10),
firstName varchar(20),
lastName varchar(20),
dob Date,
gender varchar(10),
contactNo varchar(10),
email varchar(20),
userCategory varchar(10),
secretQuestions varchar(1000)
);

create table AdminMaster
(adminId varchar(10) primary key,
 password varchar(10)
);

create table Help
(
requestId varchar(10) primary key,
issue varchar(100),
description varchar(1000),
dateOfTicket Date
);







