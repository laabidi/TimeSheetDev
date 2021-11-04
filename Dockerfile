FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
ADD target/*.jar app.war
EXPOSE 8080
CMD ["java", "-war", "/app/app.war"]