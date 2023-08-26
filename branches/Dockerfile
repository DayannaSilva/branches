FROM eclipse-temurin:17-jdk-alpine
EXPOSE 9090
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]