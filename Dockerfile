FROM amazoncorretto:21.0.5
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-slci.jar
EXPOSE 9898
ENTRYPOINT ["java", "-jar", "api-slci.jar"]