# Library Management System
This project is a system for library management.  

## Main Components
* ### Admin 
* ### User
* ### Book
The admin can do some functions such as adding books.  
The user can search for a book, buy and show existing books.
## Design
This is the class diagram :  

![](https://github.com/Mohamad-Khalid/LibraryManagementSystem/blob/main/LibraryClassDiagram.png)
I used drowio tool which is an interesting tool to draw diagrams and easy to deal with  
you can add it to vscode as a plugin See [this](https://www.youtube.com/watch?v=OQcWiFA5B_0&t=196s) for more information. 
## Implementation
I used Java to implement the project.  
Applied OOP paradigm.  
The system is console and file based.  
Admin and User classes inherit from Person class.  
BookIO class is composed of Book class , BookIO is responsible for I/O related to Book.  
UserkIO class is composed of User class , UserkIO is responsible for I/O related to User.  
SignUpLogIn class responsible for user login and signup operation.  

## Future updates
* Enhance the time complexity for some functions
* Add new features
* Apply some constraints in some functions (e.g. setters)
* Make the system GUI instead of console
