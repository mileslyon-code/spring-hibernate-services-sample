----------------------
1) Database setup
----------------------

You'll need a mysql instance running on the standard port (3306) with a user: root pw: admin.

Alernatively you can alter hibernate.cfg.xml to the user of your choice.

execute generateDB.sql against your MySQL instance

The application will populate tables with demo data on start up

----------------------
2) Project requirements and setup
----------------------

I used to Maven and a pom.xml to set up the project.

You'll need maven installed / in your PATH

'mvn package' should pull down all dependencies

----------------------
3) Structure
----------------------

Controller: We only have one api controller, but it's defined here.

pojo: Our two data entities are defined here.

service: Interface and fake and real implementation of Service Manager handling all data interactions.

utility: A service locator doing simple faux dependency injection to let us run a real or fake implementation of the data layer.

----------------------
4) Running
----------------------

In the root directory type: mvnw spring-boot:run

This will run the application on port 8080

----------------------
5) Testing
----------------------

Using Postman or a browser issue GET requests against the urls below.  The pre-requests scripts and authorization in my screen shots can be ignored.

http://localhost:8080/api/v1/services

--and---

http://localhost:8080/api/v1/services/{id}

