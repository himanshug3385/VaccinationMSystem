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
Citizen_ID VARCHAR(12) PRIMARY KEY,             
Name VARCHAR(50) NOT NULL,                    
Gender VARCHAR(10),                          
Age INT,                                      
Contact VARCHAR(15),                         
Aadhar VARCHAR(12) UNIQUE,                   
Vaccination_Status VARCHAR(30),               
Last_Vaccinated VARCHAR(30)                        
    );</code></pre>

<h3>Vaccine Table</h3>
<pre><code>CREATE TABLE Vaccine (
Certificate_No VARCHAR(15),
Citizen_ID VARCHAR(12), 
Dose1_ID VARCHAR(12),
Dose2_ID VARCHAR(12),
Dose3_ID VARCHAR(12),
Vaccination_Address VARCHAR(20)
);</code></pre>

<h3>Dose Table</h3>
<pre><code>CREATE TABLE Dose (
Citizen_ID VARCHAR(12),
Dose_ID VARCHAR(12), 
Dose_Name VARCHAR(20),
Vaccinated_By VARCHAR(20),
Dose_Date VARCHAR(30)
);</code></pre>

<h2>Insertion Example - </h2>
<h4>INSERT INTO Citizen (Citizen_ID, Name, Gender, Age, Contact, Aadhar, Vaccination_Status, Last_Vaccinated)
VALUES ('001', 'Himanshu Gupta', 'Male', 22, '1234567890', '12345678901', 'Fully', TO_DATE('2008-11-11', 'YYYY-MM-DD'));</h4>

<h2 id="apis">APIs</h2>

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
    <li>Configure the database in <code>application.properties</code></li>
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
