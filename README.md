# Distributed_System_Project
This is a project in which I have developed a Car Hire Booking System using the JAX-RS/Jersey, Java RMI and JAXB frameworks and a Web Client page that allows the users to Create/Read/Update/Delete bookings for a specific vehicle for a given set of dates. 
The Web Client will interact with a RESTful Web Service - displayed on an Apache Tomcat Server - which acts as a RMI client to a RMI Database Server.
 

***
## Run
First and foremost, you will need to install [WAMP](http://www.wampserver.com/en/) and [Tomcat 7](https://tomcat.apache.org/download-70.cgi) and [Eclipse JEE](https://www.eclipse.org/downloads/packages/release/helios/sr2/eclipse-ide-java-ee-developers) (if not already installed). You also need to make an account on [Postman](https://www.getpostman.com) because you are going to need the browser [extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=ro) .

### 1. Clone Repo <br>
Open your terminal/cmd in the folder you wish to download the repository and execute the following <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```> git clone https://github.com/cristina1997/Emerging_Technologies_Project.git```

### 2. Create RMI <br>
Open your Eclipse JEE <br>
##### Create Java Project
      > Go to -> File -> New Project -> Other -> Java Project and type RMI as the Project Name <br>
Open your terminal/cmd in the project folder <br>
Copy the src and lib folders from the cloned repository and paste it into the RMI project that you created

##### Import Libraries
      > Go to -> File -> Properties -> Java Build Path -> Add External JARs
      > Go to -> lib - the folder copied inside the RMI project

### 3. Create REST <br>
##### Add Server
    Go to the "Servers" tab in Eclipse, and click the link to create a new server. 
    Select "Tomcat v7.0 Server" and click Next. 
    
   Browse to the Tomcat directory from Step 1 and then click Finish – "Tomcat v7.0 Server at localhost" should be displayed on the "Servers" tab. 
    
#### Create Maven
    > Go to -> File -> New Project -> Maven Project -> Next -> Next
    > Add Archetype
    Type > org.glassfish.jersey.archtype in the Group Id
    Type > jersey-quickstart-webapp in the Artifact ID 
    Type > 2.16 in the Archtype Version then click OK 
    Enter ie.gmit.sw as the Group Id (package name) 
    Enter Jersey_Rest as the Artifact Id 
    Click Finish
    
Open your terminal/cmd in the project folder <br>
Copy the src folder from the cloned repository and paste it into the RMI project that you created

#### HTTPServlet library not found ERROR
    > Go to > Properties -> Project Facets -> Runtimes and make sure that Apache Tomcat v7.0 is checked
    
### 4. MySQL Database <br>
##### Add Database
    Double click on WAMP to get it running
    Go the the hidden icons and click on WAMP
    > Go to -> MySQL -> MySQL Console
    Copy from the Database.sql and paste into the console

### 5. XML to Java Converter
    Go to Schema.xsd and notice the code there. That is the XML code that will be generated into Java code for the models
    Open your terminal/cmd in the project folder 
    > xjc -d "location of your project folder" -p gmit.Model "location of your Schema.xsd file" 
    Press Enter
    Copy the models from the location folder, where they have been created in the models package in both the RMI and REST projects

### 6. Run
#### RMI
     Right click on the RMI project
     > Go to -> Run As -> Java Application
#### REST
     Right click on the REST project
     > Go to -> Run As -> Run on Server
     
### 7. Postman
    Open Postman extension and log in. <br>
    Enter URL in the URL bar http://localhost:8080/Jersey_Rest/webapi/myresource.
    Click Headers button and enter Content-Type and Accept as headers and application/xml in value
    Select from the dropdown next to the URL text box
       -> POST - if you want to add data
       -> PUT - if you want to update data
       -> DELETE - if you want to remove data
    Select raw from the buttons available below URL text box
    Select XML (application/xml) from the dropdown
    In the textarea available below, post your request object: 
      <order>
       <orderId> - number id - </orderId>
       <date> - yyyy-mm-dd - </date>
       <car> - number car id - </car>
       <cust> - number cutstomer id - </cust>
      </order>
    Reffer to screenshots below:
##### Headers
![alt text](https://github.com/cristina1997/Distributed_System_Project/blob/master/Postman%20Screenshots/Header-Postman-POST.PNG)
##### Code
![alt text](https://github.com/cristina1997/Distributed_System_Project/blob/master/Postman%20Screenshots/Code-Postman-POST.PNG)  
      
    Hit Send.
     
