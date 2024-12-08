FROM openjdk:17
ARG JAR_FILE=target/userService.jar
COPY ${JAR_FILE} userService.jar
ENTRYPOINT ["java", "-jar", "/userService.jar"]