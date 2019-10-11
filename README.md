Angular frontend and Springboot microservice using Docker Compose
======================================================================

1. Create a Dockerfile for creating a docker image from the Spring Boot Application FROM openjdk:8 VOLUME /tmp ADD target/restful-web-services-0.0.1-SNAPSHOT.jar restful-web-services-0.0.1-SNAPSHOT.jar EXPOSE 8080 ENTRYPOINT ["java", "-jar", "springboot-docker-compose.jar"]

2. Create docker-compose.yml `version: '3.5' services: springapi: image: springboot-docker-compose-app:1 build: context: ./ dockerfile: Dockerfile container_name: springapi volumes: - ./data/springboot-docker-compose-app ports: - "8080:8080" networks: - backendNetwork - frontendNetwork angular-service: image: nginx:alpine container_name: angular ports: - 4200:80 depends_on: - springapi ports: - "4200:80" volumes: - ./nginx.conf:/etc/nginx/nginx.conf - ./recipe/dist/recipe/:/usr/share/nginx/html networks: - frontendNetwork

3. Create the Docker image - springboot-docker-compose and nginx:alpine start application using docker compose created in #2. docker-compose up

4. To access the application, use Username - Dipendi, Password - Dipendi 

5. Stop docker container docker-compose down


Basic Understanding of how the flow works
======================================================================

Backend Application:
--------------------

1. target folder containes backend code written in java springboot using CRUD operations 
    create @POST
    Retrieve @GET
    Update @PUT
    Delete @DELETE
    Retrieve by id @GET/{id} (for retrieving specific recipe details)
    
2. There is a use of JPA repository and H2 embedded database. 
    - data.sql file is attahed already. That's why when you launch the application, you will see the data is already present.
    
2. There are testcases written using Mockito Junit framework 
    - still there is an improvement area to write more test cases. currently there are three testcases present.

