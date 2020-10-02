PATTERN: 

CREATE TABLE Pattern(patternId int PRIMARY KEY, 
pattern String,  
cost double);
          
      


TAILOR: 

CREATE TABLE Tailor(tailorId int, 
shopName varchar(100), 
address varchar(100) , 
contactNo varchar(10), 
workingHours int, 
courier boolean);


TopMeasurement:
 CREATE TABLE TopMeasurement(topId int, 
 fabric varchar(50),   
 materialType varchar(50), 
 duration int, 
 topLength double, 
 amount double,
 neck double, 
 topWaist double,  
 chest double, 
 shoulderLength double,
 foreign key(patternId references Pattern(patternId));
      
     