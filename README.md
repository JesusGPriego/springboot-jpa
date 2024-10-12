# Springboot - JPA

This is a simple project whose main topic is JPA.

JPA allow us to access ddbb via ORM, which let us decide how to select data, being able to choose sql, jpql or OOP thanks to, for example, hibernate.

This is useful for monitoring, logging, authentication and permission, for example.

As usual, project architecture follows MVC pattern.

## FYI

This project uses mysql as Database. there is no need to install it since there is a docker-compose file in the project. Details on how to start it below.

## Requirements

* Java 21
* Docker

## How to use

 1. Create env.properties from env.properties.template and set values for the keys.
 2. Create .env file from env.template and set values to the keys.

Then, located in project base folder, execute

`docker compose up` or `docker compose up -d`


Once the image is downloaded and the container is running:

`./mvnw spring-boot:run`
 

Build:

```
./mwnv clean package
cd /target
java -jar xxx.jar
```

## OpenAPI

to check swagger and asuming the application is running locally, open a web browser and paste

`http://localhost:8080/swagger-ui/index.html`