create table Resolution(
resolutionId varchar(10) primary key,
resolutionDate date,
adminId varchar(30),
resolution varchar(100),
requestId varchar(10),
Foreign key (requestId) references Help(requestId)
);

create table FeedbackQuestion(
questionId int primary key,
question varchar(45)
);

create table Feedback(
feedbackDate date,
orderId varchar(10),
userId varchar(10),
questionId int,
answer varchar(200),
foreign key(questionId) references FeedbackQuestion(questionId),
foreign key (orderId) references Orders(orderId),
foreign key (userId) references UserMaster(userId)
);