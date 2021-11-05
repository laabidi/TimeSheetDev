FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/*.jar /
ENTRYPOINT ["java","-jar","/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0-SNAPSHOT.jar"]
