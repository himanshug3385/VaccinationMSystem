<h1>Vaccine Management System</h1>
<p>This project is a backend service for a Vaccine Management System built using Spring Boot. It manages citizen information, vaccination details, and dose records.</p>
<h2>Table of Contents</h2>
<ul>
    <li><a href="#database-schema">Database Schema</a></li>
    <li><a href="#apis">APIs</a>
        <ul>
            <li><a href="#citizen-apis">Citizen APIs</a></li>
            <li><a href="#vaccine-apis">Vaccine APIs</a></li>
            <li><a href="#dose-apis">Dose APIs</a></li>
        </ul>
    </li>
        <li><a href="#getting-started">Getting Started</a></li>
        <li><a href="#contributing">Contributing</a></li>
        <li><a href="#license">License</a></li>
    </ul>
<!-- <h2>DashBoard Page</h2> -->

![image](https://github.com/user-attachments/assets/f1157f9a-7066-44ff-94c2-4596fb023bb4)
<hr/>
<h2>Registration Page</h2>

![image](https://github.com/user-attachments/assets/76c05b4b-ffe6-4423-9efc-fa354152ab65)
<hr/>
<h2>Citizen List Page</h2>

![image](https://github.com/user-attachments/assets/cbb3be1f-12b0-4f79-942b-a973e2d3485c)
<hr/>
<h2>Dose List</h2>

![image](https://github.com/user-attachments/assets/276633ea-eff5-4bb6-986c-d47d0764208c)

<hr/>
<h2>Take Dose Page</h2>

![image](https://github.com/user-attachments/assets/ef70d820-3e96-45e5-a988-771e3f08ad5f)

## Application Architecture 
<pre>
+-------------------------+           +---------------------------+
|    Web Interface        |           |  External Systems/Services |
|-------------------------|           |---------------------------|
|  - Dashboard Page       |           |  (e.g., Notification)      |
|  - Citizen Page         |           |                           |
|  - Citizen Details Page |           |                           |
|  - Registration Page    |           |                           |
|  - Take Dose Page       |           |                           |
+-----------+-------------+           +-----------+---------------+
            |                                    |
            v                                    |
+-----------+------------------------------------+-----------------+
|                  ViewController (Frontend)                        |
|------------------------------------------------------------------|
|  - Handles frontend logic and UI interactions                     |
|  - Communicates with backend controllers via HTTP requests         |
|  - Renders data for user interactions and display                  |
+-----------+---------------------+--------------------+-------------+
            |                     |                    |
            v                     v                    v
+-----------+-----------+ +-------+----------+ +-------+----------+
|   VaccineController   | |  DoseController  | |  CitizenController |
|------------------------| |-------------------| |---------------------|
|  - GET /api/vaccine    | |  - GET /api/dose  | |  - GET /api/citizen |
|  - GET /api/vaccine/{id}| |  - GET /api/dose/{id}| |  - GET /api/citizen/{id}|
|  - PUT /api/vaccine/{id}| |  - DELETE /api/dose/{id}| |  - POST /api/citizen/register|
|  - GET /api/vaccine/certificate/{id}| |  - GET /api/dose/details/{id}| |  - DELETE /api/citizen/{id} |
|                        | |  - Other Dose APIs| |  - GET /api/citizens/status/{status} |
+-----------+------------+ +------------------+ +---------------------+
            |                                |
            v                                v
+-----------+---------------------------------+
|                   Spring Boot Application                      |
|------------------------------------------------------------------|
|  - Contains logic for controllers and services                  |
|  - Delegates requests to appropriate services                    |
+-----------+---------------------------------+
            |
            v
+-----------+---------------------------+     +---------------+-------------+
|              Database (Schema)        |     |           External APIs       |
|---------------------------------------|     |                               |
|   +----------------+   +-------------+ |     |  (e.g., Third-Party APIs)     |
|   |   Citizen Table|   |  Vaccine Table| |     +------------------------------+
|   +----------------+   +-------------+ | 
|   | - Citizen_ID   |   | - Certificate_No| |
|   | - Name         |   | - Citizen_ID   | |
|   | - Gender       |   | - Dose1_ID     | |
|   | - Age          |   | - Dose2_ID     | |
|   | - Contact      |   | - Dose3_ID     | |
|   | - Aadhar       |   | - Address      | |
|   | - Status       |   +---------------+ |
|   | - Last_Vaccinated|                   |
|   +----------------+                     |
|                                          |
|   +----------------+                    |
|   |    Dose Table  |                    |
|   +----------------+                    |
|   | - Citizen_ID   |                    |
|   | - Dose_ID      |                    |
|   | - Dose_Name    |                    |
|   | - Vaccinated_By|                    |
|   | - Dose_Date    |                    |
|   +----------------+                    |
+------------------------------------------+
</pre>

### Functionalities

1. **Citizen Registeration**
    - Allows you to register new citizen to the system.

2. **Show Citizen and Vaccines**
    - Displays a list of citizens along with their vaccination details.

3. **Update Status**
    - Automatically updates a citizen's vaccination status to "fully" or "Partially" or "Boosted" if they have received more than 2 doses.

4. **Add Dose to Particular Citizen**
    - Functionality to add a new dose to a specific citizen.

5. **Give Dose After 120 Days**
    - Enforces a minimum gap of 120 days between doses before administering another dose.

6. **Delete Citizen**
    - Ability to delete a citizen from the system.

7. **Same Dose Equality Check**
    - Ensures that the vaccine dose type administered is the same as the previous dose type.

<h2 id="database-schema">Database Schema</h2>

<h3>Citizen Table</h3>
<pre><code>CREATE TABLE Citizen (
Citizen_ID VARCHAR(50) PRIMARY KEY,             
Name VARCHAR(50) NOT NULL,                    
Gender VARCHAR(50),                          
Age INT,                                      
Contact VARCHAR(50),                         
Aadhar VARCHAR(50) UNIQUE,                   
Vaccination_Status VARCHAR(50),               
Last_Vaccinated VARCHAR(50)                        
    );</code></pre>

<h3>Vaccine Table</h3>
<pre><code>CREATE TABLE Vaccine (
Certificate_No VARCHAR(50),
Citizen_ID VARCHAR(50), 
Dose1_ID VARCHAR(50),
Dose2_ID VARCHAR(50),
Dose3_ID VARCHAR(50),
Vaccination_Address VARCHAR(50)
);</code></pre>

<h3>Dose Table</h3>
<pre><code>CREATE TABLE Dose (
Citizen_ID VARCHAR(50),
Dose_ID VARCHAR(50), 
Dose_Name VARCHAR(50),
Vaccinated_By VARCHAR(50),
Dose_Date VARCHAR(50)
);</code></pre>

<h2>Insertion Example - </h2>
<h4>INSERT INTO Citizen (Citizen_ID, Name, Gender, Age, Contact, Aadhar, Vaccination_Status, Last_Vaccinated)
VALUES ('001', 'Himanshu Gupta', 'Male', 22, '1234567890', '12345678901', 'Fully', TO_DATE('2008-11-11', 'YYYY-MM-DD'));</h4>

<h2 id="apis">Backend APIs</h2>

<h3 id="citizen-apis">Citizen APIs</h3>
<ul>
    <li>GET /api/citizen - Retrieve all citizens</li>
    <li>GET /api/citizen/{citizenId} - Retrieve a specific citizen by ID</li>
    <li>POST /api/citizen/register - Register a new citizen</li>
    <li>DELETE /api/citizen/{citizenId} - Delete a citizen by ID</li>
    <li>GET /api/citizen/status/{citizenId} - Retrieve vaccination status of a specific citizen</li>
    <li>GET /api/citizens/status/{status} - Retrieve citizens by vaccination status</li>
</ul>

<h3 id="vaccine-apis">Vaccine APIs</h3>
<ul>
    <li>GET /api/vaccine - Retrieve all vaccine records</li>
    <li>GET /api/vaccine/certificate/{citizenId} - Retrieve vaccination certificate by citizen ID</li>
    <li>GET /api/vaccine/{citizenId} - Retrieve vaccine record by citizen ID</li>
    <li>PUT /api/vaccine/{citizenId} - Update vaccine record by citizen ID</li>
</ul>

<h3 id="dose-apis">Dose APIs</h3>
<ul>
    <li>GET /api/dose/{citizenId} - Retrieve dose records by citizen ID</li>
    <li>GET /api/dose/details/{doseId} - Retrieve dose details by dose ID</li>
    <li>DELETE /api/{doseId} - Delete a dose record by dose ID</li>
</ul>

<h2>View APIS</h2>
<ul>
    <li>GET /view =  DashBoard Page</li>
    <li>GET /view/citizen = All Citizen Page</li>
    <li>GET /view/citizen/{citizenId} = Citizen Details Updation Page</li>
    <li>GET /view/citizen/registeration = Citizen Registration Page </li>
    <li>GET /view/vaccine/update = Take Dose Page</li>
</ul>
<hr>
<h2 id="getting-started">Getting Started</h2>
<p>To get a local copy up and running follow these simple steps.</p>

<h3>Prerequisites</h3>
<ul>
    <li>Java 17 or higher</li>
    <li>Maven</li>
    <li>Oracle Database</li>
</ul>

<h3>Installation</h3>
<ol>
    <li>Clone the repo
    <pre><code>git clone https://github.com/himanshug3385/VaccinationMSystem.git</code></pre>
    </li>
    <li>Install Maven dependencies
        <pre><code>mvn install</code></pre>
    </li>
    <li>Configure the database in <code>application.properties - change you db name and Password, Otherwise project will not run</code></li>
    <li>Run the application
        <pre><code>mvn spring-boot:run</code></pre>
    </li>
    </ol>

<h2 id="contributing">Contributing</h2>
<p>Contributions make the open-source community such an amazing place to learn, inspire, and create. I appreciate your contributions.</p>
<ol>
    <li>Fork the Project</li>
    <li>Create your Feature Branch (<code>git checkout -b feature/AmazingFeature</code>)</li>
    <li>Commit your Changes (<code>git commit -m 'Add some AmazingFeature'</code>)</li>
    <li>Push to the Branch (<code>git push origin feature/AmazingFeature</code>)</li>
    <li>Open a Pull Request</li>
</ol>

<h2 id="license">License</h2>
<p>Distributed under the MIT License. See <code>LICENSE</code> for more information.</p>
