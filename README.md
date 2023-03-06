# TravelAgency
This is a full-stack project about a travel agency app.
CRUD operations are implemented using the following back-end technologies: Java, Spring Boot, Hibernate,
MySQL and Lombok.
For entities the are 10 classes: continent, country, city, airport, hotel, tour, purchasing a tour, role, user, admin. There are many relationships between classes for example class country has a relationship one-to-one to continent, city class has a relationship one-to-one to country class, tour class has a relationship one-to-many with airport class, city class and hotel class. Each entity has a dto class to map data from DB to the client in order to avoid vulnerabilities. Each entity class has a repository interface, a service class where the logic is written and a controller class that interacts with the front end.
A minimal front-end part is developed with Angular.
You can do different things like:
1. Find all tours and details about them.
2. Find tour by id.
3. Create tour.
4. Edit tour by id.
5. Delete tour by id.
