This is a project about a travel agency app where the technologies used are Hibernate, Lombok, MySQL and Spring Boot. For entities the are 10 classes: continent, country, city, airport, hotel, tour, purchasing a tour, role, user, admin. There are many relationships between classes for example class country has a relationship one-to-one to continent, city class has a relationship one-to-one to country class, tour class has a relationship one-to-many with airport class, city class and hotel class.
Each entity has a dto class to map data from DB to the client in order to avoid vulnerabilities.
Each entity class has a repository interface, a service class where the logic is written and a controller class that interacts with the front end.
For each entity CRUD operations are implemented.


