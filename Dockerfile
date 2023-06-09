FROM openjdk:8u322-slim

WORKDIR /app

COPY ./out/artifacts/msvc_users_jar/msvc-users.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-users.jar"]