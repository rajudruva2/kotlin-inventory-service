FROM gradle:8.12-jdk17 AS build
WORKDIR /src
COPY . .
RUN gradle --no-daemon bootJar
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/build/libs/*.jar app.jar
EXPOSE 8080
USER 10001
ENTRYPOINT ["java","-jar","/app/app.jar"]
