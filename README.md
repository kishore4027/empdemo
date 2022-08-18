# empdemo
 Sample Demo applocatio with Rest base implementation using Spring Boot.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#web)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
* [Validation](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#io.validation)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

###Page Navigation
THe Following Guides the how to run the application:
* {it has embedded server to run and H2 database is as in memory database
* Setp1 :Run The application as Spring Boot Application 
* Step2 :Access the application by hitting http://localhost:8080/api/ 
* Step3 :Access the H2 Database by hitting http://localhost:8080/api/h2-console/
		 The JdBc Url is : jdbc:h2:mem:db username :sa and password is password.
* step4 : Navigationg App: 
              By hitting url at step2 above welcome page with basic Rest base UI Shows with following details
              Buttons to Access:
                GET: add id(find from # col of Table) in the from click Info to get result if exist.
                CREATE: form to create new Entry all are mandatory.
                UPDATE: At Employee ID Text Field add # value and update remaining employee details and submit
                DELETE: add id(find from # col of Table) in the from click Delete and then Fetch all to see the changes
                DELETE ALL: Click it and click on Fetch All
                FETCH ALL: Click it to get available all Employee details
                Search: (Employee no and Employee Name) or EmployeeNo or EmployeeName is based Search available and it results in below table. 
                Table with below columns to above Button action Results.
                #	EmployeeNo	Name	DateOfJoining	DepartMent	Salary
                
                #- repesents record Id
                EmployeeNo - employee no 
                Name -Employee Name
                Date Of Joining - date in dd/MM/yyyy format
                Department - Department with below options
                	Code	Description
				 	AD	Administration
				 	IT	Information technology
				 	HD	Help Desk
				 	HR	Human Resource
				 	OP	Operation
                
                
                
                
                


