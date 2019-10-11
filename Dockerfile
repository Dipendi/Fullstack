FROM openjdk:8
VOLUME /tmp
ADD target/restful-web-services-0.0.1-SNAPSHOT.jar restful-web-services-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","restful-web-services-0.0.1-SNAPSHOT.jar"]