#TrainMe

Service which provides easy hiring of coaches, communication between coaches(sport instructors) and their clients. Feedback system helps to find the best coach for client's requirements. Search support allows to set user's search requirements and get appropriate list of coaches from database. Messenger provides an opportunity to users to communicate.
Technology stack: Servlets for controllers layer, JSP for view layer, Bootstrap, Hibernate for data access layer, Ajax for chatting functionality (long pooling method) and search forms auto completion.

##Getting started
###Requirements:
1. Servlet container which supports Servlet 3.0
2. JDK 1.8
3. MySQL database

###Steps:
1. Clone this repository
2. Use database script in src/databaseScript folder and generate the database
3. Edit hibernate.connection.url propery in hibernate.cfg.xml if it needed
4. Deploy project to your local server