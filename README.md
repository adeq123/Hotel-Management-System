# Hotel-Management-System
Hotem Management System developed to practice SpringMVC and Hibernate skills;

Download this project from: https://github.com/adeq123/CRM-demo/

## Motivation
This respository was created as a project from Udemy Spring-Hibernate tutorial.

## General description
This is a simple Web application integrating two main technologies: Spring MVC and Hibernate It also integrates Service Fascade design pattern.  

## Detailed description & Features
The application is a simple CRUD application allowing to Create, Read, Update, Delete records fro database. It is a Web application where
you manage a list of clients (CRM - Customer Relationship Management). The database used is MySQL and Hibernate ORM is used to communicate with it.
The Architecture is described below.

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
