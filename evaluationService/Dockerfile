FROM openjdk:17
ARG JAR_FILE=target/evaluationService.jar
COPY ${JAR_FILE} evaluationService.jar
ENTRYPOINT ["java", "-jar", "/mortgageLoanService.jar"]