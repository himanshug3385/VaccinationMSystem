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



CREATE TABLE Vaccine (
Certificate_No varchar(15),
Citizen_ID varchar(12), 
Dose1_ID varchar(12),
Dose2_ID varchar(12),
Dose3_ID varchar(12),
Vaccination_Address varchar(20)
);

CREATE TABLE Dose (
Citizen_ID varchar(12),
Dose_ID varchar(12), 
Dose_Name varchar(20),
Vaccinated_By varchar(20),
Dose_Date VARCHAR(30)
);
