FROM openjdk:17
ARG JAR_FILE=target/loanSolicitudeService.jar
COPY ${JAR_FILE} loanSolicitudeService.jar
ENTRYPOINT ["java", "-jar", "/loanSolicitudeService.jar"]