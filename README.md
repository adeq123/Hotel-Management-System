# Hotel-Management-System
The application allows to manage a small hotel. You can check in, checkout guests as well as view, print, email the bill. Room management is included. The app gives you good overview on what is happening in the hotel and shows you the actions that needs to be taken in the nearest future (To Do List). The database used is MySQL and Hibernate ORM is utilized to communicate with it. Spring MVC technology is integrated in the project

Download this project from: https://github.com/adeq123/CRM-demo/

## Motivation
This project developed to practice my SpringMVC and Hibernate skills.

## General description
This is a Web application integrating two main technologies: Spring MVC and Hibernate. It also inculdes Service Fascade design pattern.  
## Detailed description & Features
The application starts with Login page. You have to registered user to use the programme. If credentails entered are not correct then you will be informed about that fact. 

![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/login.png)
### Architecture

The browser sends the request to the Controller (Spring MVC). The controller find the method based on mapping specified (eg. @ReguestMapping).
In this specific application, the method will communicate with Service Fascade Object which will delegate the request to DAO object. DAO is 
responsible for communication with database. If there is any result to return. DAO will pass to Controller through service layer. The Controller
will return appropriate view and model to the browser.
![](https://github.com/adeq123/CRM-demo/blob/master/web-customer-tracker/img/appArchtecture1.png)

## Concepts used

Java EE, Spring, Spring MVC, Hibernate, MySQL
Service Fascade design pattern, DAO (Data Access Object), Data binding

## Author

Adrian Roguski with gudience included on Udemy Spring-Hibernate tutorial

## Screenshots

![](https://github.com/adeq123/CRM-demo/blob/master/web-customer-tracker/img/customerList.png)

Welcome screen with list of customers. Search for customers tool is on the top.

![](https://github.com/adeq123/CRM-demo/blob/master/web-customer-tracker/img/addCustomer.png)

Add customer panel. Used also for updates (it is pre-filed then) 

![](https://github.com/adeq123/CRM-demo/blob/master/web-customer-tracker/img/deleteCustomer.png)

Message shown when you try to delete the record.

## Bugs
No input validation.
