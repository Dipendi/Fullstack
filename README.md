##Angular frontend and Springboot microservice using Docker Compose

Create a Dockerfile for creating a docker image from the Spring Boot Application FROM openjdk:8 VOLUME /tmp ADD target/restful-web-services-0.0.1-SNAPSHOT.jar restful-web-services-0.0.1-SNAPSHOT.jar EXPOSE 8080 ENTRYPOINT ["java", "-jar", "springboot-docker-compose.jar"]

Create docker-compose.yml `version: '3.5' services: springapi: image: springboot-docker-compose-app:1 build: context: ./ dockerfile: Dockerfile container_name: springapi volumes: - ./data/springboot-docker-compose-app ports: - "8080:8080" networks: - backendNetwork - frontendNetwork angular-service: image: nginx:alpine container_name: angular ports: - 4200:80 depends_on: - springapi ports: - "4200:80" volumes: - ./nginx.conf:/etc/nginx/nginx.conf - ./recipe/dist/recipe/:/usr/share/nginx/html networks: - frontendNetwork

Create the Docker image - springboot-docker-compose and nginx:alpine start application using docker compose created in #2. docker-compose up

Stop docker container docker-compose down