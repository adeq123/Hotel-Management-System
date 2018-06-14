# Hotel-Management-System
The application allows to manage a small hotel. You can check in, checkout guests as well as view, print, email the bill. Room management is included. The app gives you good overview on what is happening in the hotel and shows you the actions that needs to be taken in the nearest future (To Do List). The database used is MySQL and Hibernate ORM is utilized to communicate with it. Spring MVC technology is integrated in the project

Download this project from: https://github.com/adeq123/CRM-demo/

## Motivation
This project developed to practice my SpringMVC and Hibernate skills.

## General description
This is a Web application integrating two main technologies: Spring MVC and Hibernate. It also inculdes Service Fascade design pattern.  
## Detailed description & Features
### Login
The application starts with Login page. You have to be registered user to use the programme. If credentails entered are not correct then you will be informed about that fact.

![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/login.png)
![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/login1.png)

### Hotel status
After successful login, you will be welcomed by appropriate messeage in right upper corner. The Hotel Status page shows up. Here you can get a general overview on what is going on in the hotel. You can find out how many guests you have, if there are any upcomming checkouts today or tomorrow and see how many rooms are occupied or vacant. Moreover the todo list on the site is available. The list is visible on all of the pages in the appllication.

![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/hotel_status.png)

### Guests 
The upper menu is a main menu where you can select tabs. The second one is guest. After clickin you will see a table with all of the guest currently staying in the hotel and info about them. The last columne is an action column where you can select three different options:
 - checkout, after clicking selected guest will be transfered to archive, the and checkout date will be set on today
 - update, when selected you will be transfered to the form with prefilled info (based on guest selected). Here you can edit info about the guest and save it.
 - bill, after clicking you will see bill with all of the necesary info. You will be able to print the bill or send it by email.
 
 Moreover, the auxilary menu on the left side is available. Here you can choose:
 - Guest List, to see the default view with guests checked in,
 - Check in, to check in new geust to unoccupied room,
 - Check in to occupied room, to check in the guest to shared room,
 - Archived guest, to archived guest list and see/print/email the bill.
 
![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/guest.png)

### Rooms
The Rooms menu is the next one in the upper menu. As default the free rooms list is available. You can choose to check in the guest to each of the rooms by clicking the link associated with that room in the last column. Then you will be transfered to the check in form with the room preselected. After clicking on Occupied room list you will see the list as name stating. Additionally you can check out the whole room (all of the guests staying there) at once, just by clicking the link in the table.

![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/rooms.png)

![](https://github.com/adeq123/Hotel-Management-System/blob/master/Hotel-Management-System/readme_images/rooms2.png)

### Next checkouts

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
