FROM openjdk:8u322-slim as builder

WORKDIR /msvc-users

#COPY ./pom.xml /app
COPY ./msvc-users/.mvn ./.mvn
COPY ./msvc-users/mvnw .
COPY ./msvc-users/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./msvc-users/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /msvc-users/target/msvc-users-0.0.1-SNAPSHOT.jar .
EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-users-0.0.1-SNAPSHOT.jar"]