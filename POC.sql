

CREATE TABLE Car (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  kms FLOAT NOT NULL,
  numOfOwners INT NOT NULL,
  validInsurance TINYINT(1) NOT NULL,
  color VARCHAR(50) NOT NULL,
  make VARCHAR(50) NOT NULL,
  model VARCHAR(50) NOT NULL,
  price FLOAT NOT NULL,
  yearManufactured INT NOT NULL,
  version VARCHAR(50) NOT NULL
);

CREATE DATABASE BIKE_RENTAL_SYSTEM;

CREATE table CustomerDetails (
custId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
custName VARCHAR(100) NOT NULL,
custMail VARCHAR(100) NOT NULL,
custPhone bigint NOT NULL,
dlNumber VARCHAR(16) NOT NULL,
age INT NOT NULL,
password VARCHAR(10) NOT NULL,
authorities VARCHAR(10) NOT NULL
);

select * from customerDetails;

Select * From customer_details;



CREATE TABLE BikeDetails (
  bikeId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  bikeName VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  manufacturedYear INT NOT NULL,
  bikeImage BLOB,
  price INT NOT NULL,
  available boolean NOT NULL,
  branchId INT NOT NULL,
  foreign key(branchId) REFERENCES branchdetails(branchId)
);

select * from bikedetails;
ALTER TABLE BikeDetails
MODIFY COLUMN bikeImage TEXT;



select * from BikeDetails;

Select * from CustomerDetails;

delete  from CustomerDetails where custId=8;

Insert into CustomerDetails(custName,custMail,custPhone,dlNumber,age,password,authorities) values("Admin_Nuthan","adminnuthan@bikerental.com",8217576371,"KA35 4578456584",25,"Nutu@1234","admin");



CREATE TABLE BranchDetails (
  branchId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  branchName VARCHAR(255) NOT NULL,
branchAddress varchar(255) NOT NULL,
  branchPinCode INT NOT NULL
 
);



insert into branchdetails(branchName,branchAddress,branchPinCode) values("JP NAGAR","Opposite To Jayadeva Hospital",560078);
 
select * from branchdetails;

-- CREATE TABLE BookingDetails (
--     bookingId INT AUTO_INCREMENT PRIMARY KEY,
--     bikeId INT,
--     bikeName VARCHAR(255),
--     model VARCHAR(255),
--     manufacturedYear INT,
--     bikeImage LONGBLOB,
--     price DOUBLE,
--     branchId INT,
--     branchName VARCHAR(255),
--     branchAddress VARCHAR(255),
--     branchPinCode BIGINT,
--     bookingDateTime DATETIME,
--     
--     FOREIGN KEY (bikeId) REFERENCES bikeDetails(bikeId),
--     FOREIGN KEY (branchId) REFERENCES branchDetails(branchId)
-- );

CREATE TABLE BookingDetails (
    bookingId VARCHAR(50) PRIMARY KEY,
    bookedTime TIMESTAMP,
    custId INT,
    bikeId INT,
    branchId INT,
    returnStatus boolean,
    FOREIGN KEY (custId) REFERENCES CustomerDetails (custId),
    FOREIGN KEY (bikeId) REFERENCES BikeDetails (bikeId),
    FOREIGN KEY (branchId) REFERENCES BikeDetails (branchId)
);

select * from bookingdetails;




select * from bookingdetails;

CREATE TABLE paymentDetails (
    paymentId INT AUTO_INCREMENT PRIMARY KEY ,
    bookingId VARCHAR(50),
    branchId INT,
    paymentTime TIMESTAMP,
    paymentAmount DECIMAL(10,2),
    paymentMode VARCHAR(50),
    FOREIGN KEY (bookingId) REFERENCES BookingDetails (bookingId),
    FOREIGN KEY (branchId) REFERENCES BikeDetails (branchId)
);

select * from paymentdetails;

ALTER TABLE bookingdetails
ADD CONSTRAINT bookingdetails_ibfk_1
FOREIGN KEY (custId)
REFERENCES customerdetails (custId)
ON DELETE CASCADE
ON UPDATE CASCADE;

