
A simple and secure Student Management REST API built with Spring Boot.  
This project includes Role-Based Authentication, Authorization, and full CRUD functionality.

-----------------------------------

# Authentication & Authorization
- Role-Based Access Control
  - ADMIN: Add, Update, Delete Students
  - USER: View Student Details
- BCrypt password encryption
- Public and Secure endpoints

#  CRUD Operations
- Add Student  
- View Student  
- Update Student  
- Delete Student  

----------------------

# Test Credentials

ADMIN:
  username: farhan
  password: 1234

USER:
  username: tanvir
  password: 2312

------------------

API Endpoints

Public Endpoint:

GET	/students/public	Public

USER + ADMIN Endpoints:

GET	/students/user/{id}	View student by ID

ADMIN Endpoints: 

POST	/students/admin	        Add new student
PUT	/students/admin/{id}	Update student by ID
DELETE	/students/admin/{id}	Delete student by ID

Technologies Used

Java 17

Spring Boot

Spring Security

Spring Data JPA

H2 / MySQL

Lombok




