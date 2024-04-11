FROM openjdk:21
EXPOSE 8080:8080
WORKDIR opt/app
COPY target/*.jar my_first_crud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","my_first_crud-0.0.1-SNAPSHOT.jar"]
