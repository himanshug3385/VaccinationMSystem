Vaccine Management System
This project is a backend service for a Vaccine Management System built using Spring Boot. It manages citizen information, vaccination details, and dose records.

Table of Contents
Database Schema
APIs
Citizen APIs
Vaccine APIs
Dose APIs
Getting Started
Contributing
License
Database Schema
Citizen Table
SQL

CREATE TABLE Citizen (
    Citizen_ID VARCHAR(12) PRIMARY KEY,             
    Name VARCHAR(50) NOT NULL,                    
    Gender VARCHAR(10),                          
    Age INT,                                      
    Contact VARCHAR(15),                         
    Aadhar VARCHAR(12) UNIQUE,                   
    Vaccination_Status VARCHAR(30),               
    Last_Vaccinated VARCHAR(30)                        
);
AI-generated code. Review and use carefully. More info on FAQ.
Vaccine Table
SQL

CREATE TABLE Vaccine (
    Certificate_No VARCHAR(15),
    Citizen_ID VARCHAR(12), 
    Dose1_ID VARCHAR(12),
    Dose2_ID VARCHAR(12),
    Dose3_ID VARCHAR(12),
    Vaccination_Address VARCHAR(20)
);
AI-generated code. Review and use carefully. More info on FAQ.
Dose Table
SQL

CREATE TABLE Dose (
    Citizen_ID VARCHAR(12),
    Dose_ID VARCHAR(12), 
    Dose_Name VARCHAR(20),
    Vaccinated_By VARCHAR(20),
    Dose_Date VARCHAR(30)
);
AI-generated code. Review and use carefully. More info on FAQ.
APIs
Citizen APIs
GET /api/citizen - Retrieve all citizens
GET /api/citizen/{citizenId} - Retrieve a specific citizen by ID
POST /api/citizen/register - Register a new citizen
DELETE /api/citizen/{citizenId} - Delete a citizen by ID
GET /api/citizen/status/{citizenId} - Retrieve vaccination status of a specific citizen
GET /api/citizens/status/{status} - Retrieve citizens by vaccination status
Vaccine APIs
GET /api/vaccine - Retrieve all vaccine records
GET /api/vaccine/certificate/{citizenId} - Retrieve vaccination certificate by citizen ID
GET /api/vaccine/{citizenId} - Retrieve vaccine record by citizen ID
PUT /api/vaccine/{citizenId} - Update vaccine record by citizen ID
Dose APIs
GET /api/dose/{citizenId} - Retrieve dose records by citizen ID
GET /api/dose/details/{doseId} - Retrieve dose details by dose ID
DELETE /api/{doseId} - Delete a dose record by dose ID
Getting Started
To get a local copy up and running follow these simple steps.

Prerequisites
Java 11 or higher
Maven
MySQL
Installation
Clone the repo
git clone https://github.com/your_username/vaccine-management-system.git

Install Maven dependencies
mvn install

Configure the database in application.properties
Run the application
mvn spring-boot:run
