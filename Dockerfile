FROM eclipse-temurin:27-jre-alpine

WORKDIR /app

RUN addgroup -S springgroup && adduser -S springuser -G springgroup

COPY app.jar app.jar

USER springuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]