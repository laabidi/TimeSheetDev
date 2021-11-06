FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
ADD target/*.jar laabidi91.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/laabidi91.jar"]