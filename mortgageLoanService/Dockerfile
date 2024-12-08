FROM openjdk:17
ARG JAR_FILE=target/mortgageLoanService.jar
COPY ${JAR_FILE} mortgageLoanService.jar
ENTRYPOINT ["java", "-jar", "/mortgageLoanService.jar"]