CREATE TABLE `acceptedorders` (
  `acceptedOrdersId` int NOT NULL AUTO_INCREMENT,
  `orderId` int DEFAULT NULL,
  `tailorId` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `expectedDate` date DEFAULT NULL,
  PRIMARY KEY (`acceptedOrdersId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `adminmaster` (
  `adminId` varchar(30) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dresscategorymaster` (
  `categoryId` int NOT NULL AUTO_INCREMENT,
  `dressCategoery` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dresstypemaster` (
  `dressTypeId` int NOT NULL AUTO_INCREMENT,
  `dressType` varchar(50) DEFAULT NULL,
  `categoryId` int DEFAULT NULL,
  `dressKind` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`dressTypeId`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `dresstypemaster_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `dresscategorymaster` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `feedback` (
  `feedbackId` int NOT NULL AUTO_INCREMENT,
  `feedbackDate` date DEFAULT NULL,
  `orderId` varchar(20) DEFAULT NULL,
  `userId` varchar(20) DEFAULT NULL,
  `answer1` varchar(20) DEFAULT NULL,
  `tailorId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `customerId` varchar(50) DEFAULT NULL,
  `fabric` varchar(50) DEFAULT NULL,
  `materialType` varchar(50) DEFAULT NULL,
  `topLengths` double DEFAULT NULL,
  `neck` double DEFAULT NULL,
  `topwaist` double DEFAULT NULL,
  `chest` double DEFAULT NULL,
  `shoulderLength` double DEFAULT NULL,
  `bottomFabric` varchar(50) DEFAULT NULL,
  `bottomMaterialType` varchar(50) DEFAULT NULL,
  `bottomLengths` double DEFAULT NULL,
  `hip` double DEFAULT NULL,
  `kneeLength` double DEFAULT NULL,
  `comments` varchar(50) DEFAULT NULL,
  `expectedDate` date DEFAULT NULL,
  `tailorDressId` int DEFAULT NULL,
  `deliveryArea` varchar(150) DEFAULT NULL,
  `tailorId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `secretquestions` (
  `sqId` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(30) DEFAULT NULL,
  `a1` varchar(100) DEFAULT NULL,
  `a2` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `a3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sqId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tailor` (
  `tailorId` varchar(50) NOT NULL,
  `shopName` varchar(150) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `contactNo` varchar(10) DEFAULT NULL,
  `workingHours` int DEFAULT NULL,
  `courier` tinyint(1) DEFAULT NULL,
  `deliveryAddress` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`tailorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tailor_dress` (
  `tailorDressId` int NOT NULL AUTO_INCREMENT,
  `tailorId` varchar(50) DEFAULT NULL,
  `categoryId` int DEFAULT NULL,
  `dressType` varchar(30) DEFAULT NULL,
  `dressKind` varchar(30) DEFAULT NULL,
  `pattern` longblob,
  `cost` double DEFAULT NULL,
  `topWear` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tailorDressId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `userId` varchar(30) NOT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contactNo` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
